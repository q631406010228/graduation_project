package com.zr.action;

import java.io.File;
import java.io.IOException;

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
		upFileService upFileService = new upFileServiceImpl();
		String inputFilePath = upFileService.uploadFile(req);
		if (null != inputFilePath && !"".equals(inputFilePath.trim()))
		{
			String outFilePath = inputFilePath.replace(new File(inputFilePath).getName(), System.currentTimeMillis() + ".swf");
			outFilePath = Office2Swf.office2Swf(inputFilePath, outFilePath);
			req.getSession().setAttribute("fileName", new File(outFilePath).getName());
		}
		req.getRequestDispatcher("/readonline.jsp").forward(req, resp);
	}
	
	
	
}
