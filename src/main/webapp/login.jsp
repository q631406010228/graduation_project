<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- 引入主题样式 -->
<link href="themes/gray/easyui.css" rel="stylesheet">
<!-- 引入图标的样式 -->
<link href="themes/icon.css" rel="stylesheet">
<!-- 先引入jquery -->
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<!-- 引入easyui -->
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/Login.js"></script>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>
	<hr></hr>
	<!-- 滚动字幕部分 -->

	<p style="margin-left: 14px;">
		<i><b><marquee scrollAmount=2 width=450>欢迎使用本系统，在登录时注意选择准确的角色哦&nbsp;-----</marquee>
		</b></i>
	</p>

	<!-- 标题部分  -->
	<div class="title" style="margin-top: 80px">
		<strong><h1 align="center" style="font-family: 微软雅黑;">
				<i><b>毕&nbsp;业&nbsp;设&nbsp;计&nbsp;管&nbsp;理&nbsp;系&nbsp;统</b></i>
			</h1></strong>
	</div>

	<!-- 轮播：指标，项目，导航 -->
	<div style="text-align: center;" class="container">
		<div class="row">
			<div class="col-md-6"
				style="position: relative; top: 50px; left: 20px">
				<div id="ad-carousel" class="carousel slide" data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#ad-carousel" data-slide-to="0" class="active"></li>
						<li data-target="#ad-carousel" data-slide-to="1"></li>
						<li data-target="#ad-carousel" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner">
						<div class="item active">
							<img src="image/llll.png" alt="1 slide">
						</div>
						<div class="item">
							<img src="image/lllll4.png" alt="2 slide">
						</div>
						<div class="item">
							<img src="image/lll3.png" alt="3 slide">
						</div>
					</div>
					<a class="left carousel-control" href="#ad-carousel"
						data-slide="prev"><span
						class="glyphicon glyphicon-chevron-left"></span></a> <a
						class="right carousel-control" href="#ad-carousel"
						data-slide="next"><span
						class="glyphicon glyphicon-chevron-right"></span></a>
				</div>
			</div>

			<!-- 用户登录界面 -->
			<div class="col-md-4">
				<div>
					<form class="ff" id="form"
						style="position: relative; top: 100px; left: 100px" action="login">
						<div class="form-inline">
							<label for="exampleInputName">用户名 :</label> <input type="text"
								class="form-control" id="exampleInputName" name="ename" value=""
								placeholder="请输入账户名">
						</div>
						<div class="form-inline" style="position: relative; top: 20px;">
							<label for="exampleInputName">密 码 :</label> <input
								type="password" class="form-control"
								style="position: relative; left: 5px;" id="exampleInputPassword"
								name="epsw" value="" placeholder="请输入密码">
						</div>
						<!-- 验证码 -->
						<div class="form-inline"
							style="position: relative; top: 45px; left: -2px">
							<label for="">验证码:</label> <input type="text"
								class="form-control" style="position: relative; left: 5px;"
								id="yzm" name="yzm" value="" placeholder="请输入验证码">
							<canvas id="num" width="120" height="40"
								style="position: relative; top: 16px; left: 

6px"></canvas>
						</div>

						<!-- 下拉框选择角色 -->
						<div style="position: relative; top: 70px; left: -2px;">
							<!-- 更改后的代码 -->
							<!--  <select id="cc" class="easyui-combobox" name="user_type"
								style="width: 200px;">
								<option value="1">管理员</option>
								<option value="2">学生</option>
								<option value="3">教师</option>
								<option value="4">系主任</option>
							</select>-->
							<label for="">角色选择:&nbsp;&nbsp;</label><input id="cc" name="dept"
								value="">
						</div>
						<br> <br> <br> <br>
						<!--登录和重置  -->
						<button type="button" id="dl" class="btn btn-default"
							style="position: relative; top: 20px; left: 100px">登录</button>
						<button type="button" id="cz" class="btn btn-default"
							style="position: relative; top: 20px; left: -50px">重置</button>
				</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>