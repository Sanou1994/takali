(this["webpackJsonp@coreui/coreui-free-react-admin-template"]=this["webpackJsonp@coreui/coreui-free-react-admin-template"]||[]).push([[77],{1130:function(e,t,a){},1459:function(e,t,a){"use strict";a.r(t);var i=a(159),r=a(160),o=a(162),n=a(161),c=a(1),s=(a(648),a(665),a(782)),l=(a(660),a(679),a(647)),u=(a(1130),a(2)),d=function(e){Object(o.a)(a,e);var t=Object(n.a)(a);function a(e){var r;return Object(i.a)(this,a),(r=t.call(this,e)).state={ok:""},r}return Object(r.a)(a,[{key:"componentDidMount",value:function(){var e=JSON.parse(localStorage.getItem("token_auth"));try{var t=localStorage.getItem("idReservationVisiteur"),a={method:"POST",headers:{"Content-Type":"application/json",Accept:"application/json",Authorization:"Bearer "+e.token},body:JSON.stringify({id:t,status:"PAYE"})};console.log("data envoi",a.body),t&&fetch(l.a.url+"reservation/update/status",a).then((function(e){return e.json()})).then((function(e){console.log("data reservation paye",e),localStorage.removeItem("idEquipePaye"),localStorage.removeItem("idReservationVisiteur"),localStorage.removeItem("idTransactionVisiteur")}))}catch(c){}try{var i=localStorage.getItem("idTransactionVisiteur"),r={method:"POST",headers:{Authorization:"Bearer "+e.token},body:JSON.stringify({id:i,status:"PAYE"})};i&&fetch(l.a.url+"transaction/update",r).then((function(e){return e.json()})).then((function(e){console.log("data transaction paye",e),localStorage.removeItem("idEquipePaye"),localStorage.removeItem("idReservationVisiteur"),localStorage.removeItem("idTransactionVisiteur")}))}catch(c){}try{var o=localStorage.getItem("idEquipePaye"),n={method:"POST",headers:{Authorization:"Bearer "+e.token},body:JSON.stringify({id:o,paye:!0})};o&&fetch(l.a.url+"equipe/update/paye",n).then((function(e){return e.json()})).then((function(e){console.log("data equipe paye",e),localStorage.removeItem("idEquipePaye"),localStorage.removeItem("idReservationVisiteur"),localStorage.removeItem("idTransactionVisiteur")}))}catch(c){}}},{key:"render",value:function(){return Object(u.jsx)(u.Fragment,{children:Object(u.jsx)("div",{className:"c-app c-default-layout flex-row align-items-center",children:Object(u.jsx)("div",{class:"container",children:Object(u.jsx)("div",{class:"row",children:Object(u.jsx)("div",{class:"col-md-6 mx-auto mt-5",children:Object(u.jsxs)("div",{class:"payment",children:[Object(u.jsx)("div",{class:"payment_header text-center",children:Object(u.jsx)("img",{src:s.a,alt:"",width:"250",height:"100"})}),Object(u.jsxs)("div",{class:"content",children:[Object(u.jsx)("h1",{children:"Paiement r\xe9ussi !"}),Object(u.jsx)("p",{children:"Votre paiment a \xe9t\xe9 effectu\xe9. Merci d'avoir choisi O-Terrain ! "}),Object(u.jsx)("a",{href:"/#/accueil-visiteur",children:"Retour \xe0 l'accueil"})]})]})})})})})})}}]),a}(c.Component);t.default=d},647:function(e,t,a){"use strict";t.a={type_tournoi:{TOURNOI_INTER_ECOLE:"TOURNOI_INTER_ECOLE",TOURNOI_INTER_ENTREPRISE:"TOURNOI_INTER_ENTREPRISE"},url:"https://o-terrain.com/"}},782:function(e,t,a){"use strict";t.a=a.p+"static/media/ot.79b466ac.png"}}]);
//# sourceMappingURL=77.2600d79d.chunk.js.map