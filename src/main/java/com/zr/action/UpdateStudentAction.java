package com.zr.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.GraduationProcessService;
import com.zr.service.StudentService;
import com.zr.service.impl.GraduationProcessServiceImpl;
import com.zr.service.impl.StudentServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/updateStudent")
public class UpdateStudentAction extends HttpServlet {

	StudentService ss = new StudentServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		if ("1".equals(req.getParameter("flag"))) {
			int num = Integer.parseInt(req.getParameter("num"));
			String name = req.getParameter("sname");
			int cID = Integer.parseInt(req.getParameter("cname"));
			int mID = Integer.parseInt(req.getParameter("mname"));
			ss.insertStudent(num, name, cID, mID);
		} else if ("2".equals(req.getParameter("flag"))) {
			String num = req.getParameter("sids");
			ss.deleteStudent(num);
		} else if ("3".equals(req.getParameter("flag"))) {
			int preNum = Integer.parseInt(req.getParameter("sid"));
			int num = Integer.parseInt(req.getParameter("num"));
			String name = req.getParameter("sname");
			int cID = Integer.parseInt(req.getParameter("cname"));
			int mID = Integer.parseInt(req.getParameter("mname"));
			ss.updateStudent(num, name, cID, mID, preNum);
		}
	}
}