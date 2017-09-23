package com.zr.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetGPAction extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JSONArray gps = new JSONArray();
		JSONObject gp = new JSONObject();
		gp.put("id", 0);
		gp.put("text", "毕业设计开题");
		gps.add(gp);
		gp.put("id", 1);
		gp.put("text", "中期检查报告");
		gps.add(gp);
		gp.put("id", 2);
		gp.put("text", "完成毕业设计定稿");
		gps.add(gp);
		gp.put("id", 3);
		gp.put("text", "答辩");
		gps.add(gp);
		resp.setCharacterEncoding("UTF-8");
		PrintWriter pw = resp.getWriter();
		pw.write(gps.toString());
	}

	
}
