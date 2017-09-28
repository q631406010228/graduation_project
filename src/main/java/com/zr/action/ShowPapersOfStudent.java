package com.zr.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
@WebServlet("/showstudentpapers")
public class ShowPapersOfStudent extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		List<JSONObject> list = new ArrayList<JSONObject>();		
		String savePath = this.getServletContext().getRealPath("/upload/paper");
		JSONObject json1 = new JSONObject();
		File upload = new File(savePath);
		File[] studentPath = upload.listFiles();
		File[] paperFile = new File[]{};
		for(int i =0;i<studentPath.length;i++){
			paperFile =studentPath[i].listFiles();
			for (int j = 0; j < paperFile.length; j++) {
				JSONObject json =new JSONObject();
				json.put("snum", studentPath[i].getName());
				json.put("filename","<a href ="+"\""+"/graduation_project/downloadfile?path1="+studentPath[i].getName()+"&path2="+paperFile[j].getName()+"\""+">"+paperFile[j].getName()+"</a>");

				System.out.println(studentPath[i].getName());
				System.out.println(paperFile[j].getName());
			
				list.add(json);
			}
		}
		json1.put("rows", list);
		PrintWriter pw = resp.getWriter();
		pw.write(json1.toString());
	}
}
