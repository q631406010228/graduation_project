<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
<title>学生名单</title>
</head>
<script type="text/javascript">
	$(document).ready(function(){
		$("#tb").datagrid({
			url:'selectStudentForm',
		    title:'学生答辩过程信息',
		    striped:true,
		    fitColumns:true,
		    pageSize:10,
		    pageList:[10,20,30],
		    pagination:true,
		    rownumbers:true,
		    columns:[[    
		        {field:'ck',title:'ck',checkbox:true,width:100},    
		        {field:'num',title:'学生学号',width:100}, 
		        {field:'sname',title:'学生姓名',width:100},
		        {field:'colname',title:'学院',width:100},
		        {field:'majname',title:'专业',width:100},    
		        {field:'subname',title:'课题名称',width:100},
		    ]],
		});
		
		//配置修改信息窗口
		$("#sendStudentWin").window({
			width : 600,
			height : 400,
			title : '修改信息',
			closable :true,
			collapsible : true
		})
		
		$('#sendStudentWin').window('close'); 
		
		//添加  毕业设计进程  的提交按钮
		$('#btn').linkbutton({    
		    iconCls: 'icon-ok',
		    onClick:function(){
		    	$('#ff').form('submit', {    
		    	    url:'setSN',    
		    	    onSubmit: function(param){ 
		    	    	param.gpContent = $('#gpc').combobox("getText");
		    	    	param.graStartTime = $('#graStartTime').datebox("getText");
		    	    	param.graEndTime = $('#graEndTime').datebox("getText");
		    	    },    
		    	    success:function(data){  
		    	    	$.messager.alert('警告','提交成功','info',function(){
				    		
				    	});   				    	    	
		    	    }    
		    	});
		    }
		});	
		
		//添加  毕业设计进程  的提交按钮
		$('#btnExport').linkbutton({    
		    iconCls: 'icon-ok',	
		});	
		
		$(function(){    
		    $('#btnExport').bind('click', function(){    
		    	var rows = $('#tb').datagrid('getSelections');
				if(rows.length == 0){
					return false;
				}
				var sids = [];
				for(var i = 0;i < rows.length;i++){
					sids[i] = rows[i].num;
				} 
				$('#sid1').textbox('setText',sids.join(","));
				$('#sendStudentWin').window('open');  
		    });    
		});
	
	})
</script>
<body>
	<div id="sendStudentWin">
		<form id="ff" method="post">
			<div style="margin-left: 150px;margin-top: 50px; ">
			    <div style="margin-left: 7px">
					<label >学生ID :</label> <input id="sid1" name="sid"
						type="text" style="width: 200px">
				</div>
				<br>
				<div>
					<label >选题名称:</label> <input id="subname1" name="subname"
						type="text" style="width: 200px">
				</div>
				<br>
				<div>
					<label for="password">答辩问题:</label> <input id="ques1"
						name="ques" type="text" style="width: 200px">
				</div>
				<br> 
				<div style="margin-left: 120px;">
					<a id="btn" href="#">提交</a>
				</div>
			</div>
		</form>
	</div>
	<div style="text-align: center;">
		<table id = "tb"></table>
		<a href="#" class="easyui-linkbutton" style="width:10%;margin-top: 10px" id="btnExport">发送通知</a> 
	</div>
</body>
</html>