<?php

namespace App\Controller\Admin\Crud;

use Exception;
use App\Entity\Agenda;
use App\Form\ImportDataType;
use App\ImportData\ImportData;
use App\Services\ServiceSearch;
use App\Entity\Lieu;
use App\Form\Admin\Crud\AgendaType;
use App\Form\Admin\Crud\LieuType;
use App\Repository\AgendaRepository;
use PhpOffice\PhpSpreadsheet\IOFactory;
use Doctrine\ORM\EntityManagerInterface;
use PhpOffice\PhpSpreadsheet\Writer\Csv;
use PhpOffice\PhpSpreadsheet\Spreadsheet;
use PhpOffice\PhpSpreadsheet\Writer\Xlsx;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use App\Services\DataTransformer\DataTransformer;
use PhpParser\Node\Stmt\Const_;
use Symfony\Component\String\Slugger\SluggerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\File\Exception\FileException;

/**
 * @Route("/agenda")
 */
class AgendaController extends AbstractController
{
    public const TEXT=[
        'A1'=>'User_Id',
        'B1'=>'Sous_Rubrique',
        'C1'=>'Lieu',
        'D1'=>'Titre',
        'E1'=>'Emplacement',
        'F1'=>'Niveau',
        'G1'=>'Date_Debut',
        'H1'=>'Date_Fin', 
        'I1'=>'Qualification',
        'J1'=>'Slug',
        
    ];
    public const TITRE = 'titre';
    public const LIEU = 'lieu';
    public const SOUSRUBRIQUE = 'sousRubrique';
    public const EMPLACEMENT = 'emplacement';
    private $agendaFinder;

    private $entityManager;

    public function __construct($agendaFinder, EntityManagerInterface $entityManager)
    {
        $this->agendaFinder = $agendaFinder;
        $this->entityManager = $entityManager;
    }
    /**
     * @Route("/", name="agenda_index", methods={"GET","POST"})
     */
    public function index(Request $request, AgendaRepository $agendaRepository, ServiceSearch $serviceSearch, SluggerInterface $slugger, DataTransformer $dataTransformer): Response
    {
        if (!$this->getUser()) {
            return $this->redirectToRoute('app_login');
        }
        $q = ''; //get via axios PEF

        if (isset($q) && !empty($q)) {
            $searchAgenda = $serviceSearch->searchCustom(
                $q,
                [self::TITRE, self::LIEU, self::SOUSRUBRIQUE, self::EMPLACEMENT],
                $this->agendaFinder
            );
            return $this->render('Admin/Crud/agenda/index.html.twig', [
                'agendas' => $agendaRepository->findAll(),
                'searchAgenda' => $searchAgenda
            ]);
        }

        // Inporter agenda
        $import = new ImportData();
        $form = $this->createForm(ImportDataType::class, $import);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {
            $importFile = $form->get('fichier')->getData();

            if ($importFile) {
                $originalFilename = pathinfo($importFile->getClientOriginalName(), PATHINFO_FILENAME);


                $newFilename = $originalFilename . '.csv';
                try {
                    $importFile->move(
                        $this->getParameter('chemin_fichier'),
                        $newFilename
                    );
                } catch (FileException $e) {
                    die('erreur lors du deplacement du fichier' . $e->getMessage());
                }

                $spreadsheet = IOFactory::load($this->getParameter('chemin_fichier') . $newFilename);
                
                $Row = $spreadsheet->getActiveSheet()->removeRow(1); 
                $sheetData = $spreadsheet->getActiveSheet()->toArray(null, true, true, true); 
               // dd($sheetData);
                $entityManager = $this->getDoctrine()->getManager();

                foreach ($sheetData as $agendas) {
                    //dd($agendas);

                    $user = $dataTransformer->transformUser($agendas['A']); // store the first_name on each iteration 
                    //dd($user);
                    $SousRubrique = $dataTransformer->transformSousRubrique($agendas['B']); // store the last_name on each iteration
                    $lieu = $dataTransformer->transz($agendas['C']);     // store the email on each iteration
                    //$dateDebut = $agendas['D'];   // store the phone on each iteration 
                    $titre = $agendas['D'];
                    $emplacement = $agendas['E'];
                    $niveau = $agendas['F']; 
                    /* $dateDebut= $agendas['G'];
                    $dateFin = $agendas['H'];  */ //TO DO
                    $qualification = $agendas['I']; 
                    $slug = $agendas['J'];
                   
                    $agenda = new Agenda();
                    $agenda->setUser($user);
                    $agenda->setSousRubrique($SousRubrique);
                    $agenda->setLieu($lieu);
                    $agenda->setTitre($titre);
                    $agenda->setEmplacement($emplacement);
                    $agenda->setNiveauEmplacement($niveau);
                   /*  $agenda->setDateDebut($dateDebut);
                    $agenda->setDateFinAt($dateFin); */  // TO DO
                    $agenda->setQualification($qualification);
                    $agenda->setSlug($slug);
                    $entityManager->persist($agenda);
                    $entityManager->flush();
                   
                }
                return $this->json('agenda ajoute avec succe', 200);
            }
        }
        //dd($import->getFichier());
        return $this->render('Admin/Crud/agenda/index.html.twig', [
            'agendas' => $agendaRepository->findAll(),
            'form' => $form->createView(),

        ]);
    }
    /**
     * @Route("/online/{id}",name="agenda_index_actived")
     */
    public function ActiverAgenda($id, EntityManagerInterface $em, AgendaRepository $agendaRepo): Response
    {
        $getAgenda = $agendaRepo->findOneBy(['id' => $id]);
        if (!isset($getAgenda)) return  $this->json([
            'code' => 404,
            'message' => 'La publicite n\'existe pas'
        ], 404);
        if ($getAgenda->getIsPublished() === false) {
            $getAgenda->setIsPublished(true);
            $em->persist($getAgenda);
            $em->flush();
            return $this->json([
                'code' => 200,
                'message' => 'Publier avec succès',
                'valeurPub' => $getAgenda->getIsPublished()
            ], 200);
        }
        $getAgenda->setIsPublished(false);
        $em->persist($getAgenda);
        $em->flush();

        return $this->json([
            'code' => 200,
            'message' => 'non publier',
            'valeurPub' => $getAgenda->getIsPublished()
        ], 200);
    }
    /**
     * @Route("/duplicate/{id}",name="agenda_index_duplicate")
     */
    public function duplicateAgenda(Request $request, SluggerInterface $slugger,$id, EntityManagerInterface $em, AgendaRepository $agendaRepo,Agenda $agenda): Response
    {
        $getAgendaToDuplicate = $agendaRepo->findOneBy(['id' => $id]);
        if (!isset($getAgendaToDuplicate)) {
            $this->addFlash('success', 'non dupliquer');
            return $this->redirectToRoute('agenda_index');
        }else{
        $agendaDuplicat = new Agenda();
        $agendaDuplicat->setTitre($getAgendaToDuplicate->getTitre())
            ->setSlug($getAgendaToDuplicate->getSlug())
            ->setSousRubrique($getAgendaToDuplicate->getSousRubrique())
            ->setLieu($getAgendaToDuplicate->getLieu())
            ->setUser($getAgendaToDuplicate->getUser())
            ->setDateDebut($getAgendaToDuplicate->getDateDebut())
            ->setDateFinAt($getAgendaToDuplicate->getDateFinAt())
            ->setNiveauEmplacement($getAgendaToDuplicate->getNiveauEmplacement())
            ->setEmplacement($getAgendaToDuplicate->getEmplacement())
            ->setQualification($getAgendaToDuplicate->getQualification())
            ->setAgeDe($getAgendaToDuplicate->getAgeDe())
            ->setTarifEnfant($getAgendaToDuplicate->getTarifEnfant())
            ->setContenu($getAgendaToDuplicate->getContenu())
            ->setSlug($getAgendaToDuplicate->getSlug())
            ->setVisuel($getAgendaToDuplicate->getVisuel())
            ->setCodeEmbedVideo($getAgendaToDuplicate->getCodeEmbedVideo())
            ->setIsPublished($getAgendaToDuplicate->getIsPublished())
            ->setSousRubrique($getAgendaToDuplicate->getSousRubrique())
            ->setCopyright($getAgendaToDuplicate->getCopyright());
        $em->persist($agendaDuplicat);
        $em->flush();
        $id=$agenda->getId();

        $this->addFlash('success', 'Duplication avec succes');
         return $this->redirectToRoute('agenda_edit', [
            'id' => $agenda->getId()]);   
    }
    }

    /**
     * @Route("/new", name="agenda_new", methods={"GET","POST"})
     */
  
    public function new(Request $request, SluggerInterface $slugger,EntityManagerInterface $em): Response
    {      
        $lieu = new Lieu();
        $formLieu = $this->createForm(LieuType::class, $lieu);
        $formLieu->handleRequest($request);
      
       
        if ($request->isXmlHttpRequest()) {   
           $lieuNom = $request->request->get('nom');
           $lieuCode = $request->request->get('code');
           $lieuSite = $request->request->get('site');
           $lieuLatitude = $request->request->get('latitude');
           $lieuAdresse = $request->request->get('adresse');
           $lieuVille = $request->request->get('ville');
           $lieuTelephone = $request->request->get('telephone');
           $lieuLongitude = $request->request->get('longitude');
           $lieu->setNom($lieuNom);
           $lieu->setCodePostal($lieuCode);
           $lieu->setSiteWeb($lieuSite);
           $lieu->setLatitude($lieuLatitude);
           $lieu->setAdresse($lieuAdresse);
           $lieu->setVille($lieuVille);
           $lieu->setTelephone($lieuTelephone);
           $lieu->setLongitude($lieuLongitude);
           $em = $this->getDoctrine()->getManager();         
           $em->persist($lieu);
           $em->flush();
           
        }
        $agenda = new Agenda();
        $form = $this->createForm(AgendaType::class, $agenda);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {
            $agendaFile = $form->get('visuel')->getData();
            if ($agendaFile) {
                $originalFilename = pathinfo($agendaFile->getClientOriginalName(), PATHINFO_FILENAME);
                $safeFilename = $slugger->slug($originalFilename);
                $newFilename = $safeFilename . '-' . uniqid() . '.' . $agendaFile->guessExtension();
                try {
                    $agendaFile->move(
                        $this->getParameter('chemin_image'),
                        $newFilename
                    );
                } catch (FileException $e) {
                    die('erreur lors du deplacement du fichier' . $e->getMessage());
                }
                $agenda->setVisuel($newFilename);
            }
            $em = $this->getDoctrine()->getManager();
            $em->persist($agenda);
            $em->flush();
            
            return $this->redirectToRoute('agenda_index');
        }
        return $this->render('Admin/Crud/agenda/new.html.twig', [
            'agenda' => $agenda,
            'form' => $form->createView(),
            'lieu' => $lieu,
            'formLieu' => $formLieu->createView(),
            
        ]);
    }

    private function getData(): array
    {

        $list = [];
        $agendas = $this->entityManager->getRepository(Agenda::class)->findAll();

        foreach ($agendas as $agenda) {
            $list[] = [
                //$agenda->getId(),
                $agenda->getUser(),
                $agenda->getSousRubrique(),
                $agenda->getLieu(),
                $agenda->getTitre(),
                $agenda->getEmplacement(),
                $agenda->getNiveauEmplacement(),
                $agenda->getDateDebut(),
                $agenda->getDateFinAt(),  
                $agenda->getQualification(),
                $agenda->getSlug(),
            ];
        }
        return $list;
    }


    /**
     * @Route("/export", name="agenda_export")
     */
    public function export(): Response
    {

        $spreadsheet = new Spreadsheet();

        $sheet = $spreadsheet->getActiveSheet();

        $sheet->setTitle('Agenda List');
        
          foreach(self::TEXT as $key => $value){
            $sheet->getCell( $key)->setValue($value);   
          }

        $sheet->fromArray($this->getData(), null, 'A2', true);

        $date = date('d-m-y-' . substr((string)microtime(), 1, 8));
        $date = str_replace(".", "", $date);
        $filename = "agenda_" . $date . ".csv";

        try {
            //$writer = new Xlsx($response["spreadsheet"]);
            $writer = new Csv($spreadsheet);
            $writer->setDelimiter(';');
            $writer->setEnclosure('"');
            $writer->setLineEnding("\r\n");
            $writer->setSheetIndex(0);
            $writer->save($filename);
            $content = file_get_contents($filename);
        } catch (Exception $e) {
            exit($e->getMessage());
        }

        header("Content-Disposition: attachment; filename=" . $filename);

        unlink($filename);
        exit($content);


        return $this->redirectToRoute('agenda_index');
    }



    /**
     * @Route("/{id}", name="agenda_show", methods={"GET"})
     */
    public function show(Agenda $agenda): Response
    {
        return $this->render('Admin/Crud/agenda/show.html.twig', [
            'agenda' => $agenda,
        ]);
    }

    /**
     * @Route("/{id}/edit", name="agenda_edit", methods={"GET","POST"})
     */
    public function edit(Request $request, SluggerInterface $slugger, Agenda $agenda): Response
    {
        $form = $this->createForm(AgendaType::class, $agenda);
        $form->handleRequest($request);
        $lieu = new Lieu();
        $formLieu = $this->createForm(LieuType::class, $lieu);
        $formLieu->handleRequest($request);

        if ($request->isXmlHttpRequest()) {   
            $lieuNom = $request->request->get('nom');
            $lieuCode = $request->request->get('code');
            $lieuSite = $request->request->get('site');
            $lieuLatitude = $request->request->get('latitude');
            $lieuAdresse = $request->request->get('adresse');
            $lieuVille = $request->request->get('ville');
            $lieuTelephone = $request->request->get('telephone');
            $lieuLongitude = $request->request->get('longitude');
            $lieu->setNom($lieuNom );
            $lieu->setCodePostal($lieuCode );
            $lieu->setSiteWeb($lieuSite );
            $lieu->setLatitude($lieuLatitude);
            $lieu->setAdresse($lieuAdresse );
            $lieu->setVille($lieuVille );
            $lieu->setTelephone($lieuTelephone );
            $lieu->setLongitude($lieuLongitude );
            $entityManager = $this->getDoctrine()->getManager();         
            $entityManager->persist($lieu);
            $entityManager->flush();
            
         }

        if ($form->isSubmitted() && $form->isValid()) {
            $agendaFile = $form->get('visuel')->getData();
            if ($agendaFile) {
                $originalFilename = pathinfo($agendaFile->getClientOriginalName(), PATHINFO_FILENAME);
                $safeFilename = $slugger->slug($originalFilename);
                $newFilename = $safeFilename . '-' . uniqid() . '.' . $agendaFile->guessExtension();
                try {
                    $agendaFile->move(
                        $this->getParameter('chemin_image'),
                        $newFilename
                    );
                } catch (FileException $e) {
                    die('erreur lors du deplacement du fichier' . $e->getMessage());
                }
                $agenda->setVisuel($newFilename);
            }
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('agenda_index');
        }

        return $this->render('Admin/Crud/agenda/edit.html.twig', [
            'agenda' => $agenda,
            'form' => $form->createView(),
            'lieu' => $lieu,
            'formLieu' => $formLieu->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="agenda_delete", methods={"DELETE"})
     */
    public function delete(Request $request, Agenda $agenda): Response
    {
        if ($this->isCsrfTokenValid('delete' . $agenda->getId(), $request->request->get('_token'))) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($agenda);
            $entityManager->flush();
        }

        return $this->redirectToRoute('agenda_index');
    }

      /**
     * @Route("/{id}", name="delete_a_la_une")
     */
    public function deleteUne(Request $request, Agenda $agenda): Response
    {
      
        if ($agenda->getEmplacement()=="Une" ||  $agenda->getEmplacement()=="En ce moment"  ||  $agenda->getEmplacement()=="Thema") {
            $agenda->setNiveauEmplacement('null');
            $agenda->setEmplacement('null');
        }
        $this->getDoctrine()->getManager()->flush();
       
        return $this->redirectToRoute('app_admin');
    }

 
        /**
     * @Route("/modal", name="lieu_modal", methods={"GET","POST"})
     */
    public function modal(Request $request): Response
    {
        $lieu = new Lieu();
        $formLieu = $this->createForm(LieuType::class, $lieu);
        $formLieu->handleRequest($request);
        if ($formLieu->isSubmitted() && $formLieu->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($lieu);
            $entityManager->flush();
            return $this->redirectToRoute('agenda_new');
        }
         return $this->render('Admin/Crud/agenda/new.html.twig', [
          'lieu' => $lieu,
           'formLieu' => $formLieu->createView(),
       ]);    
    }


    
}
