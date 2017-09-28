package com.zr.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.zr.dao.TeacherDao;
import com.zr.dao.impl.TeacherDaoImpl;
import com.zr.service.TeacherService;
import com.zr.service.impl.TeacherServiceImpl;

import net.sf.json.JSONObject;

public class FileUploadAction extends HttpServlet {
	TeacherService tea = new TeacherServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("utf8");
		int id;
		// System.out.println(111);
		DiskFileItemFactory dfif = new DiskFileItemFactory();

		ServletFileUpload sfu = new ServletFileUpload(dfif);
		String username = "";

		String realfile = "";
		JSONObject json = new JSONObject();
		try {
			List<FileItem> list = sfu.parseRequest(req);

			for (FileItem fileItem : list) {
				if (fileItem.isFormField()) {
					if (fileItem.getFieldName().equals("sname")) {
						username = fileItem.getString();

					}
				} else {
					id = Integer.parseInt(username);
					realfile = tea.getSnum(id);
					String name = fileItem.getName();
					if (name == null || name.isEmpty()) {
						continue;
					}
					String savepath = this.getServletContext().getRealPath("/upload/" + realfile + "/paper");

					File file2 = new File(savepath);
					if (!file2.exists()) {
						file2.mkdirs();
					}
					File file = new File(file2, name);
					try {
						fileItem.write(file);
						json.put("s", true);
						json.put("msg", "传给学生" + username + "的文件:" + name + "<br/>文件大小：" + fileItem.getSize()
								+ "<br/>文件类型：" + fileItem.getContentType() + "<br/>上传成功！");
						resp.getWriter().print(json.toString());

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
