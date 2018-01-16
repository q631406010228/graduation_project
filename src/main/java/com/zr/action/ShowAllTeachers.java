package com.zr.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.TeacherService;
import com.zr.service.impl.TeacherServiceImpl;

import net.sf.json.JSONArray;
@WebServlet("/showAllTeachers")
public class ShowAllTeachers extends HttpServlet{
	TeacherService ts =new TeacherServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    JSONArray  j  =  ts.getAllTeachers();
		 
//	    JSONArray  j  =  rs.getuserRoles(-1, "1,2,3,4,5,6,7,8");
	    req.setCharacterEncoding("utf8");
		resp.setCharacterEncoding("utf8");
		PrintWriter  pw = resp.getWriter();
		pw.write(j.toString());
	
	}
	
	
	
}
