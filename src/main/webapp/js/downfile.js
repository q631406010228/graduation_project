/**
 * 
 */
$(document).ready(function(){

	$('#dg').datagrid({    
	    url:'student_selectsub', 
	  
	    title:'学生信息列表',
	    columns:[[
	        {field:'ck',title:'ck',checkbox:true,width:100},    
	        {field:'wx_id',title:'选题的id',width:100,hidden:true},    
	        {field:'wx_content',title:'选题',width:100},      
	        {field:'wx_state',title:'选题内容',width:100}, 
	        {field:'wxlx_id',title:'负责教师',width:100},      
	        {field:'s_id',title:'限选人数',width:100}, 
	        {field:'wx_name',title:'剩余人数',width:100}, 
	        ]],
		    toolbar: [{
		    	
					iconCls: 'icon-edit',
					text:'确定',
					handler: function(){
						var row  = $('#dg').datagrid('getSelected');
						$('#upwin').window('open');
						alert("输出被选中行的信息"+row);
						/*row.sub_id
						$("#sub_name").val(row.sub_name);
						$("#e_name").val(row.e_name);*/
						
						$('#ff').form('load',row);
						$('#btn').one("click",function(){
							$('#ff').form('submit', {    
							    url:"AddStudentSubid",    
							   dataType: "json",
							    success: function(data){
							    	alert(data);
							    	var obj = eval("("+data+")");
							    	alertInfo(obj);
							    	} 
							    	
							}); 
						});
					}
				}]
	});
	
	//提示窗口
	$('#upwin').window({    
	    width:600,    
	    height:400 
	}); 

	$('#upwin').window('close');
	
	//配置表单输入
		
		$('#sub_id').textbox({    
		    height:40,
		    hidden:true
		})
		$('#sub_name').textbox({    
		    height:40,
		   // hidden:true
		})
		
		$('#e_name').textbox({    
		    height:40
		})
	
		//配置提交按钮
		$('#btn').linkbutton({    
		    iconCls: 'icon-ok',
		    
		}); 
		
		function alertInfo(data){
			console.log(data);
	    	if(!data){
	    		$.messager.alert('警告','失败','info',function(){
		    		$('#ff').form('clear');
		    		$('#upwin').window('close');
		    		$('#dg').datagrid('reload');
		    	}); 
	    	}else{
		    	$.messager.alert('警告','成功','info',function(){
		    		$('#ff').form('clear');
		    		$('#upwin').window('close');
		    		$('#dg').datagrid('reload');
		    	}); 
	    	}
		}
});
	