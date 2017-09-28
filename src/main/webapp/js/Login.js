/**
 * 
 */
$(document).ready(function() {
	$("#for").bind("mousedown", function(event) {
		var offset_x = $(this)[0].offsetLeft;
		var offset_y = $(this)[0].offsetTop;
		var mouse_x = event.pageX;
		var mouse_y = event.pageY;
		$(document).bind("mousemove", function(ev) {
			var _x = ev.pageX - mouse_x;
			var _y = ev.pageY - mouse_y;
			var now_x = (offset_x + _x) + "px";
			var now_y = (offset_y + _y) + "px";
			$("#for").css({
				top : now_y,
				left : now_x
			});
		});
	});
	$(document).bind("mouseup", function() {
		$(this).unbind("mousemove");
	});
	$("#cz").click(function() {
		var mu = $("#mu");
		var form = $("#for");
		mu.css("display", "none");
		form.css("display", "none");
	});

	//验证码
	function randomNum(min, max) {
		return Math.floor(Math.random() * (max - min) + min);//对随机数取整
	}
	function randomColor(min, max) {
		var r = randomNum(min, max);
		var g = randomNum(min, max);
		var b = randomNum(min, max);
		return "rgb(" + r + "," + g + "," + b + ")";
	}

	var canvas = document.getElementById("num");
	var ctx = canvas.getContext("2d");
	//画背景
	ctx.fillStyle = randomColor(170, 230);
	ctx.fillRect(0, 0, 120, 40);
	//画文字
	var str = "abcdefghijklmnopqrstuvwxyz123456789";
	var t = "";
	for (var i = 0; i < 4; i++) {
		var txt = str[randomNum(0, str.length)];
		ctx.fillStyle = randomColor(50, 160);
		ctx.font = randomNum(15, 25) + "px Arial";
		var x = 10 + i * 22;
		var y = 30;
		var rotate = randomNum(-5, 5);
		ctx.rotate(rotate * Math.PI / 180);
		ctx.translate(x, y);
		ctx.fillText(txt, 0, 0);
		ctx.rotate(-rotate * Math.PI / 180);
		ctx.translate(-x, -y);
		t += txt;//获取验证框中文本值
	}
	//画干扰线
	for (var i = 0; i < 5; i++) {
		ctx.strokeStyle = randomColor(0, 255);
		var x1 = randomNum(0, 120);
		var y1 = randomNum(0, 40);
		var x2 = randomNum(0, 120);
		var y2 = randomNum(0, 40);
		ctx.moveTo(x1, y1);
		ctx.lineTo(x2, y2);
		ctx.stroke();
	}
	//点击验证码图片
	$("#num").click(function() {
		location.href = "login.jsp";
	});
	//防止重复提交
	var checksubmitflg = false;
	var flag = false;
	function checksubmit() {
		if (checksubmitflg == true) {
			return false;
		}
		checksubmitflg = true;
		return true;
	};

	$('#form').form({
		onSubmit:function(){
			if ($("#ename").val()==""||$("epsw").val()==""){
				$.messager.alert("提示", "用户名或密码不能为空", 'info', function(){					
				});
				return false;
			}
		},
		 url:'login',
		 success:function(data){ 
		    	//alert("验证成功");
		    	console.log(data);
		    	var obj=eval( '(' +data + ')' );
		    	if(obj.ok==true){
		    		$.messager.show({
		    			title:'消息',
		    			msg:obj.msg,
		    			timeout:3000,
		    			showType:'slide',
		    				style:{
		    					right:'',
		    					top:document.body.scrollTop+document.documentElement.scrollTop,
		    					bottom:''
		    				}
		    		});
		    		location.href='main.jsp';
		    	}else{
		    		$.messager.confirm('确认对话框', obj.msg, function(r){
		    			if (r){
		    			   
		    			}
		    		});

		    	}

}    
	});
	
	//配置提交按钮
	$('#dl').linkbutton({    
	    onClick:function(){
	    	//alert("验证码的验证！");
	    	var yzmvalue = $("#yzm").val();
			if (yzmvalue != t) {
				$.messager.confirm('提示', "验证码错误", function(r){
	    			if (r){
	    			   
	    			}
	    		});
			} else {
				$('#form').form('submit'); 
			}
	    }
	}); 
	$('#cc').combobox({    
	    url:'showRoleName',    
	    valueField:'id',    
	    textField:'text'   
	});  

	//验证码验证
	$("#dl").click(function() {
		var yzmvalue = $("#yzm").val();
		if (yzmvalue != t) {
			$.messager.confirm('提示', "验证码错误", function(r){
    			if (r){
    			   
    			}
    		});
		}
	});
     //重置按钮
	$("#cz").linkbutton(function() {
		location.href = "login.jsp";
	});
})