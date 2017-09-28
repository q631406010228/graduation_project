package com.zr.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.dao.RoleDao;
import com.zr.dao.impl.RoleDaoImpl;
import com.zr.model.Role;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author SkySK:
 * @version 创建时间：2017年9月25日 上午1:49:18 说明 ：
 */
@WebServlet("/showRoleName")
public class SelectRoleNameAction extends HttpServlet {
	RoleDao rdao = new RoleDaoImpl();

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
		JSONObject json = new JSONObject();
		JSONArray js = new JSONArray();
		PrintWriter pw = resp.getWriter();
		List<Role> role = rdao.selectAllRole();
		for (int i = 0; i < role.size(); i++) {
			json.put("id", role.get(i).getRid());
			json.put("text", role.get(i).getRname());
			js.add(json);
		}
		pw.write(js.toString());
	}
}
