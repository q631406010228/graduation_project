package com.zr.dao;

import net.sf.json.JSONObject;

public interface TeacherDao {
    
	/**
	 * 获取所有论文
	 * @return
	 */
	public JSONObject selectAllPapers();
	
	
	/**
	 * 获取所有成绩
	 * @return json数据对象
	 */
    public JSONObject selectAllScores(int eid);
    
    /**
     * 添加学生成绩    
     * @param snum 学生学号
     * @param sname 学生姓名
     * @param score  成绩
     */
    public void insertStudentScore(int sid,int score);
    
    /**
     * 查看答辩任务
     * @return
     */
    public JSONObject checkReplyMisson();
     
    /**
     * 获取学生学号
     * @return
     */
    public String getSnumBySid(int id);
}
