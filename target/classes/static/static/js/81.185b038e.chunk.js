(this["webpackJsonp@coreui/coreui-free-react-admin-template"]=this["webpackJsonp@coreui/coreui-free-react-admin-template"]||[]).push([[81],{1434:function(e,t,s){"use strict";s.r(t);var c=s(159),i=s(160),a=s(162),n=s(161),r=s(1),l=(s(164),s(648)),o=s(920),d=(s(649),s(651)),j=s(663),u=(s(653),s(667),s(666),s(2)),h=Object(u.jsx)("div",{className:"pt-3 text-center",children:Object(u.jsx)("div",{className:"sk-spinner sk-spinner-pulse"})}),m=function(e){Object(a.a)(s,e);var t=Object(n.a)(s);function s(e){var i;return Object(c.a)(this,s),(i=t.call(this,e)).state={ok:"",service:[],page:Object(u.jsx)("div",{style:{marginTop:"25%",marginBottom:"20%",textAlign:"center"},children:Object(u.jsx)(o.a,{type:"grow",color:"success"})}),status:!0},i}return Object(i.a)(s,[{key:"componentDidMount",value:function(){var e=this;fetch(d.a.url+"acceuil/service/services",{method:"GET"}).then((function(e){return e.json()})).then((function(t){e.setState({status:!1});try{t.map((function(s,c){j.a.ref("images").child(s.multimedia.file).getDownloadURL().then((function(s){t[c].multimedia.file=s,e.setState({service:t})}))}))}catch(s){e.setState({service:[]})}}))}},{key:"render",value:function(){return Object(u.jsxs)(u.Fragment,{children:[this.state.ok,Object(u.jsx)(l.h,{fluid:!0,children:Object(u.jsx)(r.Suspense,{fallback:h,children:this.state.status?Object(u.jsx)(u.Fragment,{children:this.state.page}):Object(u.jsxs)(l.n,{children:[Object(u.jsx)("div",{className:"mt-5"}),Object(u.jsx)("section",{id:"services",class:"services",children:Object(u.jsxs)("div",{class:"container",children:[Object(u.jsx)("div",{class:"section-title mt-5",children:Object(u.jsx)("h2",{children:"Services"})}),Object(u.jsx)("div",{class:"row",children:this.state.service.map((function(e,t){return Object(u.jsx)("div",{class:"col-lg-4 col-md-6 d-flex align-items-stretch mt-4 mt-md-0","data-aos":"zoom-in","data-aos-delay":"200",children:Object(u.jsxs)("div",{class:"icon-box iconbox-orange ",children:[e.multimedia.file?Object(u.jsx)("img",{src:e.multimedia.file,class:"img-fluid",alt:"",style:{width:"310px",height:"208px"}}):Object(u.jsxs)("div",{class:"icon",children:[Object(u.jsx)("svg",{width:"100",height:"100",viewBox:"0 0 600 600",xmlns:"http://www.w3.org/2000/svg",children:Object(u.jsx)("path",{stroke:"none","stroke-width":"0",fill:"#f5f5f5",d:"M300,582.0697525312426C382.5290701553225,586.8405444964366,449.9789794690241,525.3245884688669,502.5850820975895,461.55621195738473C556.606425686781,396.0723002908107,615.8543463187945,314.28637112970534,586.6730223649479,234.56875336149918C558.9533121215079,158.8439757836574,454.9685369536778,164.00468322053177,381.49747125262974,130.76875717737553C312.15926192815925,99.40240125094834,248.97055460311594,18.661163978235184,179.8680185752513,50.54337015887873C110.5421016452524,82.52863877960104,119.82277516462835,180.83849132639028,109.12597500060166,256.43424936330496C100.08760227029461,320.3096726198365,92.17705696193138,384.0621239912766,124.79988738764834,439.7174275375508C164.83382741302287,508.01625554203684,220.96474134820875,577.5009287672846,300,582.0697525312426"})}),Object(u.jsx)("i",{class:"bi bi-trophy"})]}),Object(u.jsx)("h4",{children:Object(u.jsx)("a",{href:"",children:e.titre})}),Object(u.jsx)("p",{children:e.description})]})})}))})]})})]})})})]})}}]),s}(r.Component);t.default=m},651:function(e,t,s){"use strict";t.a={type_tournoi:{TOURNOI_INTER_ECOLE:"TOURNOI_INTER_ECOLE",TOURNOI_INTER_ENTREPRISE:"TOURNOI_INTER_ENTREPRISE"},url:"http://o-terrain.com/"}},663:function(e,t,s){"use strict";s.d(t,"a",(function(){return i}));var c=s(664);s(697);c.a.initializeApp({apiKey:"AIzaSyAEAU3GMvWGKcakyDnkICPmkVZaDCFRX08",authDomain:"oterrain-6822f.firebaseapp.com",projectId:"oterrain-6822f",storageBucket:"oterrain-6822f.appspot.com",messagingSenderId:"309004801581",appId:"1:309004801581:web:a535282f9a8c79328e0aa4",measurementId:"G-DZWQ4BHVY3"});var i=c.a.storage()},920:function(e,t,s){"use strict";var c=s(11),i=s(26),a=s(1),n=s.n(a),r=s(107),l=s.n(r),o=s(157),d=s.n(o),j=s(646),u={tag:j.n,type:l.a.string,size:l.a.string,color:l.a.string,className:l.a.string,cssModule:l.a.object,children:l.a.string},h=function(e){var t=e.className,s=e.cssModule,a=e.type,r=e.size,l=e.color,o=e.children,u=e.tag,h=Object(i.a)(e,["className","cssModule","type","size","color","children","tag"]),m=Object(j.j)(d()(t,!!r&&"spinner-"+a+"-"+r,"spinner-"+a,!!l&&"text-"+l),s);return n.a.createElement(u,Object(c.a)({role:"status"},h,{className:m}),o&&n.a.createElement("span",{className:Object(j.j)("sr-only",s)},o))};h.propTypes=u,h.defaultProps={tag:"div",type:"border",children:"Loading..."},t.a=h}}]);
//# sourceMappingURL=81.185b038e.chunk.js.map