package com.zr.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 学生查询选课信息
 * 
 * @author Administrator
 *
 */
public class Student_SelectSubAction extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置编码
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		// 创建查询学生的选题服务对象
		// 获取返回的选题信息
		// 将信息返回给回调函数
	}
}
