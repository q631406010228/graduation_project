
package com.zr.action;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.dao.TeacherDao;
import com.zr.dao.impl.TeacherDaoImpl;
import com.zr.service.TeacherService;
import com.zr.service.impl.TeacherServiceImpl;

import net.sf.json.JSONObject;

@WebServlet("/alterstudentscore")
public class AddStudentScoreAction extends HttpServlet {
	TeacherService tea = new TeacherServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf8");

		int sid = Integer.parseInt(req.getParameter("sid"));
		int score = Integer.parseInt(req.getParameter("score"));
		tea.alterStudentScore(sid, score);
		JSONObject json = new JSONObject();
		json.put("s", true);
		json.put("msg", "修改成功");
		PrintWriter pw = resp.getWriter();
		pw.write(json.toString());
	}
}
