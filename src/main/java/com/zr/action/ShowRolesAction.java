package com.zr.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zr.service.RoleService;
import com.zr.service.impl.RoleServiceImpl;

import net.sf.json.JSONArray;

public class ShowRolesAction extends  HttpServlet{
		RoleService  rs = new RoleServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//JSONArray   j = rs.getAllRoles(-1);
		HttpSession  session = req.getSession();
//		String uname = (String) session.getAttribute("uname");
//		String s=rs.getFidsByRid(rs.getRidByUname(uname));
	    JSONArray  j  =  rs.getuserRoles(-1, "1,2,3,4");
	 
//	    JSONArray  j  =  rs.getuserRoles(-1, "1,2,3,4,5,6,7,8");
	  
		resp.setCharacterEncoding("utf8");
		PrintWriter  pw = resp.getWriter();
		pw.write(j.toString());
	}
}
