package com.zr.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.ReplyProcessService;
import com.zr.service.impl.ReplyProcessServiceImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class AddReplyProcess
 */
/**
 * 
 * @author 欧小峰
 *
 */
@WebServlet("/AddReplyProcess")
public class AddReplyProcessAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReplyProcessService rpservice = new ReplyProcessServiceImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReplyProcessAction() {
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
		String stuid = request.getParameter("sid");
		int sid = Integer.parseInt(stuid);
		String ques = request.getParameter("ques");
		String answer = request.getParameter("answer");
		int i = rpservice.insertReplyProcess(sid, ques, answer);
		JSONObject json = new JSONObject();
		json.put("exception", i);
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
	}

}
