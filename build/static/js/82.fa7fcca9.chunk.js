(this["webpackJsonpo-terrain"]=this["webpackJsonpo-terrain"]||[]).push([[82],{647:function(e,s,t){"use strict";s.a={type_tournoi:{TOURNOI_INTER_ECOLE:"TOURNOI_INTER_ECOLE",TOURNOI_INTER_ENTREPRISE:"TOURNOI_INTER_ENTREPRISE"},url:"https://o-terrain.com/"}},999:function(e,s,t){"use strict";t.r(s);var c=t(159),a=t(160),i=t(162),n=t(161),l=t(1),r=t(648),o=t(647),d=t(660),j=t.n(d),h=t(2),b=Object(h.jsx)("div",{className:"pt-3 text-center",children:Object(h.jsx)("div",{className:"sk-spinner sk-spinner-pulse"})}),m=function(e){Object(i.a)(t,e);var s=Object(n.a)(t);function t(e){var a;return Object(c.a)(this,t),(a=s.call(this,e)).charging=function(){j()("#msg").css("display","none"),j()("#chargement").css("display","none")},a.handleSendMessage=function(){j()("#chargement").css("display","block"),j()("#initial").css("display","none");var e={name:j()("#nom").val(),email:j()("#email").val(),subject:j()("#objet").val(),message:j()("#message").val()},s={method:"POST",headers:{"Content-Type":"application/json",Accept:"application/json"},body:JSON.stringify(e)};fetch(o.a.url+"acceuil/user/contacter",s).then((function(e){j()("#chargement").css("display","none"),j()("#initial").css("display","none"),j()("#msg").css("display","block"),j()("#nom").val(""),j()("#email").val(""),j()("#subject").val(""),j()("#message").val("")}))},a.state={textApropos:"",ok:"",titreApropos:"",idApropos:0,telephone:"",email:"",adresse:"",service:[],video_joutube:"",video:""},a}return Object(a.a)(t,[{key:"componentDidMount",value:function(){var e=this;this.charging(),fetch(o.a.url+"acceuil/propos/propos",{method:"GET"}).then((function(e){return e.json()})).then((function(s){console.log("propos====>",s);try{e.setState({titreApropos:s[0].titre}),e.setState({textApropos:s[0].text}),e.setState({adresse:s[0].adresse}),e.setState({telephone:s[0].telephone}),e.setState({email:s[0].email}),e.setState({video_joutube:s[0].urlVideo}),e.setState({idApropos:s[0].id}),localStorage.setItem("contact",JSON.stringify({telephone:s[0].telephone,email:s[0].email}))}catch(t){}}))}},{key:"render",value:function(){return Object(h.jsxs)(h.Fragment,{children:[this.state.ok,Object(h.jsx)(r.h,{fluid:!0,children:Object(h.jsx)(l.Suspense,{fallback:b,children:Object(h.jsx)(r.n,{children:Object(h.jsxs)("div",{class:"container",children:[Object(h.jsx)("div",{class:"section-title",children:Object(h.jsx)("h2",{children:"Contact"})}),Object(h.jsx)("section",{id:"contact",class:"contact",children:Object(h.jsxs)("div",{class:"container",children:[Object(h.jsx)("div",{class:"section-title",children:Object(h.jsx)("h2",{children:"Contact"})}),Object(h.jsxs)("div",{class:"row",children:[Object(h.jsx)("div",{class:"col-lg-5 d-flex align-items-stretch",children:Object(h.jsxs)("div",{class:"info",children:[Object(h.jsxs)("div",{class:"address",children:[Object(h.jsx)("i",{class:"icofont-google-map"}),Object(h.jsx)("h4",{children:"Adresse:"}),Object(h.jsx)("p",{children:this.state.adresse})]}),Object(h.jsxs)("div",{class:"email",children:[Object(h.jsx)("i",{class:"icofont-envelope"}),Object(h.jsx)("h4",{children:"Email:"}),Object(h.jsx)("p",{children:this.state.email})]}),Object(h.jsxs)("div",{class:"phone",children:[Object(h.jsx)("i",{class:"icofont-phone"}),Object(h.jsx)("h4",{children:"T\xe9l\xe9phone:"}),Object(h.jsx)("p",{children:this.state.telephone})]})]})}),Object(h.jsx)("div",{class:"col-lg-7 mt-5 mt-lg-0 d-flex align-items-stretch",children:Object(h.jsxs)("div",{class:"php-email-form",children:[Object(h.jsxs)("div",{class:"form-row",children:[Object(h.jsxs)("div",{class:"form-group col-md-6",children:[Object(h.jsx)("label",{for:"name",children:"Votre nom"}),Object(h.jsx)("input",{type:"text",name:"name",class:"form-control",id:"nom","data-rule":"minlen:4","data-msg":"Please enter at least 4 chars"}),Object(h.jsx)("div",{class:"validate"})]}),Object(h.jsxs)("div",{class:"form-group col-md-6",children:[Object(h.jsx)("label",{for:"name",children:"Votre Email"}),Object(h.jsx)("input",{type:"email",class:"form-control",id:"email","data-rule":"email","data-msg":"Please enter a valid email"}),Object(h.jsx)("div",{class:"validate"})]})]}),Object(h.jsxs)("div",{class:"form-group",children:[Object(h.jsx)("label",{for:"name",children:"Objet"}),Object(h.jsx)("input",{type:"text",class:"form-control",id:"objet","data-rule":"minlen:4","data-msg":"Please enter at least 8 chars of subject"}),Object(h.jsx)("div",{class:"validate"})]}),Object(h.jsxs)("div",{class:"form-group",children:[Object(h.jsx)("label",{for:"name",children:"Message"}),Object(h.jsx)("textarea",{class:"form-control",id:"message",rows:"10","data-rule":"required","data-msg":"Please write something for us"}),Object(h.jsx)("div",{class:"validate"})]}),Object(h.jsxs)("div",{class:"mb-3",children:[Object(h.jsx)("div",{class:"loading",children:"Chargement"}),Object(h.jsx)("div",{class:"error-message"}),Object(h.jsx)("div",{class:"sent-message",children:"Votre message a \xe9t\xe9 envoy\xe9. Merci !"})]}),Object(h.jsx)("div",{id:"initial",class:"text-center",children:Object(h.jsx)("button",{onClick:this.handleSendMessage,id:"submit",children:"Envoyer"})}),Object(h.jsx)("div",{id:"chargement",class:"text-center",children:Object(h.jsxs)("button",{id:"submit",children:[Object(h.jsx)("span",{className:"spinner-border spinner-border-sm",role:"status","aria-hidden":"true",children:" "})," Envoi..."]})}),Object(h.jsx)("div",{id:"msg",class:"sent-message",children:"Votre message a \xe9t\xe9 envoy\xe9. Merci !"})]})})]})]})})]})})})})]})}}]),t}(l.Component);s.default=m}}]);
//# sourceMappingURL=82.fa7fcca9.chunk.js.map