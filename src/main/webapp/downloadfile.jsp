<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
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
$(function(){
	location.href='showallfile'
})
</script>
<body>
<h1 style = "color : red">下载页面</h1>
<a href ="<c:url value ='/downloadfile?path=20170801.txt'/>">20170801.txt</a><br>
<a href="<c:url value='/downloadServlet?path=a.avi'/>">a.avi</a><br/>

</body>
</html>