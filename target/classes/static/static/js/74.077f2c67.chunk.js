(this["webpackJsonp@coreui/coreui-free-react-admin-template"]=this["webpackJsonp@coreui/coreui-free-react-admin-template"]||[]).push([[74],{644:function(e,t,n){"use strict";n.d(t,"m",(function(){return c})),n.d(t,"f",(function(){return a})),n.d(t,"d",(function(){return s})),n.d(t,"j",(function(){return u})),n.d(t,"k",(function(){return d})),n.d(t,"l",(function(){return l})),n.d(t,"p",(function(){return p})),n.d(t,"o",(function(){return m})),n.d(t,"n",(function(){return b})),n.d(t,"b",(function(){return j})),n.d(t,"a",(function(){return y})),n.d(t,"i",(function(){return v})),n.d(t,"c",(function(){return g})),n.d(t,"h",(function(){return O})),n.d(t,"g",(function(){return k})),n.d(t,"e",(function(){return I}));var r,i=n(107),o=n.n(i);function c(e){document.body.style.paddingRight=e>0?e+"px":null}function a(){var e=window.getComputedStyle(document.body,null);return parseInt(e&&e.getPropertyValue("padding-right")||0,10)}function s(){var e=function(){var e=document.createElement("div");e.style.position="absolute",e.style.top="-9999px",e.style.width="50px",e.style.height="50px",e.style.overflow="scroll",document.body.appendChild(e);var t=e.offsetWidth-e.clientWidth;return document.body.removeChild(e),t}(),t=document.querySelectorAll(".fixed-top, .fixed-bottom, .is-fixed, .sticky-top")[0],n=t?parseInt(t.style.paddingRight||0,10):0;document.body.clientWidth<window.innerWidth&&c(n+e)}function u(e,t){return void 0===e&&(e=""),void 0===t&&(t=r),t?e.split(" ").map((function(e){return t[e]||e})).join(" "):e}function d(e,t){var n={};return Object.keys(e).forEach((function(r){-1===t.indexOf(r)&&(n[r]=e[r])})),n}function l(e,t){for(var n,r=Array.isArray(t)?t:[t],i=r.length,o={};i>0;)o[n=r[i-=1]]=e[n];return o}var f={};function p(e){f[e]||("undefined"!==typeof console&&console.error(e),f[e]=!0)}var h="object"===typeof window&&window.Element||function(){};var m=o.a.oneOfType([o.a.string,o.a.func,function(e,t,n){if(!(e[t]instanceof h))return new Error("Invalid prop `"+t+"` supplied to `"+n+"`. Expected prop to be an instance of Element. Validation failed.")},o.a.shape({current:o.a.any})]),b=o.a.oneOfType([o.a.func,o.a.string,o.a.shape({$$typeof:o.a.symbol,render:o.a.func}),o.a.arrayOf(o.a.oneOfType([o.a.func,o.a.string,o.a.shape({$$typeof:o.a.symbol,render:o.a.func})]))]),j={Fade:150,Collapse:350,Modal:300,Carousel:600},y=["in","mountOnEnter","unmountOnExit","appear","enter","exit","timeout","onEnter","onEntering","onEntered","onExit","onExiting","onExited"],v={esc:27,space:32,enter:13,tab:9,up:38,down:40,home:36,end:35,n:78,p:80},g=!("undefined"===typeof window||!window.document||!window.document.createElement);function x(e){return null==e?void 0===e?"[object Undefined]":"[object Null]":Object.prototype.toString.call(e)}function O(e){var t=typeof e;return null!=e&&("object"===t||"function"===t)}function w(e){if(function(e){return!(!e||"object"!==typeof e)&&"current"in e}(e))return e.current;if(function(e){if(!O(e))return!1;var t=x(e);return"[object Function]"===t||"[object AsyncFunction]"===t||"[object GeneratorFunction]"===t||"[object Proxy]"===t}(e))return e();if("string"===typeof e&&g){var t=document.querySelectorAll(e);if(t.length||(t=document.querySelectorAll("#"+e)),!t.length)throw new Error("The target '"+e+"' could not be identified in the dom, tip: check spelling");return t}return e}function E(e){return null!==e&&(Array.isArray(e)||g&&"number"===typeof e.length)}function k(e,t){var n=w(e);return t?E(n)?n:null===n?[]:[n]:E(n)?n[0]:n}var I=["a[href]","area[href]","input:not([disabled]):not([type=hidden])","select:not([disabled])","textarea:not([disabled])","button:not([disabled])","object","embed","[tabindex]:not(.modal)","audio[controls]","video[controls]",'[contenteditable]:not([contenteditable="false"])']},647:function(e,t,n){"use strict";t.a={type_tournoi:{TOURNOI_INTER_ECOLE:"TOURNOI_INTER_ECOLE",TOURNOI_INTER_ENTREPRISE:"TOURNOI_INTER_ENTREPRISE"},url:"https://o-terrain.com/"}},692:function(e,t,n){"use strict";n.d(t,"a",(function(){return i}));var r=n(685);n(710);r.a.initializeApp({apiKey:"AIzaSyAEAU3GMvWGKcakyDnkICPmkVZaDCFRX08",authDomain:"oterrain-6822f.firebaseapp.com",projectId:"oterrain-6822f",storageBucket:"oterrain-6822f.appspot.com",messagingSenderId:"309004801581",appId:"1:309004801581:web:a535282f9a8c79328e0aa4",measurementId:"G-DZWQ4BHVY3"});var i=r.a.storage()},830:function(e,t,n){"use strict";var r=n(11),i=n(26),o=n(1),c=n.n(o),a=n(107),s=n.n(a),u=n(157),d=n.n(u),l=n(644),f={tag:l.n,type:s.a.string,size:s.a.string,color:s.a.string,className:s.a.string,cssModule:s.a.object,children:s.a.string},p=function(e){var t=e.className,n=e.cssModule,o=e.type,a=e.size,s=e.color,u=e.children,f=e.tag,p=Object(i.a)(e,["className","cssModule","type","size","color","children","tag"]),h=Object(l.j)(d()(t,!!a&&"spinner-"+o+"-"+a,"spinner-"+o,!!s&&"text-"+s),n);return c.a.createElement(f,Object(r.a)({role:"status"},p,{className:h}),u&&c.a.createElement("span",{className:Object(l.j)("sr-only",n)},u))};p.propTypes=f,p.defaultProps={tag:"div",type:"border",children:"Loading..."},t.a=p},998:function(e,t,n){"use strict";n.r(t);var r=n(159),i=n(160),o=n(162),c=n(161),a=n(1),s=n(830),u=n(648),d=n(647),l=n(692),f=n(2),p=Object(f.jsx)("div",{className:"pt-3 text-center",children:Object(f.jsx)("div",{className:"sk-spinner sk-spinner-pulse"})}),h=function(e){Object(o.a)(n,e);var t=Object(c.a)(n);function n(e){var i;return Object(r.a)(this,n),(i=t.call(this,e)).state={ok:"",service:[],page:Object(f.jsx)("div",{style:{marginTop:"25%",marginBottom:"20%",textAlign:"center"},children:Object(f.jsx)(s.a,{type:"grow",color:"success"})}),status:!0},i}return Object(i.a)(n,[{key:"componentDidMount",value:function(){var e=this;fetch(d.a.url+"acceuil/service/services",{method:"GET"}).then((function(e){return e.json()})).then((function(t){e.setState({status:!1}),e.setState({service:t});try{t.map((function(n,r){n.multimedia.file&&l.a.ref("images").child(n.multimedia.file).getDownloadURL().then((function(n){t[r].multimedia.file=n,e.setState({service:t})}))}))}catch(n){e.setState({service:[]})}}))}},{key:"render",value:function(){return Object(f.jsxs)(f.Fragment,{children:[this.state.ok,Object(f.jsx)(u.h,{fluid:!0,children:Object(f.jsx)(a.Suspense,{fallback:p,children:this.state.status?Object(f.jsx)(f.Fragment,{children:this.state.page}):Object(f.jsxs)(u.n,{children:[Object(f.jsx)("div",{className:"mt-5"}),Object(f.jsx)("section",{id:"services",class:"services",children:Object(f.jsxs)("div",{class:"container",children:[Object(f.jsx)("div",{class:"section-title mt-5",children:Object(f.jsx)("h2",{children:"Services"})}),Object(f.jsx)("div",{class:"row",children:this.state.service.map((function(e,t){return Object(f.jsx)("div",{class:"col-lg-4 col-md-6 d-flex align-items-stretch mt-4 mt-md-0","data-aos":"zoom-in","data-aos-delay":"200",children:Object(f.jsxs)("div",{class:"icon-box iconbox-orange ",children:[e.multimedia.file?Object(f.jsx)("img",{src:e.multimedia.file,class:"img-fluid",alt:"",style:{width:"310px",height:"208px"}}):Object(f.jsxs)("div",{class:"icon",children:[Object(f.jsx)("svg",{width:"100",height:"100",viewBox:"0 0 600 600",xmlns:"http://www.w3.org/2000/svg",children:Object(f.jsx)("path",{stroke:"none","stroke-width":"0",fill:"#f5f5f5",d:"M300,582.0697525312426C382.5290701553225,586.8405444964366,449.9789794690241,525.3245884688669,502.5850820975895,461.55621195738473C556.606425686781,396.0723002908107,615.8543463187945,314.28637112970534,586.6730223649479,234.56875336149918C558.9533121215079,158.8439757836574,454.9685369536778,164.00468322053177,381.49747125262974,130.76875717737553C312.15926192815925,99.40240125094834,248.97055460311594,18.661163978235184,179.8680185752513,50.54337015887873C110.5421016452524,82.52863877960104,119.82277516462835,180.83849132639028,109.12597500060166,256.43424936330496C100.08760227029461,320.3096726198365,92.17705696193138,384.0621239912766,124.79988738764834,439.7174275375508C164.83382741302287,508.01625554203684,220.96474134820875,577.5009287672846,300,582.0697525312426"})}),2===t?Object(f.jsx)("i",{class:"bx bx-md bx-football"}):Object(f.jsx)("i",{class:"bi bi-trophy"})]}),Object(f.jsx)("h4",{children:Object(f.jsx)("a",{href:"",children:e.titre})}),Object(f.jsx)("p",{children:e.description})]})})}))})]})})]})})})]})}}]),n}(a.Component);t.default=h}}]);
//# sourceMappingURL=74.077f2c67.chunk.js.map