package com.zr.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.LiteratureService;
import com.zr.service.impl.LiteratureServiceImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class SelectWwnXianAction
 */
@WebServlet("/selectLiteratureAction")
public class SelectLiteratureAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    LiteratureService liservice = new LiteratureServiceImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectLiteratureAction() {
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
		int eid = 1;
		List list = liservice.selectLiteratureByEid(eid);
		JSONObject json = new JSONObject();
		//json.put("total", count);
		//json.put("total",1);
		json.put("rows", list);
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
	}
}
