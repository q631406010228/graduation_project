package com.zr.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zr.service.SubService;
import com.zr.service.impl.SubServiceImpl;

@WebServlet("/AddStudentSubid")
public class AddStudentSubidAction extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码
	req.setCharacterEncoding("utf-8");
	resp.setCharacterEncoding("utf-8");
	//获取页面上的信息
	Integer sub_id =new Integer(req.getParameter("sub_id"));
	System.out.println("AddStudentSubidAction.sub_id"+sub_id);
	//获取学生id
	HttpSession session = req.getSession();
	Integer s_id = (Integer)session.getAttribute("e_id");
	//调用服务
	SubService sub = new SubServiceImpl();
	//获取值
	Boolean result =sub.addSubToStudent(s_id, sub_id);
	//返回值
	PrintWriter printWriter = resp.getWriter();
	printWriter.write(result.toString());
	
	}
}
