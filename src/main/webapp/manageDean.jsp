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
<script type="text/javascript" src="jquery1.7.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jquery1.7.2/easyui-lang-zh_CN.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
        $(function(){
        	
        	$.ajax({   			
   			  url:'showDean',
   			  type:'post',
   			  dataType:'json',
   			  success:function(data){
   				  console.log(data.rows[0]);
   				  $("#snum").textbox('setValue',data.rows[0].emnum);
   				  $("#sname").textbox('setValue',data.rows[0].ename);
   				  $("#scol").combobox('select',data.rows[0].ecol);
   				  $("#epsw").textbox('setValue',data.rows[0].epsw);
   			  }  
   		  });
        	
        	$('#win').window({    
        	    width:600,    
        	    height:400,    
        	    modal:true, 
        	    title:'登陆窗口',
        	}); 
        	
        	$('#sid').textbox({    
        		 height:30, 
        	})
        	
        	$('#snum').textbox({       
        		height:30, 
			})
			
			$('#sname').textbox({       
				height:30, 
			})
			
			$('#epsw').textbox({       
				height:30, 
			})
			
        	//学院
			$('#scol').combobox({    
			    url:'getCollege',    
			    valueField:'id',    
			    textField:'text',			   
			});
			
			//提交按钮
			$('#btn').linkbutton({    
			    iconCls: 'icon-ok',
			});       	

        	//系主任信息修改提交   
       	    $('#btn').bind('click', function(){    
       	    	$('#ff').form('submit', {    
		    	    url:'updateDean ',    
		    	    onSubmit: function(param){ 
		    	    	
		    	    },    
		    	    success:function(data){  
		    	    	$.messager.alert('警告','修改成功','info',function(){
				    	});   				    	    	
		    	    }    
		    	});   
       	    });    
        })
    </script>
</head>
<body>
	<div id="win">
		<form id="ff" method="post">
			<div>
				<div style = "margin:5% 0 0 20%;">					
					<span>工号</span>&nbsp;&nbsp;<input id="snum" name="num" type="text" style="width:300px;margin:0 0 50px 0;">
					<br>
					<br>
					<span>姓名</span>&nbsp;&nbsp;<input id="sname" name="sname" type="text" style="width:300px;margin:0 0 50px 0;">
					<br>
					<br>
					<span>学院</span>&nbsp;&nbsp;<input id="scol" name="cname" style="width:300px;margin:0 0 50px 0;">
					<br>
					<br>
					<span>密码</span>&nbsp;&nbsp;<input id="epsw" name="epsw" style="width:300px;margin:0 0 50px 0;">
				</div>
				<br>		
				<a id="btn" href="#" style="margin-left:45%;">提交</a>
			</div>
		</form>
	</div>  
</body>
</html>