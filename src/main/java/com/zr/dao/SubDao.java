package com.zr.dao;

import com.zr.model.Sub;

import net.sf.json.JSONArray;

public interface SubDao {
	public int insertSub(String subname,String subcontent,int subcount,int eid,int state);
	/**
	 * 通过专业id 获取全部该专业的教师毕设课题
	 * @param e_col 专业id
	 * @return
	 */
	public JSONArray selectSubByTeacherEcol(int e_col);
	/**
	 * 根据选题id 获取选题的最大容量及已选人数
	 * @param sub_id 选题的id
	 * @return 选题的最大容量以及已选人数
	 */
	public Sub getSelectnumSub_countBySubid(int sub_id);
	/**
	 * 通过学生选择统一选题id数，设置选题的已选人数
	 * @param number 学生选择统一选题id数
	 * @param sub_id 选题的id数
	 * @return 赋值的结果
	 */
	public boolean setSelectnumByStudentNum(int number,int sub_id);
}
