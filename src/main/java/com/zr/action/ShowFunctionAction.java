package com.zr.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zr.service.FunctionService;
import com.zr.service.RoleService;
import com.zr.serviceimpl.FunctionServiceImpl;
import com.zr.serviceimpl.RoleServiceImpl;

import net.sf.json.JSONArray;

/**
 * @author SkySK:
 * @version 创建时间：2017年9月25日 上午10:05:41 说明 ：
 */
public class ShowFunctionAction extends HttpServlet {
	FunctionService func = new FunctionServiceImpl();
	RoleService roles = new RoleServiceImpl();
	public ShowFunctionAction() {
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
		// 设置编码
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		// 创建会话对象
		HttpSession session = req.getSession();
		// 获取用户的id
		int e_id = (int) session.getAttribute("e_id");
		int r_id = (int) session.getAttribute("r_id");
		System.out.println("ShowFunctionAction.doPost.e_id" + e_id);
		FunctionService function = new FunctionServiceImpl();
		JSONArray json = new JSONArray();
		json = function.getStaffFunction(e_id,r_id);
		PrintWriter pw = resp.getWriter();
		pw.write(json.toString());
		JSONArray jsonss = new JSONArray();
		jsonss = func.getAllFunction(-1);
		session.setAttribute("f", jsonss);
	}
}
