
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
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
</head>
<script type="text/javascript">
var ar6 = new Array();
	$(function() {
		//保存按钮
		$('#btn1').linkbutton({
			iconCls : 'icon-add',
			onClick : function() {
				
				$('#ff').submit();
				/* 	 	    	 url : 'save' */
				$.messager.confirm('修改提示', 'OK', function(r) {
					if(r){
					$('#ff').form('reset');
					$('#tt').tree('reload');
					$('#shuru').hide();
					}
				})

			},

		});

		//取消按钮
		$('#btn2').linkbutton({
			iconCls : 'icon-cancel',
			onClick : function() {
				$('#shuru').hide()

			}
		});
		$('#uname1').textbox({
			iconCls : 'icon-man',
			iconAlign : 'left',
			prompt : '输入答辩地点',
			height : 40
		})
		$('#uname2').textbox({
			iconCls : 'icon-man',
			iconAlign : 'left',
			prompt : '输入选题ID',
			height : 40
		})
		$('#uname3').datebox({
			required : true
		});
		$('#uname4').datebox({
			required : true
		});
		$('#uname5').textbox({
			iconCls : 'icon-man',
			iconAlign : 'left',
			prompt : '输入教师ID',
			height : 40
		})

		$("#add").linkbutton({
			iconCls : 'icon-add',
			onClick : function() {
				$('#shuru').show(),
				$('#ff').form('options').queryParams = {
					flag : 1
				};

			}
		});
		$("#alert").linkbutton({
			iconCls : 'icon-cut',
			onClick : function() {
				$('#shuru').show()
				var selectedrows =$('#dg').datagrid('getChecked');
				
				
				
				$.each( selectedrows , function(i,n){
							ar6[i] = n.reply_id;
										});
				$('#uname6').val(ar6[0]);
				 $('#ff').form('options').queryParams = {
					flag : 2,
					id:ar6[0],

				} ;
				
				
				
				
				
				
				/*  

				
								
								var ar1 = new Array();
								var ar2 = new Array();
								var ar3 = new Array();
								var ar4 = new Array();
								var ar5 = new Array();
								
								
								
								$.each( selectedrows , function(i, 

				n){
									 ar1[i] = n.reply_site;
								});
								$.each( selectedrows , function(i, 

				n){
									 ar2[i] = n.sub_state;
								});
								$.each( selectedrows , function(i, 

				n){
									 ar3[i] = n.reply_start;
								});
								$.each( selectedrows , function(i, 

				n){
									 ar4[i] = n.reply_end;
								});
								$.each( selectedrows , function(i, 

				n){
									 ar5[i] = n.e_id;
								});
								
								
								
								$('#uname1').val(ar1[0])
								$('#uname2').val(ar2[0])
								$('#uname3').val(ar3[0])
								$('#uname4').val(ar4[0])
								$('#uname5').val(ar5[0])
								 */
								
								/* param.p1=ar1
								param.p2=ar2
								param.p3=ar3
								param.p4=ar4
								param.p5=ar5
								*/

			}
		});
		$("#delete").linkbutton({
			iconCls : 'icon-remove',
			onClick : function() {
			
				
		var selectedrows =$('#dg').datagrid('getChecked');
			 $.each( selectedrows , function(i,n){
							ar6[i] = n.reply_id;
										});
				$('#uname6').val(ar6[0]);
				$('#ff1').form('options').queryParams = {
					flag : 3,
					id:ar6[0],
				}; 
				
				
				$('#ff1').submit();
				
				
			
				$.messager.confirm('修改提示', 'OK', function(r) {
					if(r){
					$('#ff1').form('reset');
					$('#tt').tree('reload');
					$('#shuru').hide();
					}
				})
				

			}
		});
		$('#dg').datagrid({
			url : 'replyTable',
			pagination : true,
			pageSize : 3,
			pageList : [ 3, 6, 9 ],
			rownumbers : true,
			title : '答辩任务列表',
			columns : [ [

			{
				field : 'reply_id',
				title : '答辩ID',
				width : 100,
				checkbox : true
			}, {
				field : 'reply_site',
				title : '答辩地点',
				width : 100
			}, {
				field : 'sub_id',
				title : '选题ID',
				width : 100,
				hidden : true
			}, {
				field : 'sub_name',
				title : '选题标题',
				width : 100
			}, {
				field : 'reply_start',
				title : '答辩起始时间',
				width : 100
			}, {
				field : 'reply_end',
				title : '答辩结束时间',
				width : 100
			}, {
				field : 'e_id',
				title : '老师ID',
				width : 100
			}, {
				field : 'e_name',
				title : '老师名字',
				width : 100
			}

			] ]

		});
		$('#ff').form({
			url : 'save',
			
			success : function(data) {

				$('#dg').datagrid('reload');

			}
		});
		$('#ff1').form({
			url : 'save',
			
			success : function(data) {

				$('#dg').datagrid('reload');

			}
		});
		//	$('#ff').submit();  
	});
</script>
<body>
<form id="ff1" method="post">
</form>


	<form id="ff" method="post">
		<div id="shuru"
			style="z-index: 100; display: none; margin-left: 29%; margin-top: 10%; position: absolute; width: 100%; height: 100%;">
			<input id="uname1" name="uname1" type="text" style="width: 300px">
			<br> <input id="uname2" name="uname2" type="text"
				style="width: 300px"> <br> 起始时间<input id="uname3"
				name="uname3" type="text" style="width: 300px"></input> <br>
			终止时间<input id="uname4" name="uname4" type="text" style="width: 300px"></input>
			<br> <input id="uname5" name="uname5" type="text"
				style="width: 300px"> <br> <a id="btn1" href="#"
				style="margin-top: 10px">保存</a> <a id="btn2" href="#"
				style="margin-top: 10px">取消</a>
		</div>
		<br>


		<table id="dg"></table>
		<div style="margin-top: 50px; margin-left: 30%">
			<button style="margin-right: 20px" id="add">添加工作</button>
			<button style="margin-right: 20px" id="alert">修改工作</button>
			<button style="margin-right: 20px" id="delete">删除工作</button>
		</div>

	</form>

</body>
</html>