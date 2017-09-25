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

import com.zr.service.ReplyProcessService;
import com.zr.service.impl.ReplyProcessServiceImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class DeleteReplyProcessAction
 */
@WebServlet("/DeleteReplyProcessAction")
public class DeleteReplyProcessAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ReplyProcessService rpservice = new ReplyProcessServiceImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteReplyProcessAction() {
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
		String [] prids = request.getParameterValues("sid");
		List<Integer> sid = new ArrayList<Integer>();
		for (int i = 0; i < prids.length; i++) {
			sid.add(Integer.parseInt(prids[i]));
		}
		int flag[] = new int[20];
		flag = rpservice.deletReplyProcess(sid);
		JSONObject jsons = new JSONObject();
		for (int i = 0; i < sid.size(); i++) {
			if(flag[i]==1){
				jsons.put("exce", "删除成功");
				break;
			}
			else{
				jsons.put("exce", "删除失败");
			}
		}
		PrintWriter pw = response.getWriter();
		pw.write(jsons.toString());
	/*	HttpSession session = request.getSession();
		session.setAttribute("exception", "删除成功");*/
	}

}
