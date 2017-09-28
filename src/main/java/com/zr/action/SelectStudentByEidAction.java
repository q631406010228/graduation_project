package com.zr.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zr.model.Student;
import com.zr.service.StudentService;
import com.zr.service.impl.StudentServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class SelectStudentByEid
 */
/**
 * 通过选题发布教师查询学生信息action层
 * @author 欧小峰
 *
 */
@WebServlet("/SelectStudentByEid")
public class SelectStudentByEidAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    StudentService stuservice = new StudentServiceImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectStudentByEidAction() {
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
<<<<<<< HEAD
		HttpSession session = request.getSession();
=======
		HttpSession session = (HttpSession) request.getSession();
>>>>>>> master
		int eid = (int) session.getAttribute("e_id");
		List<Student> list = stuservice.selectStudentByEid(eid);
		JSONObject json = new JSONObject();
		JSONArray js = new JSONArray();
		PrintWriter pw = response.getWriter();
		for (int i = 0; i < list.size(); i++) {
			json.put("id", list.get(i).getSid());
			json.put("text", list.get(i).getSname());
			js.add(json);
		}
		pw.write(js.toString());
	}

}
