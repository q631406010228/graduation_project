package com.zr.action;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.zr.connection.GetHttpSessionConfigurator;
import com.zr.dao.StaffRoleDao;
import com.zr.dao.StudentDao;
import com.zr.dao.impl.StaffRoleDaoImpl;
import com.zr.dao.impl.StudentDaoImpl;
import com.zr.model.Notice;
import com.zr.service.NoticeService;
import com.zr.service.impl.NoticeServiceImpl;

import net.sf.json.JSONObject;

@ServerEndpoint(value="/websocket",configurator=GetHttpSessionConfigurator.class)
public class NoticeSoket {
	
	int rid ;
	int num;
	NoticeService ns = new NoticeServiceImpl();
	StaffRoleDao srd = new StaffRoleDaoImpl();
	StudentDao sd = new StudentDaoImpl();
	
	/**
	 * @throws java.io.IOException 
	 * @throws EncodeException 
	 */
	@OnMessage
	public void onMessage(String message, Session session) throws IOException, InterruptedException, java.io.IOException, EncodeException {
		int n = 0;
		
		while (true) {
			Thread.sleep(1000);
			List<Notice> ln = new LinkedList<Notice>();
			if(rid == 3){
				ln = ns.getNotices(rid,1);
			}else if(rid == 2){
				ln = ns.getNotices(rid,num);
			}
			JSONObject ja = new JSONObject();
			ja.put("Notice", ln);
			if(ln.size() != n){
				session.getBasicRemote().sendText(ja.toString());
				n = ln.size();
			}
		}
	}  

	/**
	 * 当一个新用户连接时所调用的方法 该方法可能包含一个javax.websocket.Session可选参数
	*/
	@OnOpen
	public void onOpen(Session session,EndpointConfig config) {
		/*System.out.println("客户端连接成功");*/
		HttpSession httpSession= (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
		rid = (int) httpSession.getAttribute("r_id");
		if(rid == 2){
			num = Integer.parseInt(sd.getStudentnumBys_id((int) httpSession.getAttribute("e_id")));
		}else if(rid == 0){
			rid = srd.getRidByEid((int) httpSession.getAttribute("e_id"));
		}
        System.err.println(httpSession.getAttribute("r_id"));
        System.err.println(rid);
        System.err.println((int) httpSession.getAttribute("e_id"));
        //sessionMap.put(session.getId(), session);	
	}

	/** 当一个用户断开连接时所调用的方法 */
	@OnClose
	public void onClose() { 
		/*System.out.println("客户端关闭");*/
	}
}
