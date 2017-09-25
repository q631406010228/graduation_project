package com.zr.action;

import java.util.List;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.zr.model.Notice;
import com.zr.service.NoticeService;
import com.zr.service.impl.NoticeServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 在tomcat7中存在WebSocketServlet类（但已经过时），在tomcat8中彻底删除
 * 此处使用@ServerEndpoint注解，主要是将目前的类定义成一个websocket服务器端 注解的值将被用于监听用户连接的终端访问URL地址
 */
@ServerEndpoint("/websocket")
public class NoticeSoket {
	
	NoticeService ns = new NoticeServiceImpl();
	/**
	 * 当服务器接收到客户端发送的消息时所调用的方法 该方法可能包含一个javax.websocket.Session可选参数
	 * 如果有这个参数，容器将会把当前发送消息客户端的连接Session注入进去
	 * @throws java.io.IOException 
	 * @throws EncodeException 
	 */
	@OnMessage
	public void onMessage(String message, Session session) throws IOException, InterruptedException, java.io.IOException, EncodeException {
		int n = 0;
		while (true) {
			Thread.sleep(1000);
			List<Notice> ln = ns.getNotices(2, 1);
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
	 * 如果有这个参数，容器将会把当前发送消息客户端的连接Session注入进去
	 */
	@OnOpen
	public void onOpen(Session session) {
		System.out.println("客户端连接成功");
	}

	/** 当一个用户断开连接时所调用的方法 */
	@OnClose
	public void onClose() { 
		System.out.println("客户端关闭");
	}
}
