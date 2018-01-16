package com.zr.service;

import net.sf.json.JSONObject;

public interface ReplyService {
	public JSONObject getReplys(int page, int pageSize);

	public void addReply(String reply_site, int sub_id, String reply_start, String reply_end, int e_id);

	public void deleteReply(int reply_id);

	public void alertReply(int reply_id,String reply_site, int sub_id, String reply_start, String reply_end, int e_id);

	public int getEidByEname(String e_name);

	public int getSubidByEid(int e_id);

	
}
