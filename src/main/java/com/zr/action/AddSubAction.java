package com.zr.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.SubService;
import com.zr.service.impl.SubServiceImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class AddSubAction
 */
/**
 * 选题申报action层
 * @author 欧小峰
 *
 */
@WebServlet("/AddSubAction")
public class AddSubAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    SubService sservice = new SubServiceImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSubAction() {
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
		String subname = request.getParameter("subname");
		String subcontent = request.getParameter("subcontent");
		int subcount = Integer.parseInt(request.getParameter("subcount"));
		int eid = Integer.parseInt(request.getParameter("eid"));
		int state = 0;
		int i = sservice.addSub(subname, subcontent, subcount, eid, state);
		JSONObject json = new JSONObject();
		json.put("exception", i);
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
	}

}
