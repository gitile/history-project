//申明用于命名空间注册
my={};
my.register= function(fname){
	var nArray = fname.split('.');//分置方法
	var tfn = '';
	var feval= '';
	
	for(var i= 0; i< nArray.length;i++){
		if(i!=0){tfn += '.';}
		tfn += nArray[i];
		feval += "if (typeof("+tfn+") == 'undefined'){" + tfn + "={};}";
	}
	//alert(feval);
	if(feval!=''){eval(feval);}
};
my.register('my.util');//公用方法
my.util.global={
		contextPath:'/',
		staticPath:'/static',
		appIcons:[
	        'icon1.jpg',
	        'icon2.jpg',
	        'icon3.jpg',
	        'icon4.jpg',
	        'icon5.jpg',
	        'icon6.jpg',
	        'icon7.jpg',
	        'icon8.jpg',
	        'icon9.jpg',
	        'icon10.jpg',
	        'icon11.jpg',
	        'icon12.jpg',
	        'icon13.jpg',
	        'icon14.jpg',
	        'icon15.jpg',
	        'icon16.jpg',
	        'icon17.jpg',
	        'icon18.jpg',
	        'icon19.jpg',
	        'icon20.jpg',
	        'icon21.jpg',
	        'icon22.jpg',
	        'icon23.jpg',
	        'icon24.jpg',
	        'icon25.jpg',
	        'icon26.jpg',
	        'icon27.jpg',
	        'icon28.jpg',
	        'icon29.jpg',
	        'icon30.jpg',
	        'icon31.jpg',
	        'icon32.jpg',
	        'icon33.jpg',
	        'icon34.jpg',
	        'icon35.jpg',
	        'icon36.jpg',
	        'icon37.jpg',
	        'icon38.jpg',
	        'icon39.jpg',
	        'icon40.jpg',
	        'icon41.jpg',
	        'icon42.jpg',
	        'icon43.jpg',
	        'icon44.jpg',
	        'icon45.jpg',
	        'icon46.jpg',
	        'icon47.jpg',
	        'icon48.jpg',
	        'icon49.jpg'
		],
		fontIcons:[
			'icon-user',
			'icon-user-female',
			'icon-users',
			'icon-user-follow',
			'icon-user-following',
			'icon-user-unfollow',
			'icon-trophy',
			'icon-speedometer',
			'icon-social-youtube',
			'icon-social-twitter',
			'icon-social-tumblr',
			'icon-social-facebook',
			'icon-social-dropbox',
			'icon-social-dribbble',
			'icon-shield',
			'icon-screen-tablet',
			'icon-screen-smartphone',
			'icon-screen-desktop',
			'icon-plane',
			'icon-notebook',
			'icon-moustache',
			'icon-mouse',
			'icon-magnet',
			'icon-magic-wand',
			'icon-hourglass',
			'icon-graduation',
			'icon-ghost',
			'icon-game-controller',
			'icon-fire',
			'icon-eyeglasses',
			'icon-envelope-open',
			'icon-envelope-letter',
			'icon-energy',
			'icon-emot',
			'icon-smile',
			'icon-disc',
			'icon-cursor-move',
			'icon-crop',
			'icon-credit-card',
			'icon-chemistry',
			'icon-bell',
			'icon-badge',
			'icon-anchor',
			'icon-action-redo',
			'icon-action-undo',
			'icon-bag',
			'icon-basket',
			'icon-basket-loaded',
			'icon-book-open',
			'icon-briefcase',
			'icon-bubbles',
			'icon-calculator',
			'icon-call-end',
			'icon-call-in',
			'icon-call-out',
			'icon-compass',
			'icon-cup',
			'icon-diamond',
			'icon-direction',
			'icon-directions',
			'icon-docs',
			'icon-drawer',
			'icon-drop',
			'icon-earphones',
			'icon-earphones-alt',
			'icon-feed',
			'icon-film',
			'icon-folder-alt',
			'icon-frame',
			'icon-globe',
			'icon-globe-alt',
			'icon-handbag',
			'icon-layers',
			'icon-map',
			'icon-picture',
			'icon-pin',
			'icon-playlist',
			'icon-present',
			'icon-printer',
			'icon-puzzle',
			'icon-speech',
			'icon-vector',
			'icon-wallet',
			'icon-arrow-down',
			'icon-arrow-left',
			'icon-arrow-right',
			'icon-arrow-up',
			'icon-bar-chart',
			'icon-bulb',
			'icon-calendar',
			'icon-control-end',
			'icon-control-forward',
			'icon-control-pause',
			'icon-control-play',
			'icon-control-rewind',
			'icon-control-start',
			'icon-cursor',
			'icon-dislike',
			'icon-equalizer',
			'icon-graph',
			'icon-grid',
			'icon-home',
			'icon-like',
			'icon-list',
			'icon-login',
			'icon-logout',
			'icon-loop',
			'icon-microphone',
			'icon-music-tone',
			'icon-music-tone-alt',
			'icon-note',
			'icon-pencil',
			'icon-pie-chart',
			'icon-question',
			'icon-rocket',
			'icon-share',
			'icon-share-alt',
			'icon-shuffle',
			'icon-size-actual',
			'icon-size-fullscreen',
			'icon-support',
			'icon-tag',
			'icon-trash',
			'icon-umbrella',
			'icon-wrench',
			'icon-ban',
			'icon-bubble',
			'icon-camcorder',
			'icon-camera',
			'icon-check',
			'icon-clock',
			'icon-close',
			'icon-cloud-download',
			'icon-cloud-upload',
			'icon-doc',
			'icon-envelope',
			'icon-eye',
			'icon-flag',
			'icon-folder',
			'icon-heart',
			'icon-info',
			'icon-key',
			'icon-link',
			'icon-lock',
			'icon-lock-open',
			'icon-magnifier',
			'icon-magnifier-add',
			'icon-magnifier-remove',
			'icon-paper-clip',
			'icon-paper-plane',
			'icon-plus',
			'icon-pointer',
			'icon-power',
			'icon-refresh',
			'icon-reload',
			'icon-settings',
			'icon-star',
			'icon-symbol-female',
			'icon-symbol-male',
			'icon-target',
			'icon-volume-1',
			'icon-volume-2',
			'icon-volume-off']
};//全局变量


// 日期格式化
my.util.dateFormat=function(time,format) {
    if(!time) return null;
    var date = new Date(time);
    var o = {
        "M+" : date.getMonth()+1, //month
        "d+" : date.getDate(), //day
        "h+" : date.getHours(), //hour
        "m+" : date.getMinutes(), //minute
        "s+" : date.getSeconds(), //second
        "q+" : Math.floor((date.getMonth()+3)/3), //quarter
        "S" : date.getMilliseconds() //millisecond
    };
    if(/(y+)/.test(format)) {
        format = format.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length));
    }
    for(var k in o) {
        if(new RegExp("("+ k +")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length));
        }
    }
    return format;
};
//防止事件冒泡
function stopEP(e) {
    e = e || window.event;
	if (e.stopPropagation) {
		e.stopPropagation();
	}
	if (e.preventDefault) {
		e.preventDefault();
	}
	e.cancelBubble = true;
	e.keyCode = 0;  
    e.returnValue = false;  
}
// 判断字符串是否为空
function isNotEmpty(str) {
    if(str!=null&&str.length>0) {
    	return true;
    }
    return false;
}
function isEmpty(str) {
    return !isNotEmpty(str);
}
my.util.ajaxInit=function() {
	jQuery(document).ajaxSend(function(e,XHR,options){
		// 开始发送
	}).ajaxError(function(e,XHR,settings,thrownError){
		tips('连接服务器时发生错误.请再试一次！', 'error');
	}).ajaxComplete(function(e, XHR, options){
		try {
			var str = XHR.getAllResponseHeaders();
			if (str.indexOf("sessionstatus") >= 0) {
				//提示消息
				tips('登录超时.请重新登录！', 'warning');
			} else if (str.indexOf("authstatus") >= 0) {
				//提示消息
				tips('对不起，您没有操作权限,请联系管理员！', 'warning');
			} else {
				if (XHR.status == 200) {
					// 成功返回结果
				}
			}
		} catch (e) {
			tips('连接服务器时发生错误.请再试一次！', 'error');
		}
	});
}
// 通用左边菜单
my.util.leftMenuInit=function() {
	$(".sub_common li").hover(function(){
		$(this).addClass("hover");
	},  function(){ 
		$(this).removeClass("hover");
	});
	$(".sub_common li").on('click',function (e) {
		var url = $(this).attr("target_url");
		top.artDialog.focus.refreshUrl(url);
    });
}
//添加startWith原生方法
String.prototype.startWith=function(s){
  if(s==null||s==""||this.length==0||s.length>this.length) {
	  return false;
  }
  if(this.substr(0,s.length)==s) {
	  return true;
  } else {
	  return false;
  }
  return true;
 }

/*
* iframe之间函数调用
*
* main frame中每个frame需要name和id，以便兼容多浏览器
* 如果需要提供给其他frame调用，则需要在body中加入
* <input id="FrameCall" type='hidden' action='' value='' onclick='FrameCall.api()'/>
* 调用例子：Frame.doFunction('main','goUrl','"'+url+'"');该frame调用id为main的兄弟frame的goUrl方法，参数为后面的
* 参数为字符串时需要加引号，否则传过去会被理解成一个未定义变量
*/
var FrameCall = (function(){
	var idName 		= "FrameCall";
	var idNameAll	= "#"+idName;
	var ie = !-[1,];//是否ie
	return{
		apiOpen:function(){
			var html = '<input id="FrameCall" type="hidden" action="1" value="1" onclick="FrameCall.api()" />';
			$(html).prependTo('body');
		},
		//其他窗口调用该窗口函数，调用另一个frame的方法
		api:function(){
			var action = $(idNameAll).attr('action');
			var value=$(idNameAll).attr('value');
			
			if (action == 'get') {//获取变量
				share.data('create_app_path',eval(value));
				return;
			}			
			var fun=action+'('+value+');';//拼装执行语句，字符串转换到代码
			try{
				eval(fun);
			} catch(e) {};
		},
		//该窗口调用顶层窗口的子窗口api,调用iframe框架的js函数.封装控制器。
		top:function(iframe,action,value){
			if (!window.parent.frames[iframe]) return;
			//var obj = window.top.frames[iframe].document;
			var obj = window.parent.frames[iframe].document;
			obj=obj.getElementById(idName);		
			$(obj).attr("action",action);
			$(obj).attr("value",value);
			obj.click();
		},
		//该窗口调用父窗口的api
		father:function(action,value){
			if (ie){//获取兄弟frame的dom树
				var obj=window.parent.document;//IE
			}else{
				var obj=window.parent.document;//chrome safari firefox...
			}
			obj=obj.getElementById(idName);	
			$(obj).attr("action",action);
			$(obj).attr("value",value);
			obj.click();	
		},
		//___自定义通用方法，可在页面定义更多提供给接口使用的api。
		goUrl:function(url){
			window.location.href=url;
		},
		goRefresh:function(){
			window.location.reload(); 
		}
	}
})();






//通用提示信息框
var tips = function(msg,code){
	Tips.tips(msg,code);
}
var Tips =  (function(){
	var in_time  = 600;
	var delay = 1200;
	var opacity  = 0.7;
	var _init = function(msg,code){
		var tipsIDname = "messageTips";
		var tipsID = "#"+tipsIDname;
		if ($(tipsID).length ==0) {
			var html = '<div id="'+tipsIDname+'" style="z-index:50;min-width:60px;position:fixed;padding:2px 2em;text-align:center;line-height:30px;border-bottom-right-radius:0px;border-bottom-left-radius:0px;"><i style="padding: 0 6px;font-size: 15px;"></i><span></span></div>'
			$('body').append(html);	
			$(window).bind('resize',function(){
				if ($(tipsID).css('display') =="none") return;
				self.stop(true,true)
				$(tipsID).css({'left':($(window).width() - $(tipsID).width()) / 2});
			});
		}
		var self = $(tipsID),icon,color;
		switch(code){
			case 100://加长时间 5s
			case true:
			case undefined:
			case 'success':color = '#5cb85c';icon = 'icon-check';break;
			case 'info':color = '#519AF6';icon = 'icon-info';break;
			case 'warning':color = '#ed9c28';icon = 'icon-bulb';break;
			case false:
			case 'error':color = '#d9534f';icon = 'icon-close';break;
			default:color = '';icon = '';break;
		}

		if (color != '') {
			self.css({'background':color,'color':'#fff'});
			self.find('i').removeClass().addClass(icon);		
		}
		if (msg != undefined) self.find('span').html(msg);
		return self;
	};
	var tips = function(msg,code,offset_top){
		if (typeof(msg) == 'object'){
			code=msg.code;msg = msg.data;
		}
		if (offset_top == undefined) offset_top = 0;
		var self = _init(msg,code);
		if(code == 100){delay = 3500;}
		self.stop(true,true)
			.css({'display':'block','opacity':'0','top':offset_top-self.height(),
				'left':($(window).width() - self.width()) / 2})
			.animate({opacity:opacity,top:offset_top},in_time,0)
			.delay(delay)
			.animate({opacity:0,top:'-='+(offset_top+self.height())},in_time,0,function(){
				$(this).css('display','none');
			});
	};
	var loading = function(msg,code,offset_top){
		if (typeof(msg) == 'object'){
			code=msg.code;msg = msg.data;
		}
		if (offset_top == undefined) offset_top = 0;
		if (msg == undefined) msg = 'loading...'
		msg+= "&nbsp;&nbsp; <img src='"+my.util.global.staticPath+"/images/loading.gif'/>";

		var self = _init(msg,code);
		self.stop(true,true)
			.css({'display':'block','opacity':'0','top':offset_top-self.height(),
				'left':($(window).width() - self.width()) / 2})
			.animate({opacity:opacity,top:offset_top},in_time,0);
	};
	var close = function(msg,code,offset_top){
		if (typeof(msg) == 'object'){
			code=msg.code;msg = msg.data;
		}
		if (offset_top == undefined) offset_top = 0;
		var self = _init(msg,code);

		self.delay(delay)
			.animate({
				opacity:0,
				top:'-='+(offset_top+self.height())},
				in_time,0,function(){
					$(this).css('display','none');
			});
	};
	return{
		tips:tips,
		loading:loading,
		close:close
	}
})();


/**
 * 	var table=new my.util.AjaxLoadTable({
 * 		id:"divID",// 容器Id
 * 		hasPage: true,// 是否分页
 *      feilds:[{title:'用户名',field:'username',width:'100',buildField:null},{title:'姓名',field:'name',buildField:null},{title:'状态',field:'status',buildField:function(value){}}],
 *      actions:[{name:'修改',action:function(row, rowData){}}],
 *		ajaxUrl:"http://www.baidu.com", // 数据请求路径
 *		pageSize:20// 每页大小
 *	});
 *	table.load({pageNo:1});
 * */
my.util.AjaxLoadTable=function(cfg){
	var table=this;
	
	this.cfg=cfg||{};
	this.id=cfg.id||null;
	this.tableId= table.id + "_table";
	this.hasPage=cfg.hasPage||false;
	this.checkBox=cfg.checkBox||false;
	this.ajaxUrl=cfg.ajaxUrl||null;
	this.pageNo=cfg.pageNo||1;
	this.pageSize=cfg.pageSize||20;
	this.feilds = cfg.feilds || [];
	this.actions = cfg.actions || [];
	this.datas = null;
	
	this.load=function(param) {
		param['pageSize'] = table.pageSize;
		this.param = param;
		table.loadData(param, table.buildTable);
	};
	this.loadData = function(param, callback) {
        $.ajax({
            'url' : table.ajaxUrl,
            'data' : param,
            'type' : 'GET',
            'dataType' : 'json',
            'async'	   : true,
            'beforeSend' : function() {
            	
            },
            'success' : function(data) {
                callback(data, param);
            },
            'error'  : function(e) {
        		
            }
        });
        
    };
    this.buildTable = function(data, param) {
    	var html = '<table id="'+table.tableId+'" class="bordered"><thead></thead><tbody></tbody><tfoot></tfoot></table>';
    	$("#"+table.id).html(html);
    	// 编辑表格标题
    	var headHtml = '<tr>';
    	var filedsSize = table.feilds.length||0;
    	var actionsSize = table.actions.length||0;
    	if(table.checkBox) {
    		headHtml += '<th width="20"><input type="checkbox"></th>';
    	}
    	for(var i=0;i<filedsSize;i++) {
    		var filed = table.feilds[i];
    		var width = filed["width"];
    		if(width&&width>0) {
    			headHtml += '<th width="'+width+'">'+filed["title"]+'</th>';
    		} else {
    			headHtml += '<th>'+filed["title"]+'</th>';
    		}
    	}
    	if(actionsSize>0) {
    		var actionWidth = actionsSize*52+10;
    		headHtml += '<th width="'+actionWidth+'">操作</th>';
    	}
    	headHtml += '</tr>';
    	$("#"+table.id+" thead").html(headHtml);
    	if(data && data['list'] && data['list'].length > 0) {
    		table.datas = data['list'];
    		// 编辑表格内容
        	var bodyHtml = '';
        	for(var j=0;j<data['list'].length;j++) {
        		var bdata = data['list'][j];
        		bodyHtml += "<tr>";
        		if(table.checkBox) {
        			bodyHtml += '<td width="20"><input type="checkbox" data_index="'+j+'"></td>';
            	}
        		for(var x=0;x<filedsSize;x++) {
            		var filed = table.feilds[x];
            		var buildFunc = filed['buildField'];
            		var filedText = bdata[filed['field']];
            		if(buildFunc) {
            			filedText = buildFunc(bdata, filedText);
            		}
            		bodyHtml += '<td>'+filedText+'</td>';
            	}
        		if(actionsSize>0) {
        			bodyHtml += '<td class="action">';
        			for(var y=0;y<actionsSize;y++) {
                		var action = table.actions[y];
                		var actionName = action['name'];
                		bodyHtml += '<a href="javascript:void(0)" class="button button-sm table_action_clickme" event_index="'+y+'" data_index="'+j+'">'+actionName+'</a>';
                	}
        			bodyHtml += '</td>';
            	}
        		bodyHtml += "</tr>";
        	}
        	$("#"+table.id+" tbody").html(bodyHtml);
        	// 绑定表格按钮事件
        	table.bindTableAction();
        	// 绑定checkbox事件
        	if(table.checkBox) {
        		table.bindTableCheckBoxAction();
        	}
    		// 编辑表格分页
        	if(table.hasPage) {
        		var footfiledSize = filedsSize;
        		if(actionsSize>0) {
        			footfiledSize = footfiledSize+1;
        		}
        		if(table.checkBox) {
        			footfiledSize = footfiledSize+1;
        		}
        		var footHtml = table.buildPageNav(data['pageNo'], data['totalPage'], data['pretPage'], data['nextPage'], data['totalCount']);
        		$("#"+table.id+" tfoot").html('<tr><td colspan="'+footfiledSize+'">'+footHtml+'</td></tr>');
        		// 绑定分页按钮事件
        		table.bindPageNavAction(data['pageNo'], data['totalPage'], data['pretPage'], data['nextPage'], data['totalCount'], param);
        	}
    	} else {
    		var bodyHtml = '';
    		$("#"+table.id+" tbody").html(bodyHtml);
    	}
    };
    this.bindTableAction=function(){
    	$('.table_action_clickme').bind('click', function() {
    		var event_index = $(this).attr("event_index");
    		var data_index = $(this).attr("data_index");
    		if(event_index&&data_index) {
    			var actionFunc = table.actions[event_index]['action'];
    			var bdata = table.datas[data_index];
    			actionFunc(bdata);
    		}
      	});
    };
    this.bindTableCheckBoxAction=function(){
    	var thInputStr="#"+table.tableId+" th input[type=checkbox]";
    	var tdInputStr="#"+table.tableId+" td input[type=checkbox]";
    	$(thInputStr).bind('click', function() {
    		if($(this)[0].checked) {
    			var inputs = $(tdInputStr);
    			for(var i=0; i<inputs.length; i++) {
                   inputs.eq(i)[0].checked = true;
               }
    		} else {
    			var inputs = $(tdInputStr);
    			for(var i=0; i<inputs.length; i++) {
                   inputs.eq(i)[0].checked = false;
               }
    		}
    	});
    	$(tdInputStr).bind('click', function() {
    		var inputs = $("#"+table.tableId+" td").find('input[type=checkbox]');
	        var selectInputs = $("#"+table.tableId+" td").find('input[type=checkbox]:checked');
	        if(inputs.length == selectInputs.length) {
	            $(thInputStr)[0].checked = true;
	        } else {
	            $(thInputStr)[0].checked = false;
	        }
    	});
    };
    this.getSelectData=function(){
    	var dataArray = [];
    	var selectInputs = $("#"+table.tableId+" td").find('input[type=checkbox]:checked');
    	for(var i=0;i<selectInputs.length;i++) {
    		var data_index = $(selectInputs[i]).attr("data_index");
    		var bdata = table.datas[data_index];
    		dataArray.push(bdata);
    	}
    	return dataArray;
    };
	this.buildPageNav=function(pageNo, totalPage, pretPage, nextPage, totalCount) {
		var html = "<ul class='pagination pagination-sm pull-right'>";
		if (pageNo!=1) {
			html += "<li index='index'><a>首页</a></li>";
			html += "<li index='prev'><a>上一页</a></li>";
		} else {
			html += "<li class='disabled'><a>首页</a></li>";
			html += "<li class='disabled'><a>上一页</a></li>";
		}
		for (var current = 1; current <= totalPage; current++) {
			if (current - pageNo >= -5 && current-pageNo <= 5) {
				if (current==pageNo) {
					html += "<li class='active'><a>"+current+"</a></li>";
				} else {
					html += "<li index='"+current+"' ><a>"+current+"</a></li>";
				}
			}
		}
		if (pageNo!=totalPage) {
			html += "<li index='next'><a>下一页</a></li>";
			html += "<li index='last'><a>末页</a></li>";
		} else {
			html += "<li class='disabled'><a>下一页</a></li>";
			html += "<li class='disabled'><a>末页</a></li>";
		}
		html += "<li class='disabled'><a>共"+totalPage+"页, 共"+totalCount+"条数据</a></li>";
		html += "</ul>";
		return html;
	};
	this.bindPageNavAction=function(pageNo, totalPage, pretPage, nextPage, totalCount, pageParam){
		$("#"+table.id+" tfoot").find('.pagination li').click(function() {
			var index = $(this).attr('index');
			switch(index){
	            case 'index':
	            	pageParam['pageNo'] = 1;
	            	table.load(pageParam);
	                break;
	            case 'prev':
	            	pageParam['pageNo'] = pretPage;
	            	table.load(pageParam);
	                break;
	            case 'next':
	            	pageParam['pageNo'] = nextPage;
	            	table.load(pageParam);
	                break;
	            case 'last':
	            	pageParam['pageNo'] = totalPage;
	            	table.load(pageParam);
	                break;
	            default :
	            	if(index>0) {
	            		pageParam['pageNo'] = index;
	            		table.load(pageParam);
	            	}
	                break;
	        }
		});
	}
};