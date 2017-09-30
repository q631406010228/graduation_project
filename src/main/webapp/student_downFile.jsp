<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>下载已上传的文献</title>
<!-- 引入主题样式 -->
<link href="themes/gray/easyui.css" rel="stylesheet">
<!-- 引入图标的样式 -->
<link href="themes/icon.css" rel="stylesheet">
<!-- 先引入jquery -->
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<!-- 引入easyui -->
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/downfile.js"></script>
</head>
<body>
<table id="dg"></table>

<!-- 修改的窗口 -->
	<div id="upwin">
		<form id="ff"  method="post">  
				<div  style="margin-left: 120px;margin-top: 100px">
				文献名: <input id="wx_name" name="wx_name" type="text" style="width:300px">
				<br>
				<br>
				文献类型：<input id="wxlx_name" name="wxlx_name"  type="text" style="width:300px">
				<br>
				<br>
				<input id="wx_content" name="wx_content"  type="text" style="width:300px;hidden:true" >
				<a id="btn" href="#">确认下载</a>    
				</div>
		</form>
	
	</div> 
</body>
</html>