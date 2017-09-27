package com.zr.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.model.Staff;
import com.zr.model.Student;
import com.zr.service.DeanService;
import com.zr.service.GraduationProcessService;
import com.zr.service.impl.DeanServiceImpl;
import com.zr.service.impl.GraduationProcessServiceImpl;

import net.sf.json.JSONObject;

@WebServlet("/showDean")
public class ShowDeanAction extends HttpServlet{
	
	DeanService ds = new DeanServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf8");
		req.setCharacterEncoding("utf8");
		List<Staff> list = ds.getDean();
		int count = list.size();
		JSONObject json = new JSONObject();
		json.put("rows", list);
		PrintWriter pw = resp.getWriter();
		pw.write(json.toString());	
	}

}

