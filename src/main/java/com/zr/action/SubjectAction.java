package com.zr.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.model.Subject;
import com.zr.service.StaffService;
import com.zr.service.impl.StaffServiceImpl;
@WebServlet("/SubjectAction")
public class SubjectAction extends HttpServlet{
	StaffService ss=new StaffServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int flag=Integer.parseInt(req.getParameter("flag"));
		
		if(flag==1){
			int sub_id = Integer.parseInt(req.getParameter("p1"));
			ss.agreeSubject(sub_id);
		}
		if(flag==2){
			int sub_id = Integer.parseInt(req.getParameter("p1"));
			ss.returnSubject(sub_id);
		}
		if(flag==3){
			int sub_id = Integer.parseInt(req.getParameter("p1"));
			ss.deleteSubject(sub_id);
		}
		resp.setCharacterEncoding("utf8");
	}

}
