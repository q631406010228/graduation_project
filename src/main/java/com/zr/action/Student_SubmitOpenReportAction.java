package com.zr.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.zr.service.upFileService;
import com.zr.service.impl.upFileServiceImpl;
import com.zr.util.Office2Swf;
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
		//为每个用户创建3个文件夹，方便用来存储他们的头像和微博内容
		File file = new File("F:/eclipsejava/eclipse/apache-tomcat-7.0.68/webapps/graduation_project/upload/631406010426");
		//File file1 = new File("E:\\JAVA-my\\personal_diary\\WebRoot\\\\xc");
		//File file2 = new File("E:\\JAVA-my\\personal_diary\\WebRoot\\\\Blog");
		
		try {
			file.mkdirs();
		//	file1.mkdirs();
			//file2.mkdirs();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("文件创建失败！");
			
		}
		//获取需要上传的路径：
		String upFilePath="/upload/631406010426";
		//创建上传文件的服务对象
		upFileService upFileService = new upFileServiceImpl();
		//调用上传服务的方法
		String inputFilePath = upFileService.uploadFile(req,upFilePath);
		//如果文件路径不为空，
		if (null != inputFilePath && !"".equals(inputFilePath.trim()))
		{
			String outFilePath = inputFilePath.replace(new File(inputFilePath).getName(), System.currentTimeMillis() + ".swf");
			outFilePath = Office2Swf.office2Swf(inputFilePath, outFilePath);
			//System.out.println("转换的最终结果Student_SubmitOpenReportAction.doPost.outFilePath"+outFilePath);
			//System.out.println("转换的swf的文件名"+new File(outFilePath).getName());
			req.getSession().setAttribute("fileName", new File(outFilePath).getName());
		}
		req.getRequestDispatcher("/readonline.jsp").forward(req, resp);
	}
	
	
	@SuppressWarnings({"unchecked", "deprecation"})
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
	}
}
