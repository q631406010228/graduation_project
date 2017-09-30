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
import javax.servlet.http.HttpSession;

import com.zr.service.TeacherService;
import com.zr.service.impl.TeacherServiceImpl;

import net.sf.json.JSONObject;
@WebServlet("/showstudentpapers")
public class ShowPapersOfStudent extends HttpServlet {
	TeacherService  tea = new TeacherServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		//int eid = (int)session.getAttribute("e_id");
	    int eid = 2;
		int page = Integer.parseInt(req.getParameter("page"));
		int pageSize =  Integer.parseInt(req.getParameter("rows"));
		JSONObject json =new JSONObject();
		//在论文表中插入学生论文信息
		//tea.insertStudentPapers();
		//配置网页表格
		json = tea.showPapersofStudent(eid, page, pageSize);
		PrintWriter pw = resp.getWriter();
	    pw.write(json.toString());
		
		
	  /*  String snum=" ";
	    String studentPapers = "";
	    //获取该老师的学生的所有id
	    int[] sids =  tea.getSidsOfStudentByEid(eid);
	    for (int i = 0; i < sids.length; i++) {
	    	//获取id对应的学生学号
			 snum = tea.getSnum(sids[i]);
			 //获取该学生上传的所有论文
			 studentPapers = this.getServletContext().getRealPath("/upload/"+snum+"/teacher/7");
			 File papersPath = new File(studentPapers);
			 File[] paperFile = papersPath.listFiles();
			 //将其论文信息存入数据库
		}*/
	    
	    
	  /*  String s= "teacher"+eid;
		List<JSONObject> list = new ArrayList<JSONObject>();		
		String savePath = this.getServletContext().getRealPath("/upload/"+s+"/paper");
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

				//System.out.println(studentPath[i].getName());
				//System.out.println(paperFile[j].getName());
			
				list.add(json);
			}
		}
		json1.put("rows", list);
		PrintWriter pw = resp.getWriter();
		pw.write(json1.toString());*/
	}
}
