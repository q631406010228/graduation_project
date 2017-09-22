package com.zr.service;

import java.util.List;

import com.zr.model.ReplyProcess;
/**
 * 答辩记录服务类
 * @author 欧小峰
 *
 */
public interface ReplyProcessService {
	/**
	 * 查询所有答辩记录信息
	 * @param eid 教职工ID
	 * @return 返回答辩记录对象
	 */
	public List<ReplyProcess> selectReplyProcess(int eid);
	/**
	 * 查询答辩记录的条数
	 * @param eid 教职工ID
	 * @return 返回答辩记录数据条数
	 */
	public int selectReplyProcessAcount(int eid);
	/**
	 * 删除学生答辩过程记录
	 * @param sid 学生ID
	 * @return 是否成功的标志位
	 */
	public int[] deletReplyProcess(List<Integer> sid);
	/**
	 * 
	 * @param sid
	 * @param ques
	 * @param answer
	 * @return
	 */
	public int insertReplyProcess(int sid,String ques,String answer);
	/**
	 * 
	 * @param sid
	 * @param ques
	 * @param answer
	 * @return
	 */
	public int updateReplyProcess(int sid,String ques,String answer);
}
