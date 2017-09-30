package com.zr.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/checkpaper")
public class CheckPaper extends HttpServlet{
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(333);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String[] state= {"通过","责改"};
		JSONObject json = new JSONObject();
		JSONArray js = new JSONArray();
		PrintWriter pw = response.getWriter();
		for (int i = 0; i < state.length; i++) {
			json.put("id", i);
			json.put("text", state[i]);
			js.add(json);
		}
		pw.write(js.toString());
	}

}
