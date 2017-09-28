
package com.zr.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.zr.dao.TeacherDao;
import com.zr.dao.impl.TeacherDaoImpl;
import com.zr.service.TeacherService;
import com.zr.service.impl.TeacherServiceImpl;

import net.sf.json.JSONObject;

@WebServlet("/showstudentscore")
public class CheckScoresOfStudent extends HttpServlet {
	TeacherService tea = new TeacherServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int eid = 2;
		resp.setCharacterEncoding("utf8");
		JSONObject json = tea.getScoresOfStu(eid);
		PrintWriter pw = resp.getWriter();
		pw.write(json.toString());
	}

}