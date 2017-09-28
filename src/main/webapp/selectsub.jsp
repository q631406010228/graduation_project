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
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<title>选题申报查看</title>
</head>
<script type="text/javascript">
	$(document).ready(function() {
		$.ajax({
			url:'selectSub',
			data:'',
			type:'post',
			dataType:'json',
			success:function(data){
				$('#subname').textbox('setValue','${sessionScope.subname}');
				$('#subcontent').textbox('setValue','${sessionScope.subcontent}');
				$('#subcount').textbox('setValue','${sessionScope.subcount}');
				$('#state').textbox('setValue','${sessionScope.state}');	
			}
		})
		//location.href="selectsub.jsp"
		$('#subname').textbox({
			readonly:true,
			height : 30,
			//value:''
		})
		$('#subcontent').textbox({
			readonly:true,
			multiline:true,
			height : 60,
			//value:''
		})
		$('#subcount').textbox({
			readonly:true,
			multiline:false,
			height : 30,
			//value:''
		})
		$('#state').textbox({
			readonly:true,
			multiline:false,
			height : 30,
			//value:''
		})
	})
</script>
<body>
	<div style="text-align: center;">
		<h4>选题申报信息</h4>
		<div>
			<label>课题名称：</label> <input id="subname" name="subname" type="text"
				style="width: 200px">
		</div>
		<br>
		<div>
			<label>课题描述：</label> <input id="subcontent" name="subcontent"
				type="text" style="width: 200px">
		</div>
		<br>
		<div>
			<label>课题容量：</label> <input id="subcount" name="subcount" type="text"
				style="width: 200px">
		</div>
		<br>
		<div >
			<label>课题状态：</label> <input id="state" name="state" type="text"
				style="width: 200px">
		</div>
	</div>
</body>
</html>