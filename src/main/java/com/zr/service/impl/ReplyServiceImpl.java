package com.zr.service.impl;

import com.zr.dao.ReplyDao;
import com.zr.dao.StaffDao;
import com.zr.dao.impl.ReplyDaoImpl;
import com.zr.dao.impl.StaffDaoImpl;
import com.zr.service.ReplyService;

import net.sf.json.JSONObject;

public class ReplyServiceImpl implements ReplyService {
	ReplyDao rdao = new ReplyDaoImpl();

	@Override
	public JSONObject getReplys(int page, int pageSize) {
		JSONObject j = new JSONObject();
		j.put("total", rdao.getReplyCount());
		j.put("rows", rdao.getReplys((page - 1) * pageSize, pageSize));
		return j;
	}

	@Override
	public void addReply(String reply_site, int sub_id, String reply_start, String reply_end, int e_id) {
		rdao.addReply(reply_site, sub_id, reply_start, reply_end, e_id);

	}

	@Override
	public void deleteReply(int reply_id) {
		// TODO Auto-generated method stub
		rdao.deleteReply(reply_id);
	}

	@Override
	public void alertReply(int reply_id, String reply_site, int sub_id, String reply_start, String reply_end,
			int e_id) {
		// TODO Auto-generated method stub
		rdao.alertReply(reply_id, reply_site, sub_id, reply_start, reply_end, e_id);
	}

}
