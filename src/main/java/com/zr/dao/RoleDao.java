package com.zr.dao;

import java.util.List;

import com.zr.model.Role;

/** 
* @author SkySK: 
* @version 创建时间：2017年9月25日 上午1:49:56 
* 说明 ：
*/
public interface RoleDao {

	List<Role> selectAllRole();

	String selectAllRole(int staffid);

	/**
	 * 通过用户的角色id获取用户的功能id
	 * 
	 * @param r_id
	 *            用户角色id
	 * @return 用户相应角色的功能id
	 */
	public String getfidsByRid(int r_id);

	String getStafffidsByStaffID(int staffid);
     

}
