<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 引入主题样式 -->
<link href="themes/gray/easyui.css" rel="stylesheet">
<!-- 引入图标的样式 -->
<link href="themes/icon.css" rel="stylesheet">
<!-- 先引入jquery -->
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<!-- 引入easyui -->
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<title>学生文档审批</title>
</head>
<script type="text/javascript">
	$(document).ready(function(){
		/*$("#tb").datagrid({
			url:'selectLiteratureAction',
	   	 	title:'学生答辩过程信息',
	    	striped:true,
	    	fitColumns:true,
	    	pageSize:10,
	    	pageList:[10,20,30],
	    	pagination:true,
	    	rownumbers:true,
	    	columns:[[    
	        	{field:'ck',title:'ck',checkbox:true,width:100},    
	        	{field:'wxname',title:'文档名称',width:100}, 
	        	{field:'sname',title:'学生姓名',width:100},
	        	{field:'wxlxname',title:'文献类型',width:100},
	        	{field:'wxstate',title:'状态',width:100},   
	        	{field:'',title:'分配用户角色', width: 100,editor:{
	            	type:'combobox',
	            	options:{
	            		valueField:'text',    
	     		    	textField:'text',
	     		    	prompt :'',
	                	method:'post',
	                	url:'',
	                	required:true
	            		}
	    			}
	    		}
			]],
			onCheck:function(index,row){//选中单元格事件
				$('#tb').datagrid('beginEdit', index);
		 	//var ed =  $("#dg").datagrid('getEditor',{index:index,field:row.tpassword});
			},
			onBeforeUncheck:function(index,row)
			{
				$('#tb').datagrid('selectRow',index).datagrid('endEdit', index);
			},
	    	toolbar: {
				iconCls: 'icon-edit',
				text:'下载',
				handler: function(){
				var rows = $("#tb").datagrid('getSelected');
				}
			}
		})*/
		$("#tb").datagrid({
			url:'selectLiteratureAction',
		    title:'学生答辩过程信息(注意：状态0为未审核，1为通过，2为驳回)',
		    striped:true,
		    fitColumns:true,
		    pageSize:10,
		    pageList:[10,20,30],
		    pagination:true,
		    rownumbers:true,
		    columns:[[    
			        	{field:'ck',title:'ck',checkbox:true,width:100},
			        	{field:'wxid',title:'文档id',width:100}, 
			        	{field:'wxname',title:'文档名称',width:100}, 
			        	{field:'sname',title:'学生姓名',width:100},
			        	{field:'wxlxname',title:'文献类型',width:100},
			        	{field:'wxstate',title:'状态',width:100},   
			        	{field:'xxx',title:'审核', width: 100,editor:{
			            	type:'combobox',
			            	options:{
			            		valueField:'text',    
			     		    	textField:'text',
			     		    	prompt :'请审核',
			                	method:'post',
			                	url:'selectState',
			                	required:true
			            		}
			    			}
			    		}
					]],
					onCheck:function(index,row){//选中单元格事件
						$('#tb').datagrid('beginEdit', index);
				 	//var ed =  $("#dg").datagrid('getEditor',{index:index,field:row.tpassword});
					},
					onBeforeUncheck:function(index,row)
					{
						var ed = $("#tb").datagrid('getEditors',index);
						var wxid = row.wxid;
						var state = $(ed[0].target).data('textbox').options.value;
						$('#tb').datagrid('selectRow',index).datagrid('endEdit', index);
						$.ajax({
							url:"shenhe",
							data:"wxid="+wxid+"&state="+state,
							type:"post",
							dataType : 'json',
							success:function(data){
								if(data.ok != "1"){
									$.messager.alert('提示',"分配失败",'info',function(){})
								}else{
									$.messager.alert('提示',"分配成功",'info',function(){
										$('#tb').datagrid('reload');
									})
								}
					        }
						})
					},
			    	toolbar: [{
						iconCls: 'icon-edit',
						text:'下载',
						handler: function(){
							var rows = $("#tb").datagrid('getSelected');
						}
					}]
		})
	})
</script>
<body>
	<table id ="tb"></table>
</body>
</html>