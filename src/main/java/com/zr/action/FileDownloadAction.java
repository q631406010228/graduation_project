package com.zr.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;

import net.sf.json.JSONObject;
@WebServlet("/downloadfile")
public class FileDownloadAction extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println(444);

		resp.setCharacterEncoding("utf8");
		String stuFiles = req.getParameter("path1");
		req.setCharacterEncoding("utf8");
		String paperFile = req.getParameter("path2");
		System.out.println(paperFile);
        HttpSession session = req.getSession();
		String filepath = this.getServletContext().getRealPath("/upload/" + stuFiles + "/teacher/7/"+ paperFile);
		File file = new File(filepath);
		//System.out.println(file.toString());
		JSONObject json = new JSONObject();
		if (!file.exists()) {
			resp.getWriter().print("你要下载的文件不存在");
			return;
		}

		resp.addHeader("content-disposition", "attachment;filename=" + paperFile);
		IOUtils.copy(new FileInputStream(file), resp.getOutputStream());

	}

}
