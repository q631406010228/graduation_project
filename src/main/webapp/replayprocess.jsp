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
<title>学生答辩过程记录</title>
</head>
<script type="text/javascript">
$(document).ready(function(){
	   
	
	$("#tb").datagrid({    
	    url:'selectReplyPricess',
	    title:'学生答辩过程信息',
	    striped:true,
	    fitColumns:true,
	    pageSize:10,
	    pageList:[10,20,30],
	    pagination:true,
	    rownumbers:true,
	    columns:[[    
	        {field:'ck',title:'ck',checkbox:true,width:100},    
	        {field:'sid',title:'学生id',width:100}, 
	        {field:'sname',title:'学生姓名',width:100},
	        {field:'subname',title:'选题',width:100},
	        {field:'prid',title:'答辩记录id',width:100,hidden:true},    
	        {field:'ques',title:'答辩问题',width:100},
	        {field:'answer',title:'答辩答案',width:100}    
	    ]],
		toolbar: [{
			iconCls: 'icon-edit',
			text:'修改',
			handler: function(){
				var rows = $("#tb").datagrid('getSelected');
				$('#upwin').window('open');
				$('#ff').form('load',rows);
			}
		},'-',{
			iconCls: 'icon-add',
			text:'添加',
			handler: function(){
				$('#addwin').window('open');
			}
		},'-',{
			iconCls: 'icon-remove',
			text:'删除',
			handler: function(){
				var rows = $("#tb").datagrid('getSelections');
				var sids = new Array();
				for (var i = 0; i < rows.length; i++) {
					console.log(rows[i].sid);
					sids.push(rows[i].sid);
				}
				$.messager.confirm('提醒', '确认删除这几条记录吗？', function(r){
					if (r){
						$.ajax({
							url:'deleteReplyProcess',
							data:"sid=" + sids,
							datatype:'json',
							type:'post',
							success:function(data){
								var datas = eval('('+data+')');
								console.log(datas.exce);
								$.messager.alert('提示',datas.exce,'info',function(){
									$('#tb').datagrid('reload');
			        			});
							}
						})
					}
				});
			}
		}]

	});
	//配置修改信息窗口
	$("#upwin").window({
		width : 600,
		height : 400,
		title : '修改信息',
		closable :true,
		collapsible : true
	})
	//配置添加信息窗口
	$("#addwin").window({
		width : 600,
		height : 400,
		title : '添加信息',
		closable :true,
		collapsible : true
	})
	$('#upwin').window('close'); 
	$('#addwin').window('close'); 
	$('#sid').combobox({    
	    url:'selectStudentByEid',    
	    valueField:'id',  
	    prompt:"请选择学生",
	    textField:'text',
	    height:30,
	});
	$('#sid1').textbox({
		readonly:true,
		prompt:"请录入答辩问题",
		height : 30
	})
	$('#sname1').textbox({
		readonly:true,
		prompt:"请录入答辩问题",
		height : 30
	})
	$('#subname1').textbox({
		readonly:true,
		prompt:"请录入答辩问题",
		height : 30
	})
	$('#ques').textbox({
		multiline:true,
		prompt:"请录入答辩问题",
		height : 30
	})
	$('#ques1').textbox({
		prompt:"请录入答辩问题",
		multiline:true,
		height : 30
	})
	$('#answer').textbox({
		prompt:"请录入学生答案",
		multiline:true,
		height : 30
	})
	$('#answer1').textbox({
		prompt:"请录入学生答案",
		multiline:true,
		height : 30
	})
	//配置修改提交按钮
	$('#btn').linkbutton({
		iconCls : 'icon-ok',
		onClick:function(){
		    $('#ff').form('submit'); 
		}
	});
	//配置添加提交按钮
	$('#btn1').linkbutton({
		iconCls : 'icon-ok',
		onClick:function(){
		    $('#ff1').form('submit'); 
		}
	});
	//配置修改表单
	$('#ff').form({    
	    url:'updateReplyProcess',    
	    onSubmit: function(){    
	        // do some check    
	        // return false to prevent submit; 
	         var sid = $("#sid1").val();
	    	 var ques = $("#ques1").val();
		     var answer = $("#answer1").val();
		     console.log(name);
		     if(""==ques||""==answer||""==sid){
		    	 //cosole.log(name);
		        $.messager.alert('提示',"修改失败",'info',function(){
		        });
		        return false;
		     }
	    },    
	    success:function(data){
	    	var datas = eval('('+data+')');
	    	//console.log(datas);
	    	if(datas.exception == "1"){
	    		$.messager.alert('提示',"修改成功！",'info',function(){
	    			$('#ff').form('clear');
		    		$('#upwin').window('close');
		    		$('#tb').datagrid('reload');
	        	});
	    		
	    	}else{
	    		$.messager.alert('提示',"修改失败！",'info',function(){
	    			$('#ff').form('clear');
		    		$('#upwin').window('close');
	        	});
	    	}	
	    }    
	});
	//配置添加信息表单
	$('#ff1').form({    
	    url:'addReplyProcess',    
	    onSubmit: function(){    
	        // do some check    
	        // return false to prevent submit;
	        var ques = $("#ques").val();
	        var answer = $("#answer").val();
	        console.log(name);
	        if(""==ques||""==answer){
	        	$.messager.alert('提示',"添加失败",'info',function(){
	        	});
	        	return false;
	        }
	    },    
	    success:function(data){
	    	var datas = eval('('+data+')');
	    	//console.log(datas);
	    	if(datas.exception=="1"){
	    		$.messager.alert('提示',"添加成功！",'info',function(){
	    			$('#ff1').form('clear');
		    		$('#addwin').window('close');
		    		$('#tb').datagrid('reload');
	        	});
	    		
	    	}else{
	    		$.messager.alert('提示',"添加失败！",'info',function(){
	    			$('#ff1').form('clear');
		    		$('#addwin').window('close');
	        	});
	    	}	
	    }    
	});
})
</script>

<body>
	<div>
		<h4>学生答辩过程信息</h4>
		<table id = "tb"></table>
	<div id="upwin">
		<form id="ff" method="post">
			<div style="margin-left: 150px;margin-top: 50px; ">
			    <div>
					<label >学生ID :</label> <input id="sid1" name="sid"
						type="text" style="width: 200px">
				</div>
				<br>
				<div>
					<label >学生姓名:</label> <input id="sname1" name="sname"
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
				<div>
					<label for="password">答辩答案:</label> <input id="answer1"
						name="answer" type="text" style="width: 200px">
				</div>
				<br> 
				<div style="margin-left: 120px;">
					<a id="btn" href="#">提交</a>
				</div>
			</div>
		</form>
	</div>
	<div id="addwin">
		<form id="ff1" method="post">
			<div style="margin-left: 150px;margin-top: 100px; ">
				<div>
					<label for="name">学生姓名:</label> <input id="sid" name="sid"
						type="text" style="width: 200px">
				</div>
				<br>
				<div>
					<label for="password">答辩问题:</label> <input id="ques"
						name="ques" type="text" style="width: 200px">
				</div>
				<br> 
				<div>
					<label for="password">答辩答案:</label> <input id="answer"
						name="answer" type="text" style="width: 200px">
				</div>
				<br> 
				<div style="margin-left: 120px;">
					<a id="btn1" href="#">提交</a>
				</div>
			</div>
		</form>
	</div>
	</div>
</body>
</html>