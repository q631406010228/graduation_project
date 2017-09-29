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

import com.zr.service.StudentService;
import com.zr.service.impl.StudentServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetStudentScore
 */
@WebServlet("/getStudentScore")
public class GetStudentScore extends HttpServlet {
	private static final long serialVersionUID = 1L;
    StudentService stuservice = new StudentServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetStudentScore() {
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
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		int cid = (int) session.getAttribute("c_id");
		List<String> list1 = new ArrayList<>();
		list1.add("90~100");
		list1.add("80~90");
		list1.add("70~80");
		list1.add("60~70");
		list1.add("60以下");
		List<Integer> list2 = new ArrayList<>();
		List<Integer> list = stuservice.getStudentScore(cid);
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		int count5 = 0;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i)<=100 && list.get(i)>90){
				count1++;
			}else if(list.get(i)<=90 && list.get(i)>80){
				count2++;
			}
			else if(list.get(i)<=80 && list.get(i)>70){
				count3++;
			}
			else if(list.get(i)<=70 && list.get(i)>=60){
				count4++;
			}
			else if(list.get(i)<60){
				count5++;
			}
		}
		list2.add(count1);
		list2.add(count2);
		list2.add(count3);
		list2.add(count4);
		list2.add(count5);
		JSONObject json = new JSONObject();
		JSONArray js = new JSONArray();
		//json.put("categories", list1);
		json.put("categories", list1);
		json.put("data", list2);
		//js.add(list2);
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		//System.out.println(json.toString());
	}

}
