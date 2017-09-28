package com.zr.service;

import net.sf.json.JSONArray;

/** 
* @author SkySK: 
* @version 创建时间：2017年9月25日 上午10:09:33 
* 说明 ：
*/
public interface RoleService {

	String getStafffids(int staffid);
	
	/**
	 * 获取所有的功能
	 * @return  对应的功能json数组
	 */
	public JSONArray   getAllRoles(int parentId);
	
	public JSONArray getAllRoles2();
	
	
	
	//  -1 123456  -1 1245
	public JSONArray   getuserRoles(int parentId,String fids);



	public int getRidByRname(String rname);
	

	
	public String getFidsByRid(int rid);

}
