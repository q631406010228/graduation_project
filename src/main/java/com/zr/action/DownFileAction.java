package com.zr.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.FileService;
import com.zr.service.impl.FileServiceImpl;
@WebServlet("/downfile")
public class DownFileAction extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FileService file = new FileServiceImpl();
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String path = req.getParameter("wx_content");
		String a="C:/Users/Administrator/Downloads/[kaoyan.com]2015年北京邮电大学计算机学科专业基础综合讲义.pdf";
		//注意此处路径未确定
		file.downFile(a,resp);
	}
}
