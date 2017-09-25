package com.zr.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.ReplyProcessService;
import com.zr.service.StudentService;
import com.zr.service.impl.ReplyProcessServiceImpl;
import com.zr.service.impl.StudentServiceImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class SelectStudentForm
 */
@WebServlet("/selectStudentForm")
public class SelectStudentFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentService stuservice = new StudentServiceImpl(); 
	ReplyProcessService rpservice = new ReplyProcessServiceImpl(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectStudentFormAction() {
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
		response.setCharacterEncoding("utf8");
		request.setCharacterEncoding("utf8");
		int eid = 1;
		List list = stuservice.selectStudentFormByEid(eid);
		int count = rpservice.selectReplyProcessAcount(eid);
		JSONObject json = new JSONObject();
		json.put("total", count);
		json.put("rows", list);
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
	}

}
