(this["webpackJsonp@coreui/coreui-free-react-admin-template"]=this["webpackJsonp@coreui/coreui-free-react-admin-template"]||[]).push([[74],{651:function(e,t,s){"use strict";t.a={type_tournoi:{TOURNOI_INTER_ECOLE:"TOURNOI_INTER_ECOLE",TOURNOI_INTER_ENTREPRISE:"TOURNOI_INTER_ENTREPRISE"},url:"http://o-terrain.com/"}},687:function(e,t,s){"use strict";function r(e,t){(null==t||t>e.length)&&(t=e.length);for(var s=0,r=new Array(t);s<t;s++)r[s]=e[s];return r}function n(e){return function(e){if(Array.isArray(e))return r(e)}(e)||function(e){if("undefined"!==typeof Symbol&&Symbol.iterator in Object(e))return Array.from(e)}(e)||function(e,t){if(e){if("string"===typeof e)return r(e,t);var s=Object.prototype.toString.call(e).slice(8,-1);return"Object"===s&&e.constructor&&(s=e.constructor.name),"Map"===s||"Set"===s?Array.from(e):"Arguments"===s||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(s)?r(e,t):void 0}}(e)||function(){throw new TypeError("Invalid attempt to spread non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}()}s.d(t,"a",(function(){return n}))},767:function(e,t,s){"use strict";var r=s(11),n=s(26),a=s(1),c=s.n(a),i=s(107),o=s.n(i),l=s(157),d=s.n(l),j=s(644),b={tag:j.n,inverse:o.a.bool,color:o.a.string,body:o.a.bool,outline:o.a.bool,className:o.a.string,cssModule:o.a.object,innerRef:o.a.oneOfType([o.a.object,o.a.string,o.a.func])},u=function(e){var t=e.className,s=e.cssModule,a=e.color,i=e.body,o=e.inverse,l=e.outline,b=e.tag,u=e.innerRef,h=Object(n.a)(e,["className","cssModule","color","body","inverse","outline","tag","innerRef"]),m=Object(j.j)(d()(t,"card",!!o&&"text-white",!!i&&"card-body",!!a&&(l?"border":"bg")+"-"+a),s);return c.a.createElement(b,Object(r.a)({},h,{className:m,ref:u}))};u.propTypes=b,u.defaultProps={tag:"div"},t.a=u},768:function(e,t,s){"use strict";var r=s(11),n=s(26),a=s(1),c=s.n(a),i=s(107),o=s.n(i),l=s(157),d=s.n(l),j=s(644),b={tag:j.n,className:o.a.string,cssModule:o.a.object,innerRef:o.a.oneOfType([o.a.object,o.a.string,o.a.func])},u=function(e){var t=e.className,s=e.cssModule,a=e.innerRef,i=e.tag,o=Object(n.a)(e,["className","cssModule","innerRef","tag"]),l=Object(j.j)(d()(t,"card-body"),s);return c.a.createElement(i,Object(r.a)({},o,{className:l,ref:a}))};u.propTypes=b,u.defaultProps={tag:"div"},t.a=u},869:function(e,t,s){"use strict";s.r(t);var r=s(687),n=s(159),a=s(160),c=s(165),i=s(162),o=s(161),l=s(1),d=s.n(l),j=s(994),b=s(801),u=s(818),h=s(819),m=s(767),O=s(768),p=s(820),x=s(651),f=s(998),v=s(653),g=s.n(v),N=s(2),y=function(e){Object(i.a)(s,e);var t=Object(o.a)(s);function s(e){var r;return Object(n.a)(this,s),(r=t.call(this,e)).handleTerrainClick=function(e){r.setState({detailModal:!0,periode:e}),r.toggle()},r.state={users:[],userData:[],id:0,show:!1,ok:"",reservations:[],detailModal:!1,periode:"jj;ee"},r.handleTerrainClick.bind(Object(c.a)(r)),r}return Object(a.a)(s,[{key:"componentDidMount",value:function(){var e=this,t=JSON.parse(localStorage.getItem("token_auth"));g()("#chargement").css("display","none");var s={headers:{Authorization:"Bearer "+t.token},method:"GET"};fetch(x.a.url+"user/users/"+t.user.id,s).then((function(e){return e.json()})).then((function(t){console.log("data",t);try{t.terrains.length?(console.log("data2",t),t.terrains.map((function(t,s){console.log("terrain <<",t),t.reservations.filter((function(e){return"PAYE"==e.statePayement})).map((function(t,s){var n,a;console.log("reservation>>",t);var c="";t.userDoReservation&&(c=t.userDoReservation.nom+" "+t.userDoReservation.prenom);var i={id:t.id,nomterrain:t.nomTerrain,datedereservation:t.dateReservation,periode:Object(N.jsxs)("span",{onClick:e.handleTerrainClick.bind(e,t.heure),children:[" ",Object(N.jsx)("i",{style:{cursor:"pointer"},className:"bx bx-time-five bx-sm text-success "}),"  "]}),nomclient:c,adresse:null===(n=t.userDoReservation)||void 0===n?void 0:n.adresse,telephone:null===(a=t.userDoReservation)||void 0===a?void 0:a.telephone,total:t.montantTotal+" F",action:Object(N.jsxs)("a",{children:[" ",Object(N.jsx)("i",{style:{cursor:"pointer"},className:"bx bx-info-circle bx-sm text-primary "}),"  "]})};console.log("okkk"),e.setState({reservations:[].concat(Object(r.a)(e.state.reservations),[i])})}))}))):e.setState({reservations:[]})}catch(s){e.setState({reservations:[]})}}))}},{key:"toggle",value:function(){this.setState((function(e){return{modal:!e.modal}}))}},{key:"render",value:function(){var e=this,t={columns:[{label:"T\xe9rrain",field:"nomterrain",sort:"asc",width:270},{label:"Date",field:"datedereservation",sort:"asc",width:270},{label:"P\xe9riodes",field:"periode",sort:"asc",width:100},{label:"Client",field:"nomclient",sort:"asc",width:100},{label:"Adr Client",field:"adresse",sort:"asc",width:100},{label:"T\xe9l Client",field:"telephone",sort:"asc",width:100},{label:"Total",field:"total",sort:"asc",width:100},{label:"Action",field:"action",sort:"asc",width:100}],rows:this.state.reservations};return Object(N.jsx)(d.a.Fragment,{children:Object(N.jsxs)("div",{className:"page-content",children:[this.state.ok,Object(N.jsx)(f.a,{show:this.state.detailModal,terrain:this.state.periode,type:"RESERVATION",onCloseClick:function(){return e.setState({detailModal:!1})}}),Object(N.jsx)(b.a,{fluid:!0,children:Object(N.jsx)(u.a,{children:Object(N.jsx)(h.a,{md:"12",className:"pull-right",children:Object(N.jsx)(m.a,{children:Object(N.jsxs)(O.a,{children:[Object(N.jsxs)(u.a,{ClassName:"mb-4",children:[Object(N.jsx)(h.a,{md:"8",children:Object(N.jsx)("div",{className:"page-title-box d-flex align-items-center justify-content-between",children:Object(N.jsx)("h1",{className:"mb-0 font-size-18",children:"Liste des r\xe9servations"})})}),Object(N.jsx)(h.a,{md:"4",className:"pull-right",children:Object(N.jsxs)(p.a,{color:"success",className:"font-16 btn btn-success float-right",href:"/#/indisponibilite",children:[Object(N.jsx)("i",{class:"bx bx-plus-circle",children:" "}),"  Renseigner une r\xe9servation"]})})]}),Object(N.jsx)("hr",{}),Object(N.jsx)(u.a,{ClassName:"mt-5",children:Object(N.jsx)(h.a,{md:"12",children:Object(N.jsx)(j.c,{responsive:!0,striped:!0,bordered:!0,data:t})})})]})})})})})]})})}}]),s}(l.Component);t.default=y},998:function(e,t,s){"use strict";var r=s(159),n=s(160),a=s(162),c=s(161),i=s(1),o=s(803),l=s(1121),d=s(818),j=s(819),b=s(2),u=function(e){Object(a.a)(s,e);var t=Object(c.a)(s);function s(e){var n;return Object(r.a)(this,s),(n=t.call(this,e)).state={ok:"",prix:{}},n}return Object(n.a)(s,[{key:"componentDidMount",value:function(){console.log("modea",this.props.terrain)}},{key:"render",value:function(){var e=this.props.show,t=this.props.onCloseClick,s=this.props.terrain,r=this.props.type;return Object(b.jsx)(o.a,{isOpen:e,toggle:t,centered:!0,children:Object(b.jsxs)(l.a,{className:"py-3 px-5",children:["     ",this.state.ok,Object(b.jsx)(d.a,{className:"mb-3",children:Object(b.jsx)(j.a,{lg:12,children:Object(b.jsx)("div",{children:Object(b.jsx)("i",{className:"bx bx-football text-success display-5",style:{lineHeight:"1"}})})})}),Object(b.jsx)(d.a,{className:"mb-3",children:Object(b.jsxs)(j.a,{lg:12,children:["TERRAIN"===r?Object(b.jsx)("div",{children:Object(b.jsxs)(d.a,{children:[Object(b.jsxs)(j.a,{children:[Object(b.jsx)("br",{}),Object(b.jsx)("br",{}),Object(b.jsxs)("div",{className:"mb-2",children:[Object(b.jsx)("strong",{children:" Nom:      "})," ",Object(b.jsx)("span",{children:s.nom})]}),Object(b.jsxs)("div",{className:"mb-2",children:[Object(b.jsx)("strong",{children:" Adresse:         "}),Object(b.jsx)("span",{children:s.adresse})]}),Object(b.jsxs)("div",{className:"mb-2",children:[Object(b.jsx)("strong",{children:" Ville:         "}),Object(b.jsx)("span",{children:s.ville})]})]}),Object(b.jsxs)(j.a,{children:[Object(b.jsx)("div",{className:"mb-2 text-center",children:Object(b.jsx)("strong",{children:" Les diff\xe9rents prix :    "})}),s.prix?s.prix.map((function(e){return Object(b.jsxs)("div",{className:"mb-2 text-center",children:[Object(b.jsxs)("strong",{children:[e.jour," :         "]}),Object(b.jsxs)("span",{children:[e.valeur," FCFA"]})]})})):null]})]})}):null,"RESERVATION"===r?Object(b.jsx)("div",{children:Object(b.jsx)("ul",{class:"ks-cboxtags",children:s.split(";").map((function(e,t){return""!=e?Object(b.jsxs)("li",{className:"mr-2",children:[Object(b.jsx)("input",{type:"checkbox",id:"checkbox"+t,checked:!0,value:e}),Object(b.jsx)("label",{for:"checkbox"+t,children:e})]}):null}))})}):null]})}),Object(b.jsx)(d.a,{children:Object(b.jsx)(j.a,{children:Object(b.jsx)("div",{className:"mt-3",style:{float:"right"},children:Object(b.jsx)("button",{type:"button",className:"btn btn-success btn-sm me-2",onClick:t,children:"Fermer"})})})})]})})}}]),s}(i.Component);t.a=u}}]);
//# sourceMappingURL=74.6528afe9.chunk.js.map