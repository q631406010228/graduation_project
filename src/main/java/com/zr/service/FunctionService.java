package com.zr.service;

import net.sf.json.JSONArray;

/** 
* @author SkySK: 
* @version 创建时间：2017年9月25日 上午2:50:31 
* 说明 ：
*/
public interface FunctionService {
	JSONArray getAllFunction(int pid);

	/**
	 * 获取用户对应的方法树
	 */
	public JSONArray getStaffFunction(int e_id,int rid);

      
}
