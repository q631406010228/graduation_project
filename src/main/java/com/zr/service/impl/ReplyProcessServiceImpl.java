package com.zr.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.zr.dao.ReplyProcessDao;
import com.zr.dao.impl.ReplyProcessDaoImpl;
import com.zr.model.ReplyProcess;
import com.zr.service.ReplyProcessService;

/**
 * 答辩记录服务实现类
 * 
 * @author 欧小峰
 *
 */
public class ReplyProcessServiceImpl implements ReplyProcessService {
	ReplyProcessDao rpdao = new ReplyProcessDaoImpl();

	@Override
	public List<ReplyProcess> selectReplyProcess(int eid) {
		// TODO Auto-generated method stub
		List list = rpdao.selectReplyProcess(eid);
		return list;
	}

	@Override
	public int selectReplyProcessAcount(int eid) {
		// TODO Auto-generated method stub
		int count = rpdao.selectReplyProcessAcount(eid);

		return count;
	}

	@Override
	public List<Integer> deletReplyProcess(List<Integer> sid) {
		// TODO Auto-generated method stub
		List<Integer> flag = new ArrayList<>();
		for (int i = 0; i < sid.size(); i++) {
			flag.add(rpdao.deleteReplyProcess(sid.get(i)));
		}
		return flag;
	}

	@Override
	public int insertReplyProcess(int sid, String ques, String answer) {
		// TODO Auto-generated method stub
		int i = rpdao.insertReplyProcess(sid, ques, answer);
		return i;
	}

	@Override
	public int updateReplyProcess(int sid, String ques, String answer) {
		// TODO Auto-generated method stub
		int i = rpdao.updateReplyProcess(sid, ques, answer);
		return i;
	}

}