package com.zr.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.FunctionService;
import com.zr.serviceimpl.FunctionServiceImpl;

import net.sf.json.JSONArray;


/** 
* @author SkySK: 
* @version 创建时间：2017年9月25日 上午2:48:49 
* 说明 ：
*/
public class ShowAllFunctionAction extends HttpServlet {
	FunctionService func = new FunctionServiceImpl();

	public ShowAllFunctionAction() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		JSONArray json = new JSONArray();
		json = func.getAllFunction(-1);
		PrintWriter pw = resp.getWriter();
		pw.write(json.toString());
	}
}
