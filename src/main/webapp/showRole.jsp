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
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
</head>
<script type="text/javascript">
$(function(){
	$('#tt').tree({
	    url:'showRoles', 	
	    onClick:function(node){
	    	if(node.attributes.fpath){
	    		if($('#tabs').tabs('exists',node.text)){
	    			$('#tabs').tabs('select',node.text)
	    		}
	    		else{
	    		$('#tabs').tabs('add',{
	    			title: node.text,
	    			closable: true,
	    			content:"<iframe  width='100%' height='100%' frameborder='0' src='"+node.attributes.fpath+"'></iframe>"
	    		});
	    		}
	    	}

	    },
	    onLoadSuccess:function(node,data){
	    	$("#tt").tree('expandAll');
	    }
	});     
})
</script>
<body class="easyui-layout">   
    <div data-options="region:'north',title:'通知',split:true" style="height:300px;background:#eee;"></div>   
    <div data-options="region:'west'	,title:'职能树',split:true" style="width:400px;background:#eee;">
    <ul id="tt"></ul> </div>   
    <div data-options="region:'center',border:false,title:''" style="padding:5px;background:#eee;">
    <div id="tabs" class="easyui-tabs" data-options="fit:true">   
    	</div></div>   
</body>
</html>