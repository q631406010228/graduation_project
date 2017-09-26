package com.zr.service;

import net.sf.json.JSONObject;

/** 
* @author SkySK: 
* @version 创建时间：2017年9月26日 下午5:37:59 
* 说明 ：
*/
public interface LoginService {
	public JSONObject getUserIdByUsernum(String user_type, String ename, String epsw);
}
