package com.zr.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.NoticeService;
import com.zr.service.impl.NoticeServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SetNoticeAction extends HttpServlet {

	NoticeService ns = new NoticeServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = new String(req.getParameter("snTitle").getBytes("iso-8859-1"), "utf-8");
		String content = new String(req.getParameter("snContent").getBytes("iso-8859-1"), "utf-8");
		int receiveID = Integer.parseInt(req.getParameter("role"));
		// System.out.println(req.getParameter("role"));
		int sendID = Integer.parseInt(req.getParameter("sendID"));
		String data = req.getParameter("data");
		ns.setDeanNotice(1, receiveID, title, content, data);
		resp.setCharacterEncoding("UTF-8");
		PrintWriter pw = resp.getWriter();
		pw.write("1");
	}

}