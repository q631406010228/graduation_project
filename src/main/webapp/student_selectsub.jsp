<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生选题</title>
<!-- 引入主题样式 -->
<link href="themes/gray/easyui.css" rel="stylesheet">
<!-- 引入图标的样式 -->
<link href="themes/icon.css" rel="stylesheet">
<!-- 先引入jquery -->
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<!-- 引入easyui -->
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/student_selectsub.js"></script>
</head>
<body>
<table id="dg"></table> 

<!-- 修改的窗口 -->
	<div id="upwin">
		<form id="ff"  method="post">  
				<div  style="margin-left: 120px;margin-top: 100px">
				选题的id: <input id="sub_id" name="sub_id" type="text" style="width:300px">
				<br>
				<br>
				选题：<input id="sub_name" name="sub_name"  type="text" style="width:300px">
				<br>
				<br>
				负责教师：<input id="e_name" name="e_name"  type="text" style="width:300px">
				<br>
				<br>
				<a id="btn" href="#">提交</a>    
				</div>
		</form>
	
	</div> 
</body>
</html>