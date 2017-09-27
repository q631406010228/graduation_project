package com.zr.action;

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

/**
 * Servlet implementation class DeleteTeacher
 */
@WebServlet("/deleteTeacher")
public class DeleteTeacherAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    TeacherService tservice = new TeacherServiceImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTeacherAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf8");
		String id[] = request.getParameterValues("eid");
		StringBuffer str = new StringBuffer();
		List<Integer> eid = new ArrayList();
		List<Integer> flag = new ArrayList();
		//int sid[] = new int[50];
		//int flag[] = new int[50];
		for (int i = 0; i < id.length; i++) {
			 str.append(id[i]);
		}
		String eids[] = str.toString().split(",");
		
		for (int i = 0; i < eids.length; i++) {
			//System.out.println(stuid[i]);
			eid.add(Integer.parseInt(eids[i])) ;
			
		}
		flag = tservice.deleteTeacher(eid);
		JSONObject jsons = new JSONObject();
		for (int i = 0; i < flag.size(); i++) {
			System.out.println(flag.get(i).toString());
			if(!("1".equals( flag.get(i).toString()))){
				jsons.put("exce", "删除失败");
				break;
			}
			else{
				jsons.put("exce", "删除成功");
			}
		}
		PrintWriter pw = response.getWriter();
		pw.write(jsons.toString());
		HttpSession session = request.getSession();
		session.setAttribute("exception", "删除成功");
	
	}

}
