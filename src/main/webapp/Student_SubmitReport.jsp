<%@ page language="java" contentType="text/html; charset=utf-8"
     pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文件上传</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/style.css">
<!-- 引入主题样式 -->
<link href="themes/gray/easyui.css" rel="stylesheet">
<!-- 引入图标的样式 -->
<link href="themes/icon.css" rel="stylesheet">
<!-- 先引入jquery -->
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<!-- 引入easyui -->
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<!--<script type="text/javascript" src="FlexPaper/js/jquery.js"></script>
<script type="text/javascript" src="FlexPaper/js/flexpaper_flash.js"></script>
<script type="text/javascript" src="FlexPaper/js/flexpaper_flash_debug.js"></script>  -->


<script type="text/javascript">
$(document).ready(function() {
	$(function(){    
	    $('#read').bind('click', function(){    
	       //在线预览
	    	$('#ff').form('submit', {    
	    	    url:'Student_SubmitOpenReport',
	    	    onSubmit: function(p){    
 				
	    	    },    
	    	    success:function(data){    
	    	    	var obj = eval("("+data+")");
	    	    	console.log(obj.bool);
	    	        if(obj.bool) {
	    	        	if(!obj.read){
	    	        	$.messager.confirm('确认对话框', '上传成功，预览失败', function(r){
			    			if (r){
			    			   
			    			}
	    	        	});
	    	        	}else{
	    	        		
	    	        	location.href='readonline.jsp';
	    	        	}
	    	        }else{
	    	        	$.messager.confirm('确认对话框', '上传失败', function(r){
			    			if (r){
			    			   
			    			}
	    	        	});
	    	        }
	    	    }    
	    	});  

	    });    
	});  
	
	/* $(function(){    
	    $('#upload').bind('click', function(){    
	    	//上传
	        //alert('upload');    
	    });    
	});   */
	
	
	$('#cc').combobox({    
	    url:'getLiteraturelxName',    
	    valueField:'id',    
	    textField:'text'   
	}); 
});
 
</script>
</head>
<body>
<form id='ff' enctype="multipart/form-data" method="post">
  		<input type="file" name="file"/>
  		<label for="">文件类型选择:&nbsp;&nbsp;</label><input id="cc" name="dept" value="">
  		<br>
  		<br>
  		<!-- <a id="upload" href="#" class="easyui-linkbutton" data-options="">上传</a>   --> 		
  		<a id="read" href="#" class="easyui-linkbutton" data-options="">上传预览</a>  
  		
  	</form>
  	
  
</body>
</html>