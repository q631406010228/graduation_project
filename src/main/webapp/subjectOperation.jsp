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
	$("#agree").linkbutton({    
	    iconCls:'icon-add',
	    onClick:function(){
	    	$('#ff').form('options').queryParams = {
	    		flag:1
			};
	    	
	    	
	    	
	    }
	}); 
	$("#return").linkbutton({    
	    iconCls:'icon-cut',
	    onClick:function(){
	    	$('#ff').form('options').queryParams = {
	    		flag:2
			};
	    	
	    	
	    	
	    	
	    }
	}); 
	$("#delete").linkbutton({    
	    iconCls:'icon-remove',
	    onClick:function(){
	    	$('#ff').form('options').queryParams = {
				flag:3
			};
	    
	    	
	
	    	
	    }
	}); 
$('#dg').datagrid({    
	    url:'subjectTable', 
	    pagination:true,
	    pageSize:3,
	    pageList:[3,6,9],
	    rownumbers:true,
	    title:'老师选题列表',
	    columns:[[
			{field:'',title:'',width:100,checkbox:true},
	        {field:'sub_id',title:'选题ID',width:100},    
	        {field:'sub_name',title:'选题标题',width:100},
	        {field:'sub_count',title:'选题已提交次数',width:100},
	        {field:'sub_content',title:'选题内容',width:100},
	        {field:'sub_statecn',title:'选题状态',width:100},
	        {field:'e_id',title:'老师ID',width:100},
	        {field:'sub_state',title:'选题状态代码',width:100,hidden:true}
	        
	        
	        
	    ]]
	    
	});
$('#ff').form({
	url : 'SubjectAction',
	 onSubmit: function(param){    
    	 
	    	
	    	var selectedrows = $('#dg').datagrid('getChecked');
	    	
			
	    	var ar1 = new Array();
	    	var ar2 = new Array();
	    	
	    	$.each( selectedrows , function(i, n){
	    		 ar1[i] = n.sub_id;
	    	});
	    	$.each( selectedrows , function(i, n){
	    		 ar2[i] = n.sub_state;
	    	});
	    	
	    	param.p1=ar1
	    	param.p2=ar2
	    }, 
	success : function(data) {
		
		$('#dg').datagrid('reload');
		
	}
});
$('#ff').submit();  
});
</script>
<body>

	<form id="ff" method="post">   
	<table id="dg"></table>
	<div style="margin-top:50px;margin-left:30%">
	<button style="margin-right:20px" id="agree">同意</button>
	<button style="margin-right:20px" id="return">驳回</button>
	<button style="margin-right:20px" id="delete">删除</button>
	</div>
	
	</form>

</body>
</html>