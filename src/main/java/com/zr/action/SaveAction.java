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
		//int flag = Integer.parseInt(req.getParameter("flag"));
//		System.out.println("id"+req.getParameter("id"));
		System.out.println("uname5:"+req.getParameter("uname5"));
		String u5=req.getParameter("uname5");
		System.out.println(u5);
		if ("1".equals(req.getParameter("flag"))) {
			System.out.println("进入增加");
			String reply_site = req.getParameter("uname1");
			
			
			String reply_start = req.getParameter("uname3");
			String reply_end = req.getParameter("uname4");
			
			int  e_id = Integer.parseInt(req.getParameter("uname5"));
			int sub_id = rs.getSubidByEid(e_id);
			System.out.println("reply_site:"+reply_site);
			System.out.println("sub_id:"+sub_id);
			System.out.println("sub_id:"+reply_start);
			System.out.println("reply_end:"+reply_end);
			System.out.println("e_id:"+e_id);
			
			rs.addReply(reply_site, sub_id, reply_start, reply_end, e_id);
		}else
		if ("2".equals(req.getParameter("flag"))) {
			System.out.println("进入修改");
			int reply_id = Integer.parseInt(req.getParameter("id"));
			String reply_site = req.getParameter("uname1");
			
			
			String reply_start = req.getParameter("uname3");
			String reply_end = req.getParameter("uname4");
			
			int e_id = Integer.getInteger(req.getParameter("uname5"));
			
			int sub_id = rs.getSubidByEid(e_id);
			rs.alertReply(reply_id, reply_site, sub_id, reply_start, reply_end, e_id);
		}else
		if ("3".equals(req.getParameter("flag"))) {
			System.out.println("flag:"+Integer.parseInt(req.getParameter("flag")));
			int reply_id = Integer.parseInt(req.getParameter("id"));
			rs.deleteReply(reply_id);
		}
		resp.setCharacterEncoding("utf8");
	}
}
