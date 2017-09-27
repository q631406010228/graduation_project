<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/1.0.2/Chart.min.js"></script>
<body>
	<canvas id="myChart" width="600" height="600"></canvas>
	<script type="text/javascript">
		
		var data = {
				labels : ["60分以下","60-69分","70-79分","80-89分","90-100分"],
				datasets : [
					{
						fillColor : "rgba(151,187,205,0.5)",
						strokeColor : "rgba(151,187,205,1)",
						data : [28,48,40,19,96]
					}
				]
			}
			var ctx = document.getElementById("myChart").getContext("2d");
			var barChart = new Chart(ctx).Bar(data, {
				scaleSteps : null,
				scaleShowLabels: true,
		        //是否绘制柱状条的边框
		        barShowStroke: true,
		        //柱状条边框的宽度
		        barStrokeWidth: 2,
		        //柱状条组之间的间距(过大或过小会出现重叠偏移错位的效果，请控制合理数值)
		        barValueSpacing: 5,
		        //每组柱状条组中柱状条之间的间距
		        barDatasetSpacing: 5,
	    });
	</script>
</body>
</html>