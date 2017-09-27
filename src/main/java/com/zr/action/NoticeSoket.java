package com.zr.action;

import java.io.IOException;
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

import net.sf.json.JSONObject;

@ServerEndpoint("/websocket")
public class NoticeSoket {
	
	NoticeService ns = new NoticeServiceImpl();
	
	/**
	 * @throws java.io.IOException 
	 * @throws EncodeException 
	 */
	@OnMessage
	public void onMessage(String message, Session session) throws IOException, InterruptedException, java.io.IOException, EncodeException {
		int n = 0;
		while (true) {
			Thread.sleep(1000);
			List<Notice> ln = ns.getNotices(2,1406010001);
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
	public void onOpen(Session session) {
		System.out.println("客户端连接成功");
	}

	/** 当一个用户断开连接时所调用的方法 */
	@OnClose
	public void onClose() { 
		System.out.println("客户端关闭");
	}
}
