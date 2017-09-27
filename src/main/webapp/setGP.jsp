<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="themes/metro/easyui.css" rel="stylesheet" />
<link href="themes/icon.css" rel="stylesheet" />
<script type="text/javascript" src="jquery1.7.2/jquery-1.7.2.js"></script>
<script type="text/javascript" src="jquery1.7.2/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="jquery1.7.2/jquery.easyui.min.js"></script>
<script type="text/javascript">
	$(function() {
		
		//构建  添加毕业设计进程   窗口
		$('#gpIn').window({
			title:'添加毕业设计进程窗口',
			width : 600,
			height : 400,
			modal : true
		})
		
		//添加毕业设计进程的提交按钮
		$('#keep').linkbutton({    
		    iconCls: 'icon-ok',
		    onClick:function(){
		    	$('#gpForm').form('submit', {    
		    	    url:'setGP',    
		    	    onSubmit: function(param){
		    	    	if($('#graStartTime').datebox('getValue') >= $('#graEndTime').datebox('getValue')){
		    	    		$("#tip").css("display","inline");
		    	    		return false;
		    	    	}
		    	    	$("#tip").css("display","none");
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
		
		
		//毕业设计进程开始时间设置
		$('#graStartTime').datebox({    
		    value: '3/4/2017 2:3',    
		    required: true,    
		    showSeconds: false   
		});
			
		//毕业设计进程结束时间设置
		$('#graEndTime').datebox({    
		    value: '3/5/2017 2:3',    
		    required: true,    
		    showSeconds: false   
		});
		
		//毕业设计进程内容的下拉选框
		$('#gpc').combobox({    
		    url:'getGP',    
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
					毕业设计进程&nbsp;&nbsp;<input id="gpc" name="role" value="毕业设计开题"> 
					<br>
					<br>
					开始时间&nbsp;&nbsp;<input id="graStartTime" type="text" name="birthday"></input> &nbsp;&nbsp;&nbsp;&nbsp;
					<br>
					<br>
					结束时间&nbsp;&nbsp;<input id="graEndTime" type="text" name="birthday"></input>
					<p id="tip" style="color:red;display:none;">结束时间必须大于开始时间</p>  
				</div>
				<br>
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