<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="themes/metro/easyui.css" rel="stylesheet" />
<link href="themes/icon.css" rel="stylesheet" />
<script type="text/javascript" src="jquery1.7.2/jquery-1.7.2.js"></script>
<script type="text/javascript" src="jquery1.7.2/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="jquery1.7.2/jquery.easyui.min.js"></script>
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
		    	    url:'sendStudentNotice',    
		    	    onSubmit: function(param){  
		    	    	var myDate = new Date();
		    	    	//获取当前年
		    	    	var year=myDate.getFullYear();	//相较于getYear兼容性更好，可以兼容火狐
		    	    	//获取当前月
		    	    	var month=myDate.getMonth()+1;
		    	    	//获取当前日
		    	    	var date=myDate.getDate(); 
		    	    	var now=year+'-'+month+"-"+date;
		    	    	param.data = now;
		    	    	param.eID = '2';  	//教师的eID    
		    	    },    
		    	    success:function(data){    
		    	    	$.messager.alert('警告','添加成功','info',function(){
				    		$('#ff').form('clear');
				    		$('#sendStudentWin').window('close');
				    	}); 
		    	    }    
			    });
		    }
		});	
		
		//添加  毕业设计进程  的提交按钮
		$('#btnExport').linkbutton({    
		    iconCls: 'icon-ok',	
		});	
		
		$('#sids').textbox({    
			width: 300,          
		})
		
		$('#subname1').textbox({    
			width: 300,          
		})
		
		$('#ques1').textbox({    
			width:300,
			height:100,
		    iconAlign:'left',
		    multiline:true
		})
		
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
				$('#sendStudentWin').window('open');
				$('#sids').textbox('setValue',sids.join());				
		    });    
		});
	
	})
</script>
<body>
	<div id="sendStudentWin">
		<form id="ff" method="post">
			<div style="margin-left: 100px;margin-top: 50px; ">
			    <div style="margin-left: 7px">
					<label >学生ID :</label> <input id="sids" name="sid"
						type="text">
				</div>
				<br>
				<div>
					<label >通知题目:</label> <input id="subname1" name="subname"
						type="text">
				</div>
				<br>
				<div>
					<label for="password">通知内容:</label> <input id="ques1"
						name="ques" type="text">
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