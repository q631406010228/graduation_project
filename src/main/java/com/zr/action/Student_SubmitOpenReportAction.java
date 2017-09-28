package com.zr.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			System.out.println("转换的最终结果Student_SubmitOpenReportAction.doPost.outFilePath"+outFilePath);
			System.out.println("转换的swf的文件名"+new File(outFilePath).getName());
			req.getSession().setAttribute("fileName", new File(outFilePath).getName());
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("true");
		}
		//req.getRequestDispatcher("/readonline.jsp").forward(req, resp);
	}
	
	
	
}
