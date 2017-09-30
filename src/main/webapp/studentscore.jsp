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
<script src="js/echarts.js"></script>
<title>学生成绩图表表示</title>
</head>
<script type="text/javascript">
$(document).ready(function(){
	var myChart = echarts.init(document.getElementById('main'));
	//显示标题，图例和空的坐标轴
	myChart.setOption({
		title : {
			text : '学生各阶段人数显示'
		},
		tooltip : {},
		legend : {
			data : [ '人数' ]
		},
		xAxis : {
			data : []
		},
		yAxis : {},
		series : [ {
			name : '人数',
			type : 'bar',
			data : []
		} ]
	});

	//异步加载数据
	$.get('getStudentScore').done(function(data) {
		// 填入数据
		var datas = eval('('+data+')');
		console.log(datas.data)
		myChart.setOption({
			xAxis: {
	            data: datas.categories
	        },
			series : [ {
				// 根据名字对应到相应的系列
				name : '人数',
				data : datas.data
			} ]
		});
	});
	
})
	
</script>
<body>
	<div style="text-align: center;">
		<div id="main" style="width: 600px; height: 400px;margin-left: 350px"></div>
	</div>

</body>
</html>