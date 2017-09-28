package com.zr.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.ReplyService;
import com.zr.service.impl.ReplyServiceImpl;

import net.sf.json.JSONObject;
@WebServlet("/replyTable")
public class ReplyTableAction extends HttpServlet{
	ReplyService rs=new ReplyServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page = Integer.parseInt(req.getParameter("page"));
		int pageSize = Integer.parseInt(req.getParameter("rows"));
		JSONObject j = rs.getReplys(page, pageSize);
		resp.setCharacterEncoding("utf8");
		PrintWriter pw = resp.getWriter();
		pw.write(j.toString());
	
	}

}
