package com.zr.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.mail.handlers.image_gif;
import com.zr.service.SubService;
import com.zr.service.impl.SubServiceImpl;
@WebServlet("/addSubToStudent")
public class addSubToStudentAction extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		//获取页面的值[选中的课题id]
		Integer sub_id =new Integer(req.getParameter("sub_id"));
		//获取用户的id
		HttpSession session = req.getSession();
		Integer e_id=(Integer)session.getAttribute("e_id");
		//调用服务[添加学生表的选题id，将选题表的已选人数+1]
		SubService sub = new SubServiceImpl();
		//Boolean result=sub.addSubToStudent(e_id,sub_id);
		Boolean result=sub.addSubToStudent(1,sub_id);
		System.out.println("addSubToStudentAction.doPost.sub_id="+sub_id);
		System.out.println("addSubToStudentAction.doPost的选题结果result="+result);
		PrintWriter printWriter = resp.getWriter();
		printWriter.write(result.toString());
		//将数据返回
	}
}
