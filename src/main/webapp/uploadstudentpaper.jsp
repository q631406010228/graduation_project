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
	$("#file").filebox({
		buttonIcon:'icon-filter',
		buttonAlign:'left',
		buttonText:'请选择文件',
		width:'200px',
		height:'30px',
			
	})
	$("#stus").combobox({
		url:'SelectStudentByEid',    
	    valueField:'id',    
	    textField:'text',   
		iconCls :'icon-man',
		iconAlign:'left',
		prompt:'请选择学生',
		width:'200px',
		height:'30px',
			
	})
	$('#ff').form({
			
			success : function(data) {
				var data = eval('(' + data + ')');
				if (data.s) {
					$.messager.confirm('提示', data.msg, function(r) {
						if (r) {
							 
							$('#ff').form('clear');
                          
							//location.href = 'localhost:8080/graduation_project/uploadstudentpaper.jsp';
						}
					});
				} 
			}
		});
	
	$("#bfn").linkbutton({
		iconCls :'icon-ok',
		height:'30px',
		onClick : function(){
			$("#ff").form('submit');
		}
	}) 
}) ;
</script>
<body>
<div id = "view" style = "text-align: center;margin-top: 200px" >
<form id ="ff"action="${pageContext.request.contextPath }/fileupload" method= "post" enctype="multipart/form-data">
<input id = "stus"  name= "sname" >
<input class= "easyui-filebox" id = "file"  name= "file1">
<a id= "bfn">提交</a>
</form>
</div>
</body>


</html>