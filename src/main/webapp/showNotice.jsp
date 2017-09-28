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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
div.box {
	width: 500px;
	padding: 20px;
	margin: 20px;
}

div.box>span {
	color: #999;
	font-style: italic;
}

li {
	margin: 5px 0;
}

ul.test li {
	color: yellow;
	font-size: 30px;
}

ul.test li span {
	display: inline-block;
	color: black;
	font-size: 16px;
}
</style>
</head>
<body>   
    <div id="messages"></div>  
    <div class="box">
		<div class="content">
			<ul id="test">
				
			</ul>
		</div>
	</div>
    <script type="text/javascript">  
    	var webSocket = new WebSocket("ws://localhost:8080/graduation_project/websocket");  
    	
        webSocket.onerror = function(event) {  
            alert(event.data);  
        };  
        //与WebSocket建立连接  
        webSocket.onopen = function(event) {  
            webSocket.send('我是秦皓');  
        };  
        //处理服务器返回的信息  
        webSocket.onmessage = function(event) {  
        	$("li").remove(); 
        	$("br").remove(); 
        	for(var i = 0;i < $.parseJSON(event.data).Notice.length;i++){
        		document.getElementById('test').innerHTML +="<li style='color:red'><span style='color:black'>"+$.parseJSON(event.data).Notice[i].title
        		+"</span>&nbsp;&nbsp;&nbsp;&nbsp;<span style='color:black'>"+$.parseJSON(event.data).Notice[i].data
        		+"</span><p style='color:gray'>"+$.parseJSON(event.data).Notice[i].content+"</p></li><br>";      		
			}
        };  

        
    </script>  
</body>  
</html>