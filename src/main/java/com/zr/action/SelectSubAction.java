
package com.zr.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zr.model.Sub;
import com.zr.service.SubService;
import com.zr.service.impl.SubServiceImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class SelectSub
 */
/**
 * 
 * @author 欧小峰
 *
 */
@WebServlet("/selectSub")
public class SelectSubAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    SubService subservice = new SubServiceImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectSubAction() {
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
		response.setCharacterEncoding("utf8");
		request.setCharacterEncoding("utf8");
		HttpSession session = request.getSession();
		int eid = (int) session.getAttribute("e_id");
		Sub sub = subservice.selectSubByEid(eid);
		JSONObject json = new JSONObject();
		session.setAttribute("subname", sub.getSubname());
		session.setAttribute("subcontent", sub.getSubcontent());
		session.setAttribute("subcount", sub.getSubcount());
		if(sub.getSubstate()==0){
			session.setAttribute("state", "未审核");
		}else if(sub.getSubstate()==1){
			session.setAttribute("state", "通过");
		}else{
			session.setAttribute("state", "驳回");
		}
	}

}

