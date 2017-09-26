package com.zr.dao;

import net.sf.json.JSONArray;

public interface SubDao {
	public int insertSub(String subname,String subcontent,int subcount,int eid,int state);
	/**
	 * 通过专业id 获取全部该专业的教师毕设课题
	 * @param e_col 专业id
	 * @return
	 */
	public JSONArray selectSubByTeacherEcol(int e_col);
}
