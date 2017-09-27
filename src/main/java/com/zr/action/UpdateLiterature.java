<<<<<<< HEAD
package com.zr.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.LiteratureService;
import com.zr.service.impl.LiteratureServiceImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class UpdateLiterature
 */
@WebServlet("/shenhe")
public class UpdateLiterature extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LiteratureService liservice = new LiteratureServiceImpl();      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateLiterature() {
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
		String Wxid = request.getParameter("wxid");
		int wxid = Integer.parseInt(Wxid);
		String statename = request.getParameter("state");
		int state;
		//System.out.println("wxid:"+wxid+"state:"+statename);
		if("通过".equals(statename)){
			state = 1;
		}else{
			state = 2;
		}
		int i = liservice.updateLiterature(wxid, state);
		JSONObject json = new JSONObject();
		json.put("ok", i);
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		
	}

}
=======
package com.zr.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.LiteratureService;
import com.zr.service.impl.LiteratureServiceImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class UpdateLiterature
 */
@WebServlet("/shenhe")
public class UpdateLiterature extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LiteratureService liservice = new LiteratureServiceImpl();      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateLiterature() {
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
		String Wxid = request.getParameter("wxid");
		int wxid = Integer.parseInt(Wxid);
		String statename = request.getParameter("state");
		int state;
		//System.out.println("wxid:"+wxid+"state:"+statename);
		if("通过".equals(statename)){
			state = 1;
		}else{
			state = 2;
		}
		int i = liservice.updateLiterature(wxid, state);
		JSONObject json = new JSONObject();
		json.put("ok", i);
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		
	}

}
>>>>>>> edb45fe6cd0177f620b12cff36781fe446007bbd
