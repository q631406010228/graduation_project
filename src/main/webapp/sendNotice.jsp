<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="themes/metro/easyui.css" rel="stylesheet" />
<link href="themes/icon.css" rel="stylesheet" />
<script type="text/javascript" src="jquery1.7.2/jquery-1.7.2.js"></script>
<script type="text/javascript" src="jquery1.7.2/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="jquery1.7.2/jquery.easyui.min.js"></script>
<script type="text/javascript">
	$(function() {
		
		//构建  添加通知的信息  窗口
		$('#gpIn').window({
			title:'添加学生通知窗口',
			width : 600,
			height : 400,
			modal : true
		})
		
		//添加通知的信息程的提交按钮
		$('#keep').linkbutton({    
		    iconCls: 'icon-ok',
		    onClick:function(){
		    	$('#gpForm').form('submit', {    
		    	    url:'setNotice',    
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
		    	    	param.sendID = 1;	//系主任的ID
		    	    },    
		    	    success:function(data){  
		    	    	$.messager.alert('警告','提交成功','info',function(){
				    		
				    	});   				    	    	
		    	    }    
		    	});
		    }
		});	
		
		//通知的内容
		$('#sendNoticText').textbox({    
			width:300,
			height:100,
		    iconAlign:'left',
		    multiline:true
		});
		
		//通知的标题
		$('#sendNoticTitle').textbox({    
			width:300,
		    iconAlign:'left',
		});
		
		//通知角色的下拉选框
		$('#selectRole').combobox({    
		    url:'getRoles',    
		    valueField:'id',    
		    textField:'text'   
		});
 		
	});
</script>
</head>
<body>
	<div id="gpIn">
		<form id="gpForm" method="post">
			<div>
				<div style = "margin:10% 0 0 20%;">	
					选择角色&nbsp;&nbsp;<input id="selectRole" name="role" value="学生"> 		
					<br><br>
					<input id="sendNoticTitle" name="snTitle" type="text"  >
					<br><br>		
					<input id="sendNoticText" name="snContent" type="text"  >					
				</div>
				<br>
				<br>	
				<div>
					<a id="keep" href="#" style="margin-left:35%;">提交</a>
				</div>
			</div>
		</form>
	</div> 
</body>
</html>