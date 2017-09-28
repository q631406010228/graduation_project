package com.zr.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.TeacherService;
import com.zr.service.impl.TeacherServiceImpl;

import net.sf.json.JSONObject;

@WebServlet("/showreplymission")
public class ShowReplyMission extends HttpServlet {
	TeacherService tea = new TeacherServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println(222);
		req.setCharacterEncoding("utf8");
		resp.setCharacterEncoding("utf-8");
		JSONObject json = tea.showReplymisson();
		PrintWriter pw = resp.getWriter();
		pw.write(json.toString());

	}

}
