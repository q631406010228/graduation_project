package com.zr.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.GraduationProcessService;
import com.zr.service.impl.GraduationProcessServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SetGPAction extends HttpServlet{
	
	GraduationProcessService gps = new GraduationProcessServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String gpContent = new String(req.getParameter("gpContent").getBytes("iso-8859-1"), "utf-8");	 
	    String graStartTime = req.getParameter("graStartTime");
	    String graEndTime = req.getParameter("graEndTime");
	    gps.setGraduationProcess(gpContent, graStartTime, graEndTime);
	}

	
}
