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
	border: 4px dashed #ccc;
}

div.box>span {
	color: #999;
	font-style: italic;
}

li {
	margin: 5px 0;
}

ul.test li {
	color: gray;
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
	<script type="text/javascript">
		$(function(){
			
			$.ajax({
				url:'showGP',
				type:'post',
				data:{},
				dataType:'json',
				success:function(data){	 	    	     							  	     						    	     						
					for(var i = 0;i < data.gps.length;i++){
						$(".test").append("<li><span>"+data.gps[i].gpcontent+"</span>&nbsp;&nbsp;&nbsp;&nbsp;<span>"
								+data.gps[i].gpstartime+"</span>&nbsp;&nbsp;&nbsp;&nbsp;<span>"+data.gps[i].gpendtime+"</span></li><br>");
					}
					console.log($("li").last());
					$("li").last().css("color","red");
		   		}
		   	})
		});
	</script>
	<div class="box">
		<div class="content">
			<ul class="test">
				
			</ul>
		</div>
	</div>
</body>
</html>