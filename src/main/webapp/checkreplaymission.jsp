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
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>

<title>查看答辩工作任务</title>
</head>

<script type="text/javascript">
$(function(){
	$('#mission').datagrid({    
	    url:'showreplymission',    
	    columns:[[    
	        {field:'replysite',title:'答辩地点',width:100},    
	        {field:'subname',title:'论文课题名',width:100},    
	        {field:'replystart',title:'开始时间',width:100,align:'right'},    
	        
	    ]]    
	});  

})
</script>
<body>
<table id='mission'>
</table>

</body>
</html>