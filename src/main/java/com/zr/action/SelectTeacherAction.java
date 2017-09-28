package com.zr.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.model.Staff;
import com.zr.service.TeacherService;
import com.zr.service.impl.TeacherServiceImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class SelectTeacherAction
 */
@WebServlet("/selectTeacher")
public class SelectTeacherAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TeacherService tservice = new TeacherServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectTeacherAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		List<Staff> list = tservice.selectTeacher();
		int count = tservice.selectTeacherCount();
		JSONObject json = new JSONObject();
		json.put("total", count);
		// json.put("total",1);
		json.put("rows", list);
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
	}

}
