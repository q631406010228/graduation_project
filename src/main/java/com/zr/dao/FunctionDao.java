package com.zr.dao;

import net.sf.json.JSONArray;

/** 
* @author SkySK: 
* @version 创建时间：2017年9月25日 上午2:57:49 
* 说明 ：
*/
public interface FunctionDao {
	public JSONArray getChildFunctionsObject(int parentNode, String functions);
	public JSONArray getCurrentAllfunctionObject(int parentNode, String functions) ;
	


}
