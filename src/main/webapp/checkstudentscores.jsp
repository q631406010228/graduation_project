<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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

<title>学生答辩成绩管理</title>
</head>
<script type="text/javascript">
	$(function() {
		//var flag;
		$('#stusc').datagrid({
			url : 'showstudentscore',
			title : '学生答辩成绩表',
			singleSelect:true,
			columns : [ [ {
				field : 'che',
				title : 'che',
				checkbox : true,
				width : 100
			}, {
				field : 'sid',
				title : '学生id',
				width : 100,
			//hidden :true
			}, {
				field : 'num',
				title : '学生学号',
				width : 100
			}, {
				field : 'sname',
				title : '学生姓名',
				width : 100
			},

			{
				field : 'score',
				title : '成绩',
				width : 100
			},

			] ],
			toolbar : [
			/* {
				iconCls : 'icon-edit_add',
				handler : function() {
					flag = 0;
					$('#win').window('open');
				}
			}, '-',  */
			{
				iconCls : 'icon-edit',
				handler : function() {
					var row = $('#stusc').datagrid('getSelected');
					$('#sid').textbox('setValue', row.sid);
					$('#sid').textbox('readonly', true);
					$('#snum').textbox('setValue', row.num);
					$('#snum').textbox('readonly', true);
					$('#sname').textbox('setValue', row.sname);
					$('#sname').textbox('readonly', true);

					$('#win').window('open'); 

				}
			} ]

		});
		$('#win').window({
			width : 600,
			height : 400,
			title : '添加/修改学生成绩',
			modal : true,
			closed : true,
			width : '700px',
			height : '150px'
		});
		$("#bfn").linkbutton({
			iconCls : 'icon-ok',
			height : '30px',
			onClick : function() {
				$("#ff").form('submit');
			}
		})
		//配置表单
		$("#ff").form({
			url : 'alterstudentscore',
			onSubmit : function(param) {
				//param.flag = flag;
			},
			success : function(data) {
				var data = eval('(' + data + ')');
				if (data.s) {
					$.messager.confirm('提示', data.msg, function(r) {
						if (r) {
							
							$('#win').window('close');
							//$('#stusc').dategrid('reload');
							location.href = 'http://localhost:8080/graduation_project/checkstudentscores.jsp';
						}
					});
				}
			}
		})

	});
</script>
<body>
	<div id='view'>
		<table id='stusc'>
		</table>

		<!-- 添加/修改学生成绩-->
		<div id="win" style="text-align: center">
			<form id="ff">
				<table id="tab">
					<tr>
					    <th>学生id</th>
						<th>学生学号</th>
						<th>学生姓名</th>
						<th>成绩</th>
					</tr>
					<tr>
					    <td><input id="sid" class="easyui-textbox" name="sid"></td>
						<td><input id="snum" class="easyui-textbox" name="snum"></td>
						<td><input id="sname" class="easyui-textbox" name="sname"></td>
						<td><input id="score" class="easyui-textbox" name="score"></td>
					</tr>
				</table>
				<a id="bfn">提交</a>
			</form>
		</div>
	</div>

</body>
</html>