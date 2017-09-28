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
<title>教师信息</title>
</head>
<script type="text/javascript">
$(document).ready(function(){
	   
	
	$("#tb").datagrid({    
	    url:'selectTeacher',
	    title:'教师信息',
	    striped:true,
	    fitColumns:false,
	    pageSize:5,
	    pageList:[5,10,15],
	    pagination:true,
	    rownumbers:true,
	    columns:[[    
	        {field:'ck',title:'ck',checkbox:true,width:100},    
	        {field:'eid',title:'教师id',width:100,hidden:true}, 
	        {field:'emnum',title:'教师号',width:100,},    
	        {field:'ename',title:'教师姓名',width:100},
	        {field:'epsw',title:'用户密码',width:100},  
	        {field:'ecolname',title:'学院',width:100,}    
	    ]],
		toolbar: [{
			iconCls: 'icon-edit',
			text:'修改',
			handler: function(){
				var rows = $("#tb").datagrid('getSelected');
				$('#upwin').window('open');
				$('#ff').form('load',rows);
				
			}
		},'-',{
			iconCls: 'icon-add',
			text:'添加',
			handler: function(){
				$('#addwin').window('open');
			}
		},'-',{
			iconCls: 'icon-remove',
			text:'删除',
			handler: function(){
				var rows = $("#tb").datagrid('getSelections');
				var eids = new Array();
				for (var i = 0; i < rows.length; i++) {
					console.log(rows[i].eid);
					eids.push(rows[i].eid);
				}
				$.messager.confirm('提醒', '确认删除这几条记录吗？', function(r){
					if (r){
						$.ajax({
							url:'deleteTeacher',
							data:"eid=" + eids,
							datatype:'json',
							type:'post',
							success:function(data){
								var datas = eval('('+data+')');
								console.log(datas.exce);
								$.messager.alert('提示',datas.exce,'info',function(){
									$('#tb').datagrid('reload');
			        			});
							}
						})
					}
				});
			}
		}]

	});
	//配置修改信息窗口
	$("#upwin").window({
		width : 600,
		height : 400,
		title : '修改信息',
		closable :true,
		collapsible : true
	})
	//配置添加信息窗口
	$("#addwin").window({
		width : 600,
		height : 400,
		title : '添加信息',
		closable :true,
		collapsible : true
	})
	$('#upwin').window('close'); 
	$('#addwin').window('close'); 
	$('#cid').combobox({    
	    url:'getCollege',    
	    valueField:'id',  
	    prompt:"请选择学院",
	    textField:'text',
	    height:30,
	});
	$('#cid1').combobox({    
	    url:'getCollege',    
	    valueField:'id',  
	    prompt:"请选择学院",
	    textField:'text',
	    height:30,
	});
	$('#eid').textbox({
		readonly:true,
		height : 30
	})
	$('#emnum').textbox({
		height : 30
	})
	$('#ename').textbox({
		height : 30
	})
	$('#ename1').textbox({
		prompt:"请输入教师姓名",
		height : 30
	})
	$('#emnum1').textbox({
		prompt:"请输入教师号",
		height : 30
	})
	$('#epsw1').textbox({
		readonly:true,
		value:'123',
		height : 30
	})
	//配置修改提交按钮
	$('#btn').linkbutton({
		iconCls : 'icon-ok',
		onClick:function(){
		    $('#ff').form('submit'); 
		}
	});
	//配置添加提交按钮
	$('#btn1').linkbutton({
		iconCls : 'icon-ok',
		onClick:function(){
		    $('#ff1').form('submit'); 
		}
	});
	//配置修改表单
	$('#ff').form({    
	    url:'updateTeacher',    
	    onSubmit: function(){    
	        // do some check    
	        // return false to prevent submit; 
	         var emnum = $("#emnum").val();
	    	 var ename = $("#ename").val();
		     console.log(name);
		     if(""==emnum||""==ename){
		    	 //cosole.log(name);
		        $.messager.alert('提示',"修改失败",'info',function(){
		        });
		        return false;
		     }
	    },    
	    success:function(data){
	    	var datas = eval('('+data+')');
	    	//console.log(datas);
	    	if(datas.exception == "1"){
	    		$.messager.alert('提示',"修改成功",'info',function(){
	    			$('#ff').form('clear');
		    		$('#upwin').window('close');
		    		$('#tb').datagrid('reload');
	        	});
	    		
	    	}else{
	    		$.messager.alert('提示',"修改失败",'info',function(){
	    			$('#ff').form('clear');
		    		$('#upwin').window('close');
	        	});
	    	}	
	    }    
	});
	//配置添加信息表单
	$('#ff1').form({    
	    url:'addTeacher',    
	    onSubmit: function(){    
	        // do some check    
	        // return false to prevent submit;
	        var emnum = $("#emnum1").val();
	        var ename = $("#ename1").val();
	        console.log(name);
	        if(""==emnum||""==ename){
	        	$.messager.alert('提示',"添加失败",'info',function(){
	        	});
	        	return false;
	        }
	    },    
	    success:function(data){
	    	var datas = eval('('+data+')');
	    	//console.log(datas);
	    	if(datas.exception == "1"){
	    		$.messager.alert('提示',"添加失败！",'info',function(){
	    			$('#ff1').form('clear');
		    		$('#addwin').window('close');
		    		$('#tb').datagrid('reload');
	        	});
	    		
	    	}else{
	    		$.messager.alert('提示',"添加失败！",'info',function(){
	    			$('#ff1').form('clear');
		    		$('#addwin').window('close');
	        	});
	    	}	
	    }    
	});
})

</script>
<body>
	<table id = "tb"></table>
	<div id="upwin">
		<form id="ff" method="post">
			<div style="margin-left: 150px;margin-top: 100px; ">
				<div>
					<label for="name">教师编号:</label> <input id="eid" name="eid"
						type="text" style="width: 200px">
				</div>
				<br>
				<div>
					<label for="name">教师号:</label> <input id="emnum" name="emnum"
						type="text" style="width: 200px">
				</div>
				<br>
				<div>
					<label for="password">教师姓名:</label> <input id="ename"
						name="ename" type="text" style="width: 200px">
				</div>
				<br> 
				<div>
					<label for="name">学院:</label> <input id="cid" name="cid"
						type="text" style="width: 200px">
				</div>
				<br>
				<div style="margin-left: 120px;">
					<a id="btn" href="#">提交</a>
				</div>
			</div>
		</form>
	</div>
	<div id="addwin">
		<form id="ff1" method="post">
			<div style="margin-left: 150px;margin-top: 100px; ">
				<div>
					<label for="name">教师号:</label> <input id="emnum1" name="emnum"
						type="text" style="width: 200px">
				</div>
				<br>
				<div>
					<label for="password">教师姓名:</label> <input id="ename1"
						name="ename" type="text" style="width: 200px">
				</div>
				<br><div>
					<label for="password">密码:</label> <input id="epsw1"
						name="epsw" type="text" style="width: 200px">
				</div>
				<br> 
				<div>
					<label for="name">学院:</label> <input id="cid1" name="cid"
						type="text" style="width: 200px">
				</div>
				<br>
				<div style="margin-left: 120px;">
					<a id="btn1" href="#">提交</a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>