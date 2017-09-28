
package com.zr.action;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.TeacherService;
import com.zr.service.impl.TeacherServiceImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class AddTeacherAction
 */
@WebServlet("/addTeacher")
public class AddTeacherAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TeacherService tservice = new TeacherServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddTeacherAction() {
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
		String ename = request.getParameter("ename");
		String emnum = request.getParameter("emnum");
		String colid = request.getParameter("cid");
		String epsw = request.getParameter("epsw");
		int e_num = Integer.parseInt(emnum);
		int cid = Integer.parseInt(colid);
		int i = tservice.insertTeacher(ename, cid, e_num, epsw);
		JSONObject json = new JSONObject();
		json.put("exception", i);
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
	}

}
