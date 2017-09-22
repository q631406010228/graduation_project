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
		
		//配置  添加毕业设计进程  表单，使其用ajax方式请求
		$('#signInForm').form({    
    		url:'login',      
   			success:function(data){ 
        		var data = eval('('+data+')');
        		if(data.sc){
 					
        		}
    		}    
		});	
		
		//毕业设计进程开始时间设置
		$('#graStartTime').datetimebox({    
		    value: '3/4/2017 2:3',    
		    required: true,    
		    showSeconds: false   
		});
			
		//毕业设计进程结束时间设置
		$('#graEndTime').datetimebox({    
		    value: '3/5/2017 2:3',    
		    required: true,    
		    showSeconds: false   
		});
		
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
		<form id="signInForm" method="post">
			<div>
				<div style = "margin:20% 0 0 20%;">					
					毕业设计进程<input id="gpc" name="role" value="aa"> 
					<br>
					开始时间<input id="graStartTime" type="text" name="birthday"></input>  
					结束时间<input id="graEndTime" type="text" name="birthday"></input>  
				</div>	
				<div>
					<a id="submit" href="#" style="margin-left:67%;">登陆</a>
					<a id="register" href="#" style="margin-left:67%;">注册</a>
				</div>
			</div>
		</form>
	</div> 
</body>
</html>