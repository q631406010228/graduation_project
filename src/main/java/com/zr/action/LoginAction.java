package com.zr.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zr.service.ValidateService;
import com.zr.service.impl.LoginServiceImpl;
import com.zr.service.impl.ValidateServiceImpl;

import net.sf.json.JSONObject;

/** 
* @author SkySK: 
* @version 创建时间：2017年9月25日 上午1:04:59 
* 说明 ：
*/
@WebServlet("/login")
public class LoginAction extends HttpServlet{
	ValidateService vs = new ValidateServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置编码格式
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		// 获取页面信息
		String ename = req.getParameter("ename");
		String epsw = req.getParameter("epsw");

		// 获取用户的类型，用来判断从哪个表来进行查询
		String dept = req.getParameter("dept");
		//System.out.println("ename:" + ename + "epsw:" + epsw + "dept:" + dept);

		// 创建登录服务对象，获取数据库中返回的信息
		LoginServiceImpl login = new LoginServiceImpl();
		JSONObject js = new JSONObject();
		js = login.getUserIdByUsernum(dept,ename,epsw);

		// 创建会话对象
		HttpSession s = req.getSession();

		PrintWriter pw = resp.getWriter();
		// 对返回的信息进行判断
		if (js.get("ok").equals(true)) {
			s.setAttribute("e_id", js.get("e_id"));
			s.setAttribute("c_id", js.get("c_id"));
			s.setAttribute("r_id", js.get("r_id"));
			//System.out.println(js.toString());
		} else {
			s.setAttribute("e_id", null);
		}
		pw.write(js.toString());
	}
}
