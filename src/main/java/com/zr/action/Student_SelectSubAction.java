package com.zr.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zr.service.SubService;
import com.zr.service.impl.SubServiceImpl;

import net.sf.json.JSONArray;

/**
 * 学生查询选课信息
 * @author Administrator
 *
 */
@WebServlet("/student_selectsub")
public class Student_SelectSubAction extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		//创建查询学生的选题服务对象
		SubService sub= new SubServiceImpl();
		//获取学生的学院id
		HttpSession session = req.getSession();
		Integer c_id = (Integer)session.getAttribute("c_id");
		System.out.println("Student_SelectSubAction.doPost.c_id:"+c_id);
		//获取返回的选题信息
		JSONArray json_arr= new JSONArray();
		json_arr=sub.selectSubBySid(c_id);
		/*json_arr=sub.selectSubBySid(1);*/
		//将信息返回给回调函数
		PrintWriter print = resp.getWriter();
		//System.out.println("Student_SelectSubAction.doPost.json_arr:"+json_arr);
		print.write(json_arr.toString());
	}
}