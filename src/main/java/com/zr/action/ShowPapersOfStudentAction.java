package com.zr.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.GraduationProcessService;
import com.zr.service.TeacherService;
import com.zr.service.impl.GraduationProcessServiceImpl;
import com.zr.service.impl.TeacherServiceImpl;

import net.sf.json.JSONObject;

public class ShowPapersOfStudentAction extends HttpServlet {
	TeacherService tea = new TeacherServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf8");
		JSONObject json = new JSONObject();
		json = tea.getPapers();
		PrintWriter pw = resp.getWriter();
		pw.write(json.toString());

	}

}
