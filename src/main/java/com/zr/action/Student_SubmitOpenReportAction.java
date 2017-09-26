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
		String inputFilePath = this.uploadFile(req);
		if (null != inputFilePath && !"".equals(inputFilePath.trim()))
		{
			String outFilePath = inputFilePath.replace(new File(inputFilePath).getName(), System.currentTimeMillis() + ".swf");
			outFilePath = Office2Swf.office2Swf(inputFilePath, outFilePath);
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
