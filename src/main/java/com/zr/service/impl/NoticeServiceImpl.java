package com.zr.service.impl;

import java.util.LinkedList;
import java.util.List;

import com.zr.dao.NoticeDao;
import com.zr.dao.impl.NoticeDaoImpl;
import com.zr.model.Notice;
import com.zr.service.NoticeService;

public class NoticeServiceImpl implements NoticeService {
	
	NoticeDao nd = new NoticeDaoImpl();

	@Override
	public void setDeanNotice(int sendID, int receiveID, String title, String content, String data) {
		nd.setDeanNotice(sendID, receiveID, title, content, data);
	}

	@Override
	public List<Notice> getNotices(int role, int num) {
		List<Notice> ln = new LinkedList<Notice>();
		ln = nd.getNotices(role, num);
		return ln;
	}

}
