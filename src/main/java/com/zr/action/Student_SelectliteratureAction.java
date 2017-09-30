package com.zr.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zr.service.LiteratureService;
import com.zr.service.impl.LiteratureServiceImpl;

import net.sf.json.JSONArray;
@WebServlet("/Student_Selectliterature")
public class Student_SelectliteratureAction extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 //设置编码
	req.setCharacterEncoding("utf-8");
	resp.setCharacterEncoding("utf-8");
	//创建json数组
	JSONArray array=new JSONArray();
	//创建服务对象
	LiteratureService literatureService=new LiteratureServiceImpl();
	//获取用户id
	HttpSession session = req.getSession();
	Integer s_id= (Integer)session.getAttribute("e_id");
	//获取文献数据值
	array=literatureService.getLiteratureBySid(s_id);
	//传回页面
	PrintWriter printWriter=resp.getWriter();
	printWriter.write(array.toString());
	}
}
