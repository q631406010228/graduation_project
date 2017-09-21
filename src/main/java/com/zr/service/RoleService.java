package com.zr.service;

import java.util.List;

import net.sf.json.JSONArray;

public interface RoleService {

	/**
	 * 获取所有的功能
	 * @return  对应的功能json数组
	 */
	public JSONArray   getAllRoles(int parentId);
	
	public JSONArray getAllRoles2();
	
	
	
	//  -1 123456  -1 1245
	public JSONArray   getuserRoles(int parentId,String fids);



	public int getRidByRname(String rname);
	
	public int getRidByUname(String uname);
	
	public String getFidsByRid(int rid);
	
	

	

	
}
