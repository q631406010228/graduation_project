/**
 * 
 */
$(document).ready(function(){

	$('#dg').datagrid({    
	    url:'Student_Selectliterature', 
	  
	    title:'学生信息列表(审核状态：0，未审核，1审核通过，2审核未通过)',
	    columns:[[
	        {field:'ck',title:'ck',checkbox:true,width:100},    
	        {field:'wx_id',title:'文献的id',width:100,hidden:true},    
	        {field:'wx_content',title:'文献的路径',width:100,hidden:true},      
	        {field:'wxlx_name',title:'文献类型',width:100}, 
	        {field:'wx_name',title:'文件名',width:100}, 
	        {field:'wx_state',title:'审核状态',width:100}, 
	        {field:'wxlx_id',title:'文献类型id',width:100,hidden:true},      
	        ]],
		    toolbar: [{
		    	
					iconCls: 'icon-edit',
					text:'下载',
					handler: function(){
						var row  = $('#dg').datagrid('getSelected');
						
						$('#upwin').window('open');
						alert("输出被选中行的信息"+row);
						$('#ff').form('load',row);
						$('#btn').one("click",function(){
							$('#ff').form('submit', {    
							    url:"downfile",    
							   dataType: "json",
							    success: function(data){
							    	alert(data);
							    	//var obj = eval("("+data+")");
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
	    	
	    		$.messager.alert('警告',data,'info',function(){
		    		$('#ff').form('clear');
		    		$('#upwin').window('close');
		    		$('#dg').datagrid('reload');
		    	}); 
	    	
		}
});