package com.zr.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import net.sf.json.JSONObject;

public class FileDownloadAction extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf8");
		resp.setCharacterEncoding("utf8");
		String stuFiles = req.getParameter("path1");
		// System.out.println(stuFiles[0]);
		String paperFile = req.getParameter("path2");
		// for (int i = 0; i < stuFiles.length; i++) {
		String filepath = this.getServletContext().getRealPath("/upload/paper/" + stuFiles + "/" + paperFile);
		File file = new File(filepath);
		System.out.println(file.toString());
		JSONObject json = new JSONObject();
		if (!file.exists()) {
			resp.getWriter().print("你要下载的文件不存在");
			return;
		}

		resp.addHeader("content-disposition", "attachment;filename=" + paperFile);
		IOUtils.copy(new FileInputStream(file), resp.getOutputStream());
		// resp.getWriter().print("下载成功");
		/*
		 * json.put("msg", "学生id：" + stuFiles[i] + "的论文：<br>" + paperFile[i] +
		 * "下载成功！"); PrintWriter pw = resp.getWriter();
		 * pw.write(json.toString()); System.out.println(json.toString());
		 */
	}
	// }
}
