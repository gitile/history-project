my.register('my.setting');
var table=new my.util.AjaxLoadTable({
 	id:"userDiv",// 容器Id
 	ajaxUrl:my.util.global.contextPath+'setting/user_grid', // 数据请求路径
 	hasPage: true,// 是否分页
 	checkBox: true,// 是否添加checkbox
 	pageSize:20,// 每页大小
 	feilds:[// 显示字段
 	    {
 			title:'姓名',// 标题
 			field:'name',// 内容
 			buildField:function(row, rowValue){ // 组装表格数据
 				var sex = row["sex"]||0;
 				var sexName = '未知';
 				if(sex==1) {
 					sexName = "男"
 				} else if(sex==2) {
 					sexName = "女"
 				}
 				return rowValue+"("+sexName+")";
 			}
 		},{
 			title:'角色',
 			field:'roleName',
 			width:'100'
 		},{
 			title:'部门',
 			field:'deptName',
 			width:'200',
 			buildField:function(row, rowValue){
 				var positionName = row["positionName"] || "未知";
 				return rowValue+"("+positionName+")";
 			}
 		},{
 			title:'状态',
 			field:'status',
 			width:'40',
 			buildField:function(row, rowValue){
 				if(rowValue==1) {
 					return "<font color='green'>正常</font>";
 				} else if(rowValue==2) {
 					return "<font color='red'>已冻结</font>";
 				} else if(rowValue==3) {
 					return "<font color='red'>已删除</font>";
 				}
 			}
 		}
 	],
 	actions:[// 操作事件
 	    {
 	    	name:'修改',
        	action:function(row){
		 		var id = row["id"];
		 		alert(id);
			}
 	    },{
 	    	name:'删除',
 	    	css:'delete',
        	action:function(row){
		 		var id = row["id"];
		 		alert(id);
			}
 	    }
    ]
});
$(document).ready(function(){
	my.util.leftMenuInit();
	// 刷新页面
	Mousetrap.bind(['f5'],function(e) {
		stopEP(e);
		top.artDialog.focus.refresh();
    });
	table.load({pageNo:1});
});