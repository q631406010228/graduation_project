<%@ page language="java" contentType="text/html; charset=utf-8"
     pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文件上传</title>
<script type="text/javascript" src="js/bootstrap.js"></script>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="FlexPaper/js/jquery.js"></script>
<script type="text/javascript" src="FlexPaper/js/flexpaper_flash.js"></script>
<script type="text/javascript" src="FlexPaper/js/flexpaper_flash_debug.js"></script>
<script type="text/javascript">
$(document).ready(function() {

	$('#cc').combobox({    
	    url:'getLiteraturelxName',    
	    valueField:'id',    
	    textField:'text'   
	}); 
});
 
</script>
</head>
<body>
<form action="Student_SubmitOpenReport" enctype="multipart/form-data" method="post">
  		<input type="file" name="file"/>
  		<br>
  		<br>
  		<label for="">文件类型选择:&nbsp;&nbsp;</label><input id="cc" name="dept" value="">
  		<br>
  		<br>
  		<input type="submit" value="在线预览">
  	</form>
  	
  
</body>
</html>