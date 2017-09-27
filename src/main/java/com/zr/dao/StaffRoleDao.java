package com.zr.dao;
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

}
