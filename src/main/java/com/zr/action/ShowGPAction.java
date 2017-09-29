package com.zr.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zr.model.GraduationProcess;
import com.zr.service.GraduationProcessService;
import com.zr.service.impl.GraduationProcessServiceImpl;

import net.sf.json.JSONObject;

public class ShowGPAction extends HttpServlet{
	
	GraduationProcessService GPS = new GraduationProcessServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<GraduationProcess> gps = new LinkedList<GraduationProcess>();
		HttpSession session = req.getSession();
		int cID = (int) session.getAttribute("c_id");
		gps = GPS.getGraduationProcess(cID);
		JSONObject jb = new JSONObject();
		jb.put("gps", gps);
		resp.setCharacterEncoding("UTF-8");
		PrintWriter pw = resp.getWriter();
		pw.write(jb.toString());
	}
	
}
