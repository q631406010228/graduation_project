package com.zr.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.NoticeService;
import com.zr.service.impl.NoticeServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/sendStudentNotice")
public class SendStudentNoticeAction extends HttpServlet{
	
	NoticeService ns = new NoticeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String sid = req.getParameter("sid");
		int eID = Integer.parseInt(req.getParameter("eID"));
		String title = req.getParameter("subname");
		String content = req.getParameter("ques");
		String data = req.getParameter("data");
		ns.setTeacherNotice(1, 2, title, content, data, sid);
	}
}
