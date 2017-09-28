package com.zr.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.StaffService;
import com.zr.service.impl.StaffServiceImpl;

import net.sf.json.JSONObject;
@WebServlet("/subjectTable")
public class SubjectTableAction extends HttpServlet{
	
	StaffService ss =new StaffServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page = Integer.parseInt(req.getParameter("page"));
		int pageSize = Integer.parseInt(req.getParameter("rows"));
		JSONObject j = ss.getSubjects(page, pageSize);
		resp.setCharacterEncoding("utf8");
		PrintWriter pw = resp.getWriter();
		pw.write(j.toString());
		
	}

}
