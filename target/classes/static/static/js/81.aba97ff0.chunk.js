(this["webpackJsonp@coreui/coreui-free-react-admin-template"]=this["webpackJsonp@coreui/coreui-free-react-admin-template"]||[]).push([[81],{1438:function(e,t,s){"use strict";s.r(t);var a=s(159),r=s(160),c=s(162),i=s(161),o=s(1),n=(s(164),s(648)),l=s(938),d=(s(649),s(670),s(668),s(651)),p=s(665),u=(s(653),s(2)),h=Object(u.jsx)("div",{className:"pt-3 text-center",children:Object(u.jsx)("div",{className:"sk-spinner sk-spinner-pulse"})}),j=function(e){Object(c.a)(s,e);var t=Object(i.a)(s);function s(e){var r;return Object(a.a)(this,s),(r=t.call(this,e)).state={textApropos:"",ok:"",titreApropos:"",idApropos:0,telephone:"",email:"",adresse:"",service:[],video:"",video_joutube:"",page:Object(u.jsx)("div",{style:{marginTop:"25%",marginBottom:"20%",textAlign:"center"},children:Object(u.jsx)(l.a,{type:"grow",color:"success"})}),status:!0},r}return Object(r.a)(s,[{key:"componentDidMount",value:function(){var e=this,t={method:"GET"};fetch(d.a.url+"acceuil/propos/propos",t).then((function(e){return e.json()})).then((function(t){console.log("propos====>",t),e.setState({status:!1});try{e.setState({titreApropos:t[0].titre}),e.setState({textApropos:t[0].text}),e.setState({adresse:t[0].adresse}),e.setState({telephone:t[0].telephone}),e.setState({email:t[0].email}),e.setState({video_joutube:t[0].urlVideo}),e.setState({idApropos:t[0].id}),e.setState({status:!1})}catch(s){}})),fetch(d.a.url+"acceuil/fichier/fichiers",t).then((function(e){return e.json()})).then((function(t){console.log("fichier====>",t),t.map((function(t,s){try{t.multimedia&&p.a.ref("images").child(t.multimedia.file).getDownloadURL().then((function(s){"VIDEO_PRESENTATION"===t.typeFichier&&(e.setState({video:s}),console.log("fichierZErrr====>",s))}))}catch(a){e.setState({video:""})}}))}))}},{key:"render",value:function(){return Object(u.jsxs)(u.Fragment,{children:[this.state.ok,Object(u.jsx)(n.h,{className:"mt-5",fluid:!0,children:Object(u.jsx)(o.Suspense,{fallback:h,children:this.state.status?Object(u.jsx)(u.Fragment,{children:this.state.page}):Object(u.jsxs)(n.n,{children:[Object(u.jsx)("div",{className:"mt-5"}),Object(u.jsxs)("section",{id:"about",class:"about",children:[Object(u.jsx)("div",{class:"section-title mt-5",children:Object(u.jsx)("h2",{children:"A propos"})}),Object(u.jsxs)("div",{class:"row",children:[Object(u.jsx)("div",{class:"col-lg-6 col-md-12 col-sm-12 order-1 order-lg-2",children:Object(u.jsx)("div",{className:"embed-responsive embed-responsive-16by9 mb-4",children:Object(u.jsx)("iframe",{className:"embed-responsive-item",src:this.state.video,height:"100",width:"200",allowfullscreen:!0,frameborder:"4"})})}),Object(u.jsxs)("div",{class:"col-lg-6 col-md-12 col-sm-12 pt-4 pt-lg-0 order-2 order-lg-1 content",children:[Object(u.jsx)("h3",{class:"text-center",children:this.state.titreApropos}),Object(u.jsx)("p",{class:"text-justify",children:this.state.textApropos})]})]})]})]})})})]})}}]),s}(o.Component);t.default=j},651:function(e,t,s){"use strict";t.a={type_tournoi:{TOURNOI_INTER_ECOLE:"TOURNOI_INTER_ECOLE",TOURNOI_INTER_ENTREPRISE:"TOURNOI_INTER_ENTREPRISE"},url:"http://o-terrain.com/"}},665:function(e,t,s){"use strict";s.d(t,"a",(function(){return r}));var a=s(666);s(699);a.a.initializeApp({apiKey:"AIzaSyAEAU3GMvWGKcakyDnkICPmkVZaDCFRX08",authDomain:"oterrain-6822f.firebaseapp.com",projectId:"oterrain-6822f",storageBucket:"oterrain-6822f.appspot.com",messagingSenderId:"309004801581",appId:"1:309004801581:web:a535282f9a8c79328e0aa4",measurementId:"G-DZWQ4BHVY3"});var r=a.a.storage()},938:function(e,t,s){"use strict";var a=s(11),r=s(26),c=s(1),i=s.n(c),o=s(107),n=s.n(o),l=s(157),d=s.n(l),p=s(647),u={tag:p.n,type:n.a.string,size:n.a.string,color:n.a.string,className:n.a.string,cssModule:n.a.object,children:n.a.string},h=function(e){var t=e.className,s=e.cssModule,c=e.type,o=e.size,n=e.color,l=e.children,u=e.tag,h=Object(r.a)(e,["className","cssModule","type","size","color","children","tag"]),j=Object(p.j)(d()(t,!!o&&"spinner-"+c+"-"+o,"spinner-"+c,!!n&&"text-"+n),s);return i.a.createElement(u,Object(a.a)({role:"status"},h,{className:j}),l&&i.a.createElement("span",{className:Object(p.j)("sr-only",s)},l))};h.propTypes=u,h.defaultProps={tag:"div",type:"border",children:"Loading..."},t.a=h}}]);
//# sourceMappingURL=81.aba97ff0.chunk.js.map