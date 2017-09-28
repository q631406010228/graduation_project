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
 * Servlet implementation class UpdateTeacherAction
 */
@WebServlet("/updateTeacher")
public class UpdateTeacherAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    TeacherService tservice = new TeacherServiceImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTeacherAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String tid = request.getParameter("eid");
		String ename = request.getParameter("ename");
		String emnum = request.getParameter("emnum");
		String colid = request.getParameter("cid");
		int eid = Integer.parseInt(tid);
		int e_num = Integer.parseInt(emnum);
		int cid = Integer.parseInt(colid);
		int i = tservice.updateTeacher(eid, ename, cid, e_num);
		JSONObject json = new JSONObject();
		json.put("exception", i);
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
	}

}
