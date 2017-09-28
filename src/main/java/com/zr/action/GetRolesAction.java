
package com.zr.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.model.GraduationProcess;
import com.zr.service.GraduationProcessService;
import com.zr.service.impl.GraduationProcessServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetRolesAction extends HttpServlet {

	GraduationProcessService GPS = new GraduationProcessServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JSONArray ja = new JSONArray();
		JSONObject jb1 = new JSONObject();
		jb1.put("id", 2);
		jb1.put("text", "学生");
		jb1.put("selected", true);
		ja.add(jb1);
		JSONObject jb2 = new JSONObject();
		jb2.put("id", 3);
		jb2.put("text", "教师");
		ja.add(jb2);
		resp.setCharacterEncoding("UTF-8");
		PrintWriter pw = resp.getWriter();
		pw.write(ja.toString());
	}
}