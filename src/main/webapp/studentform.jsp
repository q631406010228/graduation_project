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
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<title>学生名单</title>
</head>
<script type="text/javascript">
	$(document).ready(function(){
		$("#tb").datagrid({
			url:'selectStudentForm',
		    title:'学生答辩过程信息',
		    striped:true,
		    fitColumns:true,
		    pageSize:10,
		    pageList:[10,20,30],
		    pagination:true,
		    rownumbers:true,
		    columns:[[    
		        //{field:'ck',title:'ck',checkbox:true,width:100},    
		        {field:'num',title:'学生学号',width:100}, 
		        {field:'sname',title:'学生姓名',width:100},
		        {field:'colname',title:'学院',width:100},
		        {field:'majname',title:'专业',width:100},    
		        {field:'subname',title:'课题名称',width:100},
		    ]],
		})

	function JSONToCSVConvertor(JSONData, ReportTitle, ShowLabel) {
					//If JSONData is not an object then JSON.parse will parse the JSON string in an Object  
					var arrData = typeof JSONData != 'object' ? JSON
							.parse(JSONData) : JSONData;
					var CSV = '';
					//Set Report title in first row or line  
					CSV += ReportTitle + '\r\n\n';
					//This condition will generate the Label/Header  
					if (ShowLabel) {
						var row = "";
						//This loop will extract the label from 1st index of on array  
						for ( var index in arrData[0]) {
							//Now convert each value to string and comma-seprated  
							row += index + ',';
						}
						row = row.slice(0, -1);
						//append Label row with line break  
						CSV += row + '\r\n';
					}
					//1st loop is to extract each row  
					for (var i = 0; i < arrData.length; i++) {
						var row = "";
						//2nd loop will extract each column and convert it in string comma-seprated  
						for ( var index in arrData[i]) {
							row += '"' + arrData[i][index] + '",';
						}
						row.slice(0, row.length - 1);
						//add a line break after each row  
						CSV += row + '\r\n';
					}
					if (CSV == '') {
						alert("Invalid data");
						return;
					}
					//Generate a file name  
					var fileName = "选题学生名单_";
					//this will remove the blank-spaces from the title and replace it with an underscore  
					fileName += ReportTitle.replace(/ /g, "_");
					//Initialize file format you want csv or xls  
					var uri = 'data:text/csv;charset=utf-8,' + encodeURI(CSV);
					// Now the little tricky part.  
					// you can use either>> window.open(uri);  
					// but this will not work in some browsers  
					// or you will not get the correct file extension      
					//this trick will generate a temp <a /> tag  
					var link = document.createElement("a");
					link.href = uri;
					//set the visibility hidden so it will not effect on your web-layout  
					link.style = "visibility:hidden";
					link.download = fileName + ".csv";
					//this part will append the anchor tag and remove it after automatic click  
					document.body.appendChild(link);
					link.click();
					document.body.removeChild(link);
				}
				$("#btnExport").click(
						function() {
							var data = JSON.stringify($('#tb').datagrid(
									'getData').rows);
							if (data == '')
								return;
							JSONToCSVConvertor(data, "Download", true);
						});
			})
</script>
<body>
	<div style="text-align: center;">
		<table id = "tb"></table>
		<a href="#" class="easyui-linkbutton" style="width:10%;margin-top: 10px" id="btnExport">导出excel</a> 
	</div>
</body>
</html>