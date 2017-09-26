<%@ page language="java" contentType="text/html; charset=utf-8"
     pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文件上传</title>
<<!-- 引入主题样式 -->
<link href="themes/gray/easyui.css" rel="stylesheet">
<!-- 引入图标的样式 -->
<link href="themes/icon.css" rel="stylesheet">
<!-- 先引入jquery -->
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<!-- 引入easyui -->
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
</head>
<script type="text/javascript">
	$(document).ready(function(){
		/*$('#fb').filebox({    
		    buttonText: '选择文件', 
		    buttonAlign: 'right' 
		})*/

	})
</script>
<body>
<form action="Student_SubmitOpenReport" enctype="multipart/form-data" method="post">
  		<!-- <input id="fb" type="text" name="file" style="width:300px"> -->
  		
  		<input type="file" name="file"/></br>
  		<br>
  		<br>
  		<input type="submit" value="在线预览">
  	</form>
  	
  
</body>
</html>