<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="themes/metro/easyui.css" rel="stylesheet" />
<link href="themes/icon.css" rel="stylesheet" />
<script type="text/javascript" src="jquery1.7.2/jquery-1.7.2.js"></script>
<script type="text/javascript" src="jquery1.7.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jquery1.7.2/easyui-lang-zh_CN.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
        $(function(){
        	
        	$('#dg').datagrid({    
        		url:'showDean', 
     		    pagination:true,	//增加分页工具栏
     		    pageSize:10,
     		    pageList:[10,20,30],	//设定每页的数据条数
     		    rownumbers:true,	//序列号
     		    title:'学生信息列表',	//标题
     		    fitColumns:true,
     		    columns:[[	//field与json数据相对应
 		            {field:'ck',title:'ck',checkbox:true,width:100},    
			        {field:'emnum',title:'工号',width:100}, 
			        {field:'ename',title:'姓名',width:100},
			        {field:'ecol',title:'学院',width:100,hidden:true},
			        {field:'cname',title:'学院',width:100},
			        {field:'epsw',title:'密码',width:100},    
			        {field:'eid',title:'eid',width:100,hidden:true},  
     		    ]],
     		   	toolbar: [{	//添加学生信息
     				iconCls: 'icon-add',
     				text:'添加',
     				handler: function(){
     					$('#win').window('open');
     					$('#btn').off('click').on('click', function(){    
     				    	$('#ff').form('submit', {    
     				    	    url:'updateDean ',    
     				    	    onSubmit: function(param){    
     				    	    	param.flag = '1';      
     				    	    },    
     				    	    success:function(data){    
     				    	    	$.messager.alert('警告','添加成功','info',function(){
     						    		$('#ff').form('clear');
     						    		$('#win').window('close');
         				    	    	$('#dg').datagrid('reload');
     						    	}); 
     				    	    }    
     				    	});
     				    });
     				}
     			},'-',{	//删除学生信息
     				iconCls: 'icon-remove',
     				text:'删除',
     				handler: function(){
     					var rows = $('#dg').datagrid('getSelections');
     					if(rows.length == 0){
     						return false;
     					}
     					var sids = [];
     					for(var i = 0;i < rows.length;i++){
     						sids.push(rows[i].eid);
     					}
     					$.ajax({
     						url:'updateDean',
     						type:'post',
     						data:{'sids':sids.join(","),'flag':2},
     						dataType:'html',
     						success:function(data){
     							$.messager.alert('警告','删除成功','info',function(){
     				    	    	$('#dg').datagrid('reload');
 						    	}); 
     						} 
     					}) 
     				}
     			},'-',{	//修改学生信息
     				iconCls: 'icon-edit',
     				text:'修改',
     				handler: function(){
     					var rows  = $('#dg').datagrid('getSelections');
     					if(rows.length == 0 || rows.length > 1){
     						return false;
     					}
     					$('#ff').form('load', $('#dg').datagrid('getSelected'));
     					$('#ecol').combobox('select',rows[0].ecol);
     					$('#win').window('open');
     					$('#btn').off('click').on('click', function(){    
     				    	$('#ff').form('submit', {    
     				    	    url:'updateDean ',    
     				    	    onSubmit: function(param){ 
     				    	    	param.flag = '3';
     				    	    	param.eid = $('#dg').datagrid('getSelected').eid;
     				    	    },    
     				    	    success:function(data){  
     				    	    	$.messager.alert('警告','修改成功','info',function(){
     						    		$('#ff').form('clear');
     						    		$('#win').window('close');
         				    	    	$('#dg').datagrid('reload');
     						    	});   				    	    	
     				    	    }    
     				    	});
     				    });
     				}
     			}]

        	});       	
        	
        	$('#win').window({    
        	    width:600,    
        	    height:400,    
        	    modal:true, 
        	    title:'登陆窗口',
        	}); 
        	
        	$('#win').window('close');
        	
        	$('#sid').textbox({    
        		 height:30, 
        	})
        	
        	$('#snum').textbox({       
        		height:30, 
			})
			
			$('#sname').textbox({       
				height:30, 
			})
			
			$('#epsw').textbox({       
				height:30, 
			})
			
        	//学院
			$('#scol').combobox({    
			    url:'getCollege',    
			    valueField:'id',    
			    textField:'text',			   
			});
			
			//提交按钮
			$('#btn').linkbutton({    
			    iconCls: 'icon-ok',
			});       	

        	//系主任信息修改提交   
       	    $('#btn').bind('click', function(){    
       	    	$('#ff').form('submit', {    
		    	    url:'updateDean ',    
		    	    onSubmit: function(param){ 
		    	    	
		    	    },    
		    	    success:function(data){  
		    	    	$.messager.alert('警告','修改成功','info',function(){
				    	});   				    	    	
		    	    }    
		    	});   
       	    });    
        })
    </script>
</head>
<body>
	<table id="dg"></table>
	<div id="win">
		<form id="ff" method="post">
			<div>
				<div style = "margin:5% 0 0 20%;">					
					<span>工号</span>&nbsp;&nbsp;<input id="snum" name="emnum" type="text" style="width:300px;margin:0 0 50px 0;">
					<br>
					<br>
					<span>姓名</span>&nbsp;&nbsp;<input id="sname" name="ename" type="text" style="width:300px;margin:0 0 50px 0;">
					<br>
					<br>
					<span>学院</span>&nbsp;&nbsp;<input id="scol" name="ecol" style="width:300px;margin:0 0 50px 0;">
					<br>
					<br>
					<span>密码</span>&nbsp;&nbsp;<input id="epsw" name="epsw" style="width:300px;margin:0 0 50px 0;">
				</div>
				<br>		
				<a id="btn" href="#" style="margin-left:45%;">提交</a>
			</div>
		</form>
	</div>  
</body>
</html>