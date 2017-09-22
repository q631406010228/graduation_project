package com.zr.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.model.Role;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetGP extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JSONArray gps = new JSONArray();
		for(int i = 0;i < 3;i++){
			JSONObject gp = new JSONObject();
			gp.put("id", i);
			gp.put("text", "毕业设计开题");
			gps.add(gp);	
		}										
		resp.setCharacterEncoding("UTF-8");
		PrintWriter pw = resp.getWriter();
		pw.write(gps.toString());
	}

}
