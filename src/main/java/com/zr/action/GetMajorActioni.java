package com.zr.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.CollegeMajorService;
import com.zr.service.impl.CollegeMajorServiceImpl;

import net.sf.json.JSONArray;

@WebServlet("/getMajor")
public class GetMajorActioni  extends HttpServlet {

	CollegeMajorService cms = new CollegeMajorServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cID = Integer.parseInt(req.getParameter("id"));		
		JSONArray major = cms.getMajors(cID);
		resp.setCharacterEncoding("UTF-8");
		PrintWriter pw = resp.getWriter();
		pw.write(major.toString());
	}
}
