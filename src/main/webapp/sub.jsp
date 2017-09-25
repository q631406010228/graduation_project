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
<title>选题申报</title>
</head>
<script type="text/javascript">
	$(document).ready(function(){
		$('#subname').textbox({
			readonly:false,
			prompt:"请输入课题名称",
			height : 30
		})
		$('#subcontent').textbox({
			multiline:true,
			prompt:"请输入课题描述",
			height : 30
		})
		$('#subcount').textbox({
			multiline:false,
			prompt:"请输入课题容量",
			height : 30
		})
		$('#eid').textbox({
			readonly:true,
			multiline:false,
			value:"1",
			prompt:"请输入教师id",
			height : 30
		})
		$('#btn').linkbutton({
		iconCls : 'icon-ok',
		onClick:function(){
		    $('#ff').form('submit'); 
		}
	});
		$('#ff').form({    
		    url:'AddSubAction',    
		    onSubmit: function(){    
		        // do some check    
		        // return false to prevent submit; 
		         var subname = $("#subname").val();
		    	 var subcount = $("#subcount").val();
			     console.log(name);
			     if(""==subname||""==subcount){
			    	 //cosole.log(name);
			        $.messager.alert('提示',"课题名称或课题容量不能为空",'info',function(){
			        });
			        return false;
			     }
		    },    
		    success:function(data){
		    	var datas = eval('('+data+')');
		    	//console.log(datas);
		    	if(datas.exception == "1"){
		    		$.messager.alert('提示',"申报成功！",'info',function(){
		    			$('#ff').form('clear');
		        	});
		    		
		    	}else{
		    		$.messager.alert('提示',"申报失败！",'info',function(){
		    			$('#ff').form('clear');
		        	});
		    	}	
		    }    
		});
	})
</script>
<body>
	<div style="text-align: center;">
		<h4>选题申报信息</h4>
		<form id="ff" method="post">
			<div>
				<label>课题名称：</label>
				<input id="subname" name="subname" type="text" style="width: 200px">
			</div>
			<br>
			<div>
				<label>课题描述：</label>
				<input id="subcontent" name="subcontent" type="text" style="width: 200px">
			</div>
			<br>
			<div>
				<label>课题容量：</label>
				<input id="subcount" name="subcount" type="text" style="width: 200px">
			</div>
			<br>
			<div style="margin-left: 17px;">
				<label>教师id：</label>
				<input id="eid" name="eid" type="text" style="width: 200px">
			</div>
			<br>
			<div style="margin-left: 50px;">
				<a id="btn" href="#">提交</a>
			</div>
		</form>
	</div>
</body>
</html>