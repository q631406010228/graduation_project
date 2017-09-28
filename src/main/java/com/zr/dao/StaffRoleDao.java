package com.zr.dao;

import java.util.List;

import com.zr.model.Subject;

/** 
* @author SkySK: 
* @version 创建时间：2017年9月26日 下午5:31:38 
* 说明 ：
*/
public interface StaffRoleDao {
	/**
	 * 通过用户id获取用户的角色id
	 * 
	 * @param e_id
	 *            用户id
	 * @return 用户的角色id
	 */
	public int getRidByEid(int e_id);
	
	/**
	 * 添加系主任角色
	 * @param eid
	 */
	public void insertDeanRole(int eid);
	
	/**
	 * 删除指定系主任
	 */
	public void deleteDeanRole(int[] eid);
	/**
	 * 添加教师角色
	 * @param eid
	 */
	public void insertTeacerRole(int eid);
	

}
