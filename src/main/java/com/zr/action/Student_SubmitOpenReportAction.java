
package com.zr.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zr.dao.StudentDao;
import com.zr.dao.impl.StudentDaoImpl;
import com.zr.service.LiteratureService;
import com.zr.service.upFileService;
import com.zr.service.impl.LiteratureServiceImpl;
import com.zr.service.impl.upFileServiceImpl;
import com.zr.util.Office2Swf;

import net.sf.json.JSONObject;
/**
 * 实现文件上传并预览的Action
 * @author Administrator
 *
 */

public class Student_SubmitOpenReportAction extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取id
		HttpSession session = req.getSession();
		Integer s_id= (Integer)session.getAttribute("e_id");
		StudentDao dao = new StudentDaoImpl();
		String s_num= dao.getStudentnumBys_id(s_id);
		//获取文件属性
		/*Integer l_id =new Integer(req.getParameter("dept")) ;*/
		Integer l_id =1;
		//System.out.println("l_id:"+l_id);
		//为每个用户创建3个文件夹，方便用来存储他们的头像和微博内容
		String savepath = this.getServletContext().getRealPath("/upload/" +s_num+ "/teacher/"+l_id);
		File file = new File(savepath);
		
		
		try {
			file.mkdirs();
		//	file1.mkdirs();
			//file2.mkdirs();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("文件创建失败！");
			
		}
		//获取需要上传的路径：
		String upFilePath="/upload/" +s_num+ "/teacher/"+l_id;
		//创建上传文件的服务对象
		upFileService upFileService = new upFileServiceImpl();
		//调用上传服务的方法
		String inputFilePath = upFileService.uploadFile(req,upFilePath);
		//如果文件路径不为空，
		JSONObject jsonObject = new JSONObject();
		PrintWriter printWriter = resp.getWriter();
		
		if (null != inputFilePath && !"".equals(inputFilePath.trim()))
		{ //文件上传成功
			
			
			//调用文献存储服务（将文献信息存放在数据库中）
			String wx_name = new File(inputFilePath).getName();
			LiteratureService literature =new LiteratureServiceImpl();
		Boolean result=literature.setLiteratureInfo(s_id,l_id, inputFilePath, wx_name);
		if(result){
			//数据库录入成功
			jsonObject.put("bool", true);
			String outFilePath = inputFilePath.replace(new File(inputFilePath).getName(), System.currentTimeMillis() + ".swf");
			outFilePath = Office2Swf.office2Swf(inputFilePath, outFilePath);
		if(outFilePath.equals(null))
			{
				jsonObject.put("read", false);
				
			}
			else{
				req.getSession().setAttribute("fileName", "upload/"+s_num+"/teacher/"+l_id+"/"+new File(outFilePath).getName());
				jsonObject.put("read", true);
			}
		}	
		}else{
			
			jsonObject.put("bool", false);
		}
		printWriter.write(jsonObject.toString());
		//req.getRequestDispatcher("/readonline.jsp").forward(req, resp);
	}
	
	
	/*@SuppressWarnings({"unchecked", "deprecation"})
	private String uploadFile(HttpServletRequest request) 
	{
	
		//获得磁盘文件条目工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//获取文件需要上传到的路径
		String path = request.getRealPath("/upload");
		factory.setRepository(new File(path));
		//设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
		factory.setSizeThreshold(1024*1024) ;
		//高水平的API文件上传处理
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		String uploadFilePath = null;
		//可以上传多个文件
		try {
			List<FileItem> list = (List<FileItem>)upload.parseRequest(request);
			for(FileItem item : list)
			{
				//获取表单的属性名字
				String name = item.getFieldName();
				
				// 表单文本信息
				if(item.isFormField())
				{					
					String value = item.getString() ;
					request.setAttribute(name, value);
				}
				// 表单上传的文件
				else
				{
					// 获取路径
					String value = item.getName() ;
					int start = value.lastIndexOf("\\");
					// 截取 上传文件名称
					String filename = value.substring(start+1);
					request.setAttribute(name, filename);
					item.write(new File(path,filename));
					uploadFilePath = path + File.separator + filename;
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return uploadFilePath;
	}*/
}

