(this["webpackJsonp@coreui/coreui-free-react-admin-template"]=this["webpackJsonp@coreui/coreui-free-react-admin-template"]||[]).push([[70],{1468:function(e,t,s){"use strict";s.r(t);var n=s(687),o=s(159),a=s(160),i=s(164),r=s(162),c=s(161),l=s(1),d=s.n(l),p=s(912),u=s(830),h=s(787),m=s(807),b=s(808),j=s(719),f=s(720),O=s(858),g=s(647),x=s(870),y=s(21),v=s(2),C=function(e){Object(r.a)(s,e);var t=Object(c.a)(s);function s(e){var n;return Object(o.a)(this,s),(n=t.call(this,e)).handleSupprimer=function(){var e={method:"GET",headers:{Authorization:"Bearer "+JSON.parse(localStorage.getItem("token_auth")).token}};fetch(g.a.url+"user/users/delete/"+n.state.id,e).then((function(e){console.log("enregitre avec succes vrai:",e),console.log("data send",e),n.setState({users:n.state.users.filter((function(e){return e.id!=n.state.id}))}),n.setState({show:!1})}))},n.handleDetail=function(e){localStorage.setItem("idUser",e),n.setState({ok:Object(v.jsx)(y.a,{to:"/detail-compte"})})},n.toggled=function(){n.setState({show:!n.state.show})},n.supprimer=function(e){n.setState({id:e,show:!0})},n.handleModifier=function(e){localStorage.setItem("idUser",e),n.setState({ok:Object(v.jsx)(y.a,{to:"/modifier-compte"})})},n.state={users:[],userData:[],id:0,show:!1,ok:"",page:Object(v.jsx)("div",{style:{marginTop:"25%",marginBottom:"20%",textAlign:"center"},children:Object(v.jsx)(u.a,{type:"grow",color:"success"})}),status:!0},n.handleDetail.bind(Object(i.a)(n)),n.supprimer.bind(Object(i.a)(n)),n.handleModifier.bind(Object(i.a)(n)),n}return Object(a.a)(s,[{key:"componentDidMount",value:function(){var e=this,t={method:"GET",headers:{Authorization:"Bearer "+JSON.parse(localStorage.getItem("token_auth")).token}};fetch(g.a.url+"user/users",t).then((function(e){return e.json()})).then((function(t){console.log("data",t),e.setState({status:!1});try{t.length?(e.setState({userData:t}),t.map((function(t,s){var o={id:t.id,nom:t.username,prenom:t.prenom,adresse:t.adresse,email:t.email,telephone:t.telephone,role:t.roles.libelle,action:Object(v.jsxs)("a",{children:[Object(v.jsx)("i",{style:{cursor:"pointer"},onClick:e.handleModifier.bind(e,t.id),className:"bx bx-pencil bx-sm text-primary mr-2"}),Object(v.jsx)("i",{style:{cursor:"pointer"},onClick:e.handleDetail.bind(e,t.id),className:"bx bx-info-circle bx-sm text-primary mr-2"}),Object(v.jsx)("i",{style:{cursor:"pointer"},onClick:e.supprimer.bind(e,t.id),className:"bx bx-trash  bx-sm text-danger "})]})};e.setState({users:[].concat(Object(n.a)(e.state.users),[o])})}))):e.setState({users:[]})}catch(s){e.setState({users:[]})}}))}},{key:"render",value:function(){var e={columns:[{label:"Nom",field:"nom",sort:"asc",width:150},{label:"Pr\xe9nom",field:"prenom",sort:"asc",width:270},{label:"Adresse",field:"adresse",sort:"asc",width:100},{label:"Email",field:"email",sort:"asc",width:100},{label:"T\xe9lephone",field:"telephone",sort:"asc",width:100},{label:"R\xf4le",field:"role",sort:"asc",width:100},{label:"Action",field:"action",sort:"asc",width:100}],rows:this.state.users},t={columns:[{label:"R\xf4le",field:"role",sort:"asc",width:150},{label:"Action",field:"action",sort:"asc",width:100}],rows:this.state.role};return Object(v.jsx)(d.a.Fragment,{children:Object(v.jsxs)("div",{className:"page-content",children:[this.state.ok,Object(v.jsx)(x.a,{show:this.state.show,handleValider:this.handleSupprimer,toggle:this.toggled}),Object(v.jsx)(h.a,{fluid:!0,children:this.state.status?Object(v.jsx)(v.Fragment,{children:this.state.page}):Object(v.jsxs)(v.Fragment,{children:[Object(v.jsx)(m.a,{children:Object(v.jsx)(b.a,{md:"12",className:"pull-right",children:Object(v.jsx)(j.a,{children:Object(v.jsxs)(f.a,{children:[Object(v.jsxs)(m.a,{ClassName:"mb-4",children:[Object(v.jsx)(b.a,{md:"8",children:Object(v.jsx)("div",{className:"page-title-box d-flex align-items-center justify-content-between",children:Object(v.jsx)("h1",{className:"mb-0 font-size-18",children:"Liste des comptes"})})}),Object(v.jsx)(b.a,{md:"4",className:"pull-right",children:Object(v.jsxs)(O.a,{color:"success",className:"font-16 btn btn-success float-right",href:"/#/ajout-compte",children:[Object(v.jsx)("i",{class:"bx bx-plus-circle",children:" "}),"  Cr\xe9er un nouveau compte"]})})]}),Object(v.jsx)("hr",{}),Object(v.jsx)(m.a,{ClassName:"mt-5",children:Object(v.jsx)(b.a,{md:"12",children:Object(v.jsx)(p.c,{responsive:!0,striped:!0,bordered:!0,data:e})})})]})})})}),Object(v.jsx)(m.a,{className:"mt-3",children:Object(v.jsx)(b.a,{md:"12",className:"pull-right",children:Object(v.jsx)(j.a,{children:Object(v.jsxs)(f.a,{children:[Object(v.jsxs)(m.a,{ClassName:"mb-4",children:[Object(v.jsx)(b.a,{md:"8",children:Object(v.jsx)("div",{className:"page-title-box d-flex align-items-center justify-content-between",children:Object(v.jsx)("h1",{className:"mb-0 font-size-18",children:"Liste des r\xf4les"})})}),Object(v.jsx)(b.a,{md:"4",className:"pull-right",children:Object(v.jsxs)(O.a,{color:"success",className:"font-16 btn btn-success float-right",href:"/#/ajout-role",children:[Object(v.jsx)("i",{class:"bx bx-plus-circle",children:" "}),"  Ajouter un nouveau r\xf4le"]})})]}),Object(v.jsx)("hr",{}),Object(v.jsx)(m.a,{ClassName:"mt-5",children:Object(v.jsx)(b.a,{md:"12",children:Object(v.jsx)(p.c,{responsive:!0,striped:!0,bordered:!0,data:t})})})]})})})})]})})]})})}}]),s}(l.Component);t.default=C},647:function(e,t,s){"use strict";t.a={type_tournoi:{TOURNOI_INTER_ECOLE:"TOURNOI_INTER_ECOLE",TOURNOI_INTER_ENTREPRISE:"TOURNOI_INTER_ENTREPRISE"},url:"https://o-terrain.com/"}},687:function(e,t,s){"use strict";function n(e,t){(null==t||t>e.length)&&(t=e.length);for(var s=0,n=new Array(t);s<t;s++)n[s]=e[s];return n}function o(e){return function(e){if(Array.isArray(e))return n(e)}(e)||function(e){if("undefined"!==typeof Symbol&&Symbol.iterator in Object(e))return Array.from(e)}(e)||function(e,t){if(e){if("string"===typeof e)return n(e,t);var s=Object.prototype.toString.call(e).slice(8,-1);return"Object"===s&&e.constructor&&(s=e.constructor.name),"Map"===s||"Set"===s?Array.from(e):"Arguments"===s||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(s)?n(e,t):void 0}}(e)||function(){throw new TypeError("Invalid attempt to spread non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}()}s.d(t,"a",(function(){return o}))},778:function(e,t,s){"use strict";var n=s(163),o=s(11),a=s(657),i=s(32),r=s(1),c=s.n(r),l=s(107),d=s.n(l),p=s(157),u=s.n(p),h=s(84),m=s.n(h),b=s(644),j={children:d.a.node.isRequired,node:d.a.any},f=function(e){function t(){return e.apply(this,arguments)||this}Object(i.a)(t,e);var s=t.prototype;return s.componentWillUnmount=function(){this.defaultNode&&document.body.removeChild(this.defaultNode),this.defaultNode=null},s.render=function(){return b.c?(this.props.node||this.defaultNode||(this.defaultNode=document.createElement("div"),document.body.appendChild(this.defaultNode)),m.a.createPortal(this.props.children,this.props.node||this.defaultNode)):null},t}(c.a.Component);f.propTypes=j;var O=f,g=s(777);function x(e,t){var s=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),s.push.apply(s,n)}return s}function y(e){for(var t=1;t<arguments.length;t++){var s=null!=arguments[t]?arguments[t]:{};t%2?x(Object(s),!0).forEach((function(t){Object(n.a)(e,t,s[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(s)):x(Object(s)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(s,t))}))}return e}function v(){}var C=d.a.shape(g.a.propTypes),N={isOpen:d.a.bool,autoFocus:d.a.bool,centered:d.a.bool,scrollable:d.a.bool,size:d.a.string,toggle:d.a.func,keyboard:d.a.bool,role:d.a.string,labelledBy:d.a.string,backdrop:d.a.oneOfType([d.a.bool,d.a.oneOf(["static"])]),onEnter:d.a.func,onExit:d.a.func,onOpened:d.a.func,onClosed:d.a.func,children:d.a.node,className:d.a.string,wrapClassName:d.a.string,modalClassName:d.a.string,backdropClassName:d.a.string,contentClassName:d.a.string,external:d.a.node,fade:d.a.bool,cssModule:d.a.object,zIndex:d.a.oneOfType([d.a.number,d.a.string]),backdropTransition:C,modalTransition:C,innerRef:d.a.oneOfType([d.a.object,d.a.string,d.a.func]),unmountOnClose:d.a.bool,returnFocusAfterClose:d.a.bool,container:b.o,trapFocus:d.a.bool},k=Object.keys(N),E={isOpen:!1,autoFocus:!0,centered:!1,scrollable:!1,role:"dialog",backdrop:!0,keyboard:!0,zIndex:1050,fade:!0,onOpened:v,onClosed:v,modalTransition:{timeout:b.b.Modal},backdropTransition:{mountOnEnter:!0,timeout:b.b.Fade},unmountOnClose:!0,returnFocusAfterClose:!0,container:"body",trapFocus:!1},_=function(e){function t(t){var s;return(s=e.call(this,t)||this)._element=null,s._originalBodyPadding=null,s.getFocusableChildren=s.getFocusableChildren.bind(Object(a.a)(s)),s.handleBackdropClick=s.handleBackdropClick.bind(Object(a.a)(s)),s.handleBackdropMouseDown=s.handleBackdropMouseDown.bind(Object(a.a)(s)),s.handleEscape=s.handleEscape.bind(Object(a.a)(s)),s.handleStaticBackdropAnimation=s.handleStaticBackdropAnimation.bind(Object(a.a)(s)),s.handleTab=s.handleTab.bind(Object(a.a)(s)),s.onOpened=s.onOpened.bind(Object(a.a)(s)),s.onClosed=s.onClosed.bind(Object(a.a)(s)),s.manageFocusAfterClose=s.manageFocusAfterClose.bind(Object(a.a)(s)),s.clearBackdropAnimationTimeout=s.clearBackdropAnimationTimeout.bind(Object(a.a)(s)),s.trapFocus=s.trapFocus.bind(Object(a.a)(s)),s.state={isOpen:!1,showStaticBackdropAnimation:!1},s}Object(i.a)(t,e);var s=t.prototype;return s.componentDidMount=function(){var e=this.props,t=e.isOpen,s=e.autoFocus,n=e.onEnter;t&&(this.init(),this.setState({isOpen:!0}),s&&this.setFocus()),n&&n(),document.addEventListener("focus",this.trapFocus,!0),this._isMounted=!0},s.componentDidUpdate=function(e,t){if(this.props.isOpen&&!e.isOpen)return this.init(),void this.setState({isOpen:!0});this.props.autoFocus&&this.state.isOpen&&!t.isOpen&&this.setFocus(),this._element&&e.zIndex!==this.props.zIndex&&(this._element.style.zIndex=this.props.zIndex)},s.componentWillUnmount=function(){this.clearBackdropAnimationTimeout(),this.props.onExit&&this.props.onExit(),this._element&&(this.destroy(),(this.props.isOpen||this.state.isOpen)&&this.close()),document.removeEventListener("focus",this.trapFocus,!0),this._isMounted=!1},s.trapFocus=function(e){if(this.props.trapFocus&&this._element&&(!this._dialog||this._dialog.parentNode!==e.target)&&!(this.modalIndex<t.openCount-1)){for(var s=this.getFocusableChildren(),n=0;n<s.length;n++)if(s[n]===e.target)return;s.length>0&&(e.preventDefault(),e.stopPropagation(),s[0].focus())}},s.onOpened=function(e,t){this.props.onOpened(),(this.props.modalTransition.onEntered||v)(e,t)},s.onClosed=function(e){var t=this.props.unmountOnClose;this.props.onClosed(),(this.props.modalTransition.onExited||v)(e),t&&this.destroy(),this.close(),this._isMounted&&this.setState({isOpen:!1})},s.setFocus=function(){this._dialog&&this._dialog.parentNode&&"function"===typeof this._dialog.parentNode.focus&&this._dialog.parentNode.focus()},s.getFocusableChildren=function(){return this._element.querySelectorAll(b.e.join(", "))},s.getFocusedChild=function(){var e,t=this.getFocusableChildren();try{e=document.activeElement}catch(s){e=t[0]}return e},s.handleBackdropClick=function(e){if(e.target===this._mouseDownElement){e.stopPropagation();var t=this._dialog?this._dialog.parentNode:null;if(t&&e.target===t&&"static"===this.props.backdrop&&this.handleStaticBackdropAnimation(),!this.props.isOpen||!0!==this.props.backdrop)return;t&&e.target===t&&this.props.toggle&&this.props.toggle(e)}},s.handleTab=function(e){if(9===e.which&&!(this.modalIndex<t.openCount-1)){var s=this.getFocusableChildren(),n=s.length;if(0!==n){for(var o=this.getFocusedChild(),a=0,i=0;i<n;i+=1)if(s[i]===o){a=i;break}e.shiftKey&&0===a?(e.preventDefault(),s[n-1].focus()):e.shiftKey||a!==n-1||(e.preventDefault(),s[0].focus())}}},s.handleBackdropMouseDown=function(e){this._mouseDownElement=e.target},s.handleEscape=function(e){this.props.isOpen&&e.keyCode===b.i.esc&&this.props.toggle&&(this.props.keyboard?(e.preventDefault(),e.stopPropagation(),this.props.toggle(e)):"static"===this.props.backdrop&&(e.preventDefault(),e.stopPropagation(),this.handleStaticBackdropAnimation()))},s.handleStaticBackdropAnimation=function(){var e=this;this.clearBackdropAnimationTimeout(),this.setState({showStaticBackdropAnimation:!0}),this._backdropAnimationTimeout=setTimeout((function(){e.setState({showStaticBackdropAnimation:!1})}),100)},s.init=function(){try{this._triggeringElement=document.activeElement}catch(e){this._triggeringElement=null}this._element||(this._element=document.createElement("div"),this._element.setAttribute("tabindex","-1"),this._element.style.position="relative",this._element.style.zIndex=this.props.zIndex,this._mountContainer=Object(b.g)(this.props.container),this._mountContainer.appendChild(this._element)),this._originalBodyPadding=Object(b.f)(),Object(b.d)(),0===t.openCount&&(document.body.className=u()(document.body.className,Object(b.j)("modal-open",this.props.cssModule))),this.modalIndex=t.openCount,t.openCount+=1},s.destroy=function(){this._element&&(this._mountContainer.removeChild(this._element),this._element=null),this.manageFocusAfterClose()},s.manageFocusAfterClose=function(){if(this._triggeringElement){var e=this.props.returnFocusAfterClose;this._triggeringElement.focus&&e&&this._triggeringElement.focus(),this._triggeringElement=null}},s.close=function(){if(t.openCount<=1){var e=Object(b.j)("modal-open",this.props.cssModule),s=new RegExp("(^| )"+e+"( |$)");document.body.className=document.body.className.replace(s," ").trim()}this.manageFocusAfterClose(),t.openCount=Math.max(0,t.openCount-1),Object(b.m)(this._originalBodyPadding)},s.renderModalDialog=function(){var e,t=this,s=Object(b.k)(this.props,k),n="modal-dialog";return c.a.createElement("div",Object(o.a)({},s,{className:Object(b.j)(u()(n,this.props.className,(e={},e["modal-"+this.props.size]=this.props.size,e["modal-dialog-centered"]=this.props.centered,e["modal-dialog-scrollable"]=this.props.scrollable,e)),this.props.cssModule),role:"document",ref:function(e){t._dialog=e}}),c.a.createElement("div",{className:Object(b.j)(u()("modal-content",this.props.contentClassName),this.props.cssModule)},this.props.children))},s.render=function(){var e=this.props.unmountOnClose;if(this._element&&(this.state.isOpen||!e)){var t=!!this._element&&!this.state.isOpen&&!e;this._element.style.display=t?"none":"block";var s=this.props,n=s.wrapClassName,a=s.modalClassName,i=s.backdropClassName,r=s.cssModule,l=s.isOpen,d=s.backdrop,p=s.role,h=s.labelledBy,m=s.external,j=s.innerRef,f={onClick:this.handleBackdropClick,onMouseDown:this.handleBackdropMouseDown,onKeyUp:this.handleEscape,onKeyDown:this.handleTab,style:{display:"block"},"aria-labelledby":h,role:p,tabIndex:"-1"},x=this.props.fade,v=y(y(y({},g.a.defaultProps),this.props.modalTransition),{},{baseClass:x?this.props.modalTransition.baseClass:"",timeout:x?this.props.modalTransition.timeout:0}),C=y(y(y({},g.a.defaultProps),this.props.backdropTransition),{},{baseClass:x?this.props.backdropTransition.baseClass:"",timeout:x?this.props.backdropTransition.timeout:0}),N=d&&(x?c.a.createElement(g.a,Object(o.a)({},C,{in:l&&!!d,cssModule:r,className:Object(b.j)(u()("modal-backdrop",i),r)})):c.a.createElement("div",{className:Object(b.j)(u()("modal-backdrop","show",i),r)}));return c.a.createElement(O,{node:this._element},c.a.createElement("div",{className:Object(b.j)(n)},c.a.createElement(g.a,Object(o.a)({},f,v,{in:l,onEntered:this.onOpened,onExited:this.onClosed,cssModule:r,className:Object(b.j)(u()("modal",a,this.state.showStaticBackdropAnimation&&"modal-static"),r),innerRef:j}),m,this.renderModalDialog()),N))}return null},s.clearBackdropAnimationTimeout=function(){this._backdropAnimationTimeout&&(clearTimeout(this._backdropAnimationTimeout),this._backdropAnimationTimeout=void 0)},t}(c.a.Component);_.propTypes=N,_.defaultProps=E,_.openCount=0;t.a=_},830:function(e,t,s){"use strict";var n=s(11),o=s(26),a=s(1),i=s.n(a),r=s(107),c=s.n(r),l=s(157),d=s.n(l),p=s(644),u={tag:p.n,type:c.a.string,size:c.a.string,color:c.a.string,className:c.a.string,cssModule:c.a.object,children:c.a.string},h=function(e){var t=e.className,s=e.cssModule,a=e.type,r=e.size,c=e.color,l=e.children,u=e.tag,h=Object(o.a)(e,["className","cssModule","type","size","color","children","tag"]),m=Object(p.j)(d()(t,!!r&&"spinner-"+a+"-"+r,"spinner-"+a,!!c&&"text-"+c),s);return i.a.createElement(u,Object(n.a)({role:"status"},h,{className:m}),l&&i.a.createElement("span",{className:Object(p.j)("sr-only",s)},l))};h.propTypes=u,h.defaultProps={tag:"div",type:"border",children:"Loading..."},t.a=h},860:function(e,t,s){"use strict";var n=s(11),o=s(26),a=s(1),i=s.n(a),r=s(107),c=s.n(r),l=s(157),d=s.n(l),p=s(644),u={tag:p.n,className:c.a.string,cssModule:c.a.object},h=function(e){var t=e.className,s=e.cssModule,a=e.tag,r=Object(o.a)(e,["className","cssModule","tag"]),c=Object(p.j)(d()(t,"modal-body"),s);return i.a.createElement(a,Object(n.a)({},r,{className:c}))};h.propTypes=u,h.defaultProps={tag:"div"},t.a=h},870:function(e,t,s){"use strict";var n=s(778),o=s(860),a=s(11),i=s(26),r=s(1),c=s.n(r),l=s(107),d=s.n(l),p=s(157),u=s.n(p),h=s(644),m={tag:h.n,className:d.a.string,cssModule:d.a.object},b=function(e){var t=e.className,s=e.cssModule,n=e.tag,o=Object(i.a)(e,["className","cssModule","tag"]),r=Object(h.j)(u()(t,"modal-footer"),s);return c.a.createElement(n,Object(a.a)({},o,{className:r}))};b.propTypes=m,b.defaultProps={tag:"div"};var j=b,f=s(858),O=s(2);t.a=function(e){var t=e.handleValider,s=e.show,a=e.toggle;return Object(O.jsx)(O.Fragment,{children:Object(O.jsxs)(n.a,{isOpen:s,toggle:a,children:[Object(O.jsx)(o.a,{style:{textAlign:"center"},children:Object(O.jsx)("h4",{children:"Voulez-vous vraiment Supprimer ?"})}),Object(O.jsxs)(j,{children:[Object(O.jsx)(f.a,{color:"danger",onClick:t,children:"Supprimer"})," ",Object(O.jsx)(f.a,{color:"secondary",onClick:a,children:"Annuler"})]})]})})}}}]);
//# sourceMappingURL=70.60f4c60e.chunk.js.map