package com.zr.service;

import net.sf.json.JSONObject;

public interface TeacherService {
	/**
	 * 获取学生所有论文
	 * @return json数据对象
	 */
	public JSONObject getPapers();
	/**
	 * 获取学生答辩成绩
	 * @return json数据对象
	 */
    public JSONObject getScoresOfStu(int eid);
    
   /**
    * 添加学生成绩    
    * @param snum 学生学号
    * @param sname 学生姓名
    * @param score  成绩
    */
    public void alterStudentScore(int sid ,int score);
}
