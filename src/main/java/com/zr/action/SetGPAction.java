package com.zr.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zr.service.GraduationProcessService;
import com.zr.service.impl.GraduationProcessServiceImpl;


public class SetGPAction extends HttpServlet{
	
	GraduationProcessService gps = new GraduationProcessServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int cID = (int) session.getAttribute("c_id");
		String gpContent = new String(req.getParameter("gpContent").getBytes("iso-8859-1"), "utf-8");	 
	    String graStartTime = req.getParameter("graStartTime");
	    String graEndTime = req.getParameter("graEndTime");
	    gps.setGraduationProcess(gpContent, graStartTime, graEndTime,cID);
	}

}

