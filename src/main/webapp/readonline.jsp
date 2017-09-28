<%@ page language="java" contentType="text/html; charset=utf-8"
     pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="FlexPaper/js/jquery.js"></script>
<script type="text/javascript" src="FlexPaper/js/flexpaper_flash.js"></script>
<script type="text/javascript" src="FlexPaper/js/flexpaper_flash_debug.js"></script>
</head>
<body>
	<!-- 在线预览 -->
  	<div style="position:absolute;left:10px;top:10px;">
        	<%-- 指定flexPaper的宽度和高度  --%>   
            <a id="viewerPlaceHolder" style="width:800px;height:800px;display:block"></a>  
            <script type="text/javascript"> 
                var fp = new FlexPaperViewer(    
                         'FlexPaper/swfFiles/FlexPaperViewer', 
                         'viewerPlaceHolder',     //对应于a 标签的id
                         { config : {
                         SwfFile : escape('<%=(String)session.getAttribute("fileName")%>'),  //导入的.swf的路径,文件名称使用英语表示，中文时显示不出来，暂时未解决这个问题
                         Scale : 0.6, 
                         ZoomTransition : 'easeOut',
                         ZoomTime : 0.5,
                         ZoomInterval : 0.2,
                         FitPageOnLoad : true,
                         FitWidthOnLoad : false,
                         PrintEnabled : true,   //是否可以打印  
                         FullScreenAsMaxWindow : false,
                         ProgressiveLoading : false,
                         MinZoomSize : 0.2,
                         MaxZoomSize : 5,
                         SearchMatchAll : false,
                         InitViewMode : 'Portrait',
                         
                         ViewModeToolsVisible : true,
                         ZoomToolsVisible : true,
                         NavToolsVisible : true,
                         CursorToolsVisible : true,
                         SearchToolsVisible : true,
                           localeChain: 'en_US'
                         }});
            </script>
        </div>
</body>
</html>