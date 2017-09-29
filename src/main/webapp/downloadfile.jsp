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
	$(function() {
		$('#dg').datagrid({
			url : 'showstudentpapers',
			pagination:true,
		    pageSize:10,
		    pageList:[10,20,30,40,50,60],
			title:'查看学生论文',
			columns : [ [ 
			    {field:'lwname',title:'文件名',width:100},    
			    {field:'sid',title:'学生id',width:100}, 
			    {field:'snum',title:'学生学号',width:100}, 
			    {field:'sname',title:'学生姓名',width:100},              
			    {field:'lwstate',title:'状态',width:100},
			    {field:'lwcount',title:'上传次数',width:100},
			    {field:'lwoperate',title:'审核',width:100},
			    {field:'lwbackload',title:'批复文件',width:100},
			] ]
		});

	});
</script>
<body>

	<table id="dg"></table>

</body>
</html>