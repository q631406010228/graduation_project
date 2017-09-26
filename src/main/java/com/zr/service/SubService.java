
package com.zr.service;

import com.zr.model.Sub;

public interface SubService {
	/**
	 * 选题申报
	 * @param subname 课题名称
	 * @param subcontent 课题描述
	 * @param subcount 课题容量
	 * @param eid 提交教师ID
	 * @param state 课题状态
	 * @return 是否成功的标志位
	 */
	public int addSub(String subname,String subcontent,int subcount,int eid,int state);
	/**
	 * 根据教师查询选题申报
	 * @param eid 教师ID
	 * @return 选题申报（sub）对象
	 */
	public Sub selectSubByEid(int eid);
}
