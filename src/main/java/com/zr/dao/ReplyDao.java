package com.zr.dao;

import java.util.List;

import com.zr.model.Replys;

public interface ReplyDao {

	public int getReplyCount();

	public List<Replys> getReplys(int i, int pageSize);

	public void addReply(String reply_site,int sub_id,String reply_start,String reply_end,int e_id);

	public void deleteReply(int reply_id);

	public void alertReply(int reply_id,String reply_site, int sub_id, String reply_start, String reply_end, int e_id);


}
