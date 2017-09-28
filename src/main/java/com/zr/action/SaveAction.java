package com.zr.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.ReplyService;
import com.zr.service.StaffService;
import com.zr.service.impl.ReplyServiceImpl;
import com.zr.service.impl.StaffServiceImpl;

@WebServlet("/save")
public class SaveAction extends HttpServlet {
	ReplyService rs = new ReplyServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 resp.setCharacterEncoding("utf8");
		 req.setCharacterEncoding("utf-8");
		int flag = Integer.parseInt(req.getParameter("flag"));
		//System.out.println(flag);
		//System.out.println(req.getParameter("id"));
		if (flag == 1) {
			String reply_site = req.getParameter("uname1");
			System.out.println(reply_site);
			int sub_id = Integer.parseInt(req.getParameter("uname2"));
			String reply_start = req.getParameter("uname3");
			String reply_end = req.getParameter("uname4");
			int e_id = Integer.parseInt(req.getParameter("uname5"));
			rs.addReply(reply_site, sub_id, reply_start, reply_end, e_id);
		}
		if (flag == 2) {
			int reply_id = Integer.parseInt(req.getParameter("id"));
			String reply_site = req.getParameter("uname1");
			System.out.println(reply_site);
			int sub_id = Integer.parseInt(req.getParameter("uname2"));
			String reply_start = req.getParameter("uname3");
			String reply_end = req.getParameter("uname4");
			int e_id = Integer.parseInt(req.getParameter("uname5"));
			rs.alertReply(reply_id, reply_site, sub_id, reply_start, reply_end, e_id);
		}
		if (flag == 3) {
			int reply_id = Integer.parseInt(req.getParameter("id"));
			rs.deleteReply(reply_id);
		}
		resp.setCharacterEncoding("utf8");
	}
}
