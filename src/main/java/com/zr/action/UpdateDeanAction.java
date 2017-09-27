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
import com.zr.service.DeanService;
import com.zr.service.StudentService;
import com.zr.service.impl.DeanServiceImpl;
import com.zr.service.impl.StudentServiceImpl;

import net.sf.json.JSONObject;

@SuppressWarnings("serial")
@WebServlet("/updateDean")
public class UpdateDeanAction extends HttpServlet {

	DeanService ds = new DeanServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		if ("1".equals(req.getParameter("flag"))) {
			int e_num = Integer.parseInt(req.getParameter("emnum"));
			String ename = req.getParameter("ename");
			int ecol = Integer.parseInt(req.getParameter("ecol"));
			ds.insertDean(ename, ecol, e_num);
		} else if ("2".equals(req.getParameter("flag"))) {
			String eid = req.getParameter("sids");
			ds.deleteDean(eid);
		} else if ("3".equals(req.getParameter("flag"))) {
			int e_num = Integer.parseInt(req.getParameter("emnum"));
			String ename = req.getParameter("ename");
			int ecol = Integer.parseInt(req.getParameter("ecol"));
			String epsw = req.getParameter("epsw");
			int eid = Integer.parseInt(req.getParameter("eid"));
			ds.updateDean(ename, ecol, e_num, epsw, eid);
		}
	}
}
