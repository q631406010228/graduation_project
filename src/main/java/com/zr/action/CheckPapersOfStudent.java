package com.zr.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zr.service.TeacherService;
import com.zr.service.impl.TeacherServiceImpl;

import net.sf.json.JSONObject;

@WebServlet("/check")
public class CheckPapersOfStudent extends HttpServlet{
	TeacherService tea = new TeacherServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JSONObject json = new JSONObject();
		 String state ="";
		 int lwid = Integer.parseInt(req.getParameter("lwid"));
		 String stateid = req.getParameter("state");
		 if(stateid.equals("0")){
			 state = "通过";
		 }else{
			 state = "责改";
		 }
	   Boolean b = tea.checkPapers(lwid, state);
	   json.put("s",b);
	   PrintWriter pw = resp.getWriter();
			   pw.write(json.toString());
	}	

}
