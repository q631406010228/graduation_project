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
</head>
<body>
	<div>
		<h4>学生选题</h4>
		<table id = "tb"></table>
	<div id="upwin">
		<form id="ff" method="post">
			<div style="margin-left: 150px;margin-top: 50px; ">
			    <div style="margin-left: 7px">
					<label >选题:</label> <input id="sid1" name="sid"
						type="text" style="width: 200px">
				</div>
				<br>
				<div>
					<label >选题内容:</label> <input id="sname1" name="sname"
						type="text" style="width: 200px">
				</div>
				<br>
				<div>
					<label >负责教师:</label> <input id="subname1" name="subname"
						type="text" style="width: 200px">
				</div>
				<br>
				<div>
					<label for="password">限选人数:</label> <input id="ques1"
						name="ques" type="text" style="width: 200px">
				</div>
				<br> 
				<div>
					<label for="password">选题状态:</label> <input id="answer1"
						name="answer" type="text" style="width: 200px">
				</div>
				<br> 
				<div style="margin-left: 120px;">
					<a id="btn" href="#">提交</a>
				</div>
			</div>
		</form>
	</div>
	<div id="addwin">
		<form id="ff1" method="post">
			<div style="margin-left: 150px;margin-top: 100px; ">
				<div>
					<label for="name">学生姓名:</label> <input id="sid" name="sid"
						type="text" style="width: 200px">
				</div>
				<br>
				<div>
					<label for="password">答辩问题:</label> <input id="ques"
						name="ques" type="text" style="width: 200px">
				</div>
				<br> 
				<div>
					<label for="password">答辩答案:</label> <input id="answer"
						name="answer" type="text" style="width: 200px">
				</div>
				<br> 
				<div style="margin-left: 120px;">
					<a id="btn1" href="#">提交</a>
				</div>
			</div>
		</form>
	</div>
	</div>
</body>
</html>