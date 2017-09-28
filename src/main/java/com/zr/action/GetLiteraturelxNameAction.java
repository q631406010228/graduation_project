
package com.zr.action;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.LiteraturelxService;
import com.zr.service.impl.LiteraturelxServiceImpl;

import net.sf.json.JSONArray;

@WebServlet("/getLiteraturelxName")
public class GetLiteraturelxNameAction extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置编码
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		// 创建服务对象
		LiteraturelxService literaturelxService = new LiteraturelxServiceImpl();
		// 获取值
		JSONArray json_arr = new JSONArray();
		json_arr = literaturelxService.getAllLiteraturelxInfoForCombobox();
		// 传递给请求方法
		PrintWriter printWriter = resp.getWriter();
		printWriter.write(json_arr.toString());
	}
}
