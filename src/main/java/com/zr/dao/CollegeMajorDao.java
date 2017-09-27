package com.zr.dao;

import net.sf.json.JSONArray;

public interface CollegeMajorDao {
	
	/**
	 * 获得专业的信息
	 * @param cID	学院的id
	 * @return	返回专业的下拉框JSON值
	 */
	public JSONArray getMajors(int cID);
	
	/**
	 * 获得学院的信息
	 * @return	返回学院的下拉框JSON
	 */
	public JSONArray getCollege();

}
