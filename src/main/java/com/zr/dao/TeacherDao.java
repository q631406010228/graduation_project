package com.zr.dao;


import java.util.List;

import com.zr.model.Staff;


import net.sf.json.JSONObject;

public interface TeacherDao {
    
	
	
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

    /**
	 * 查询教师信息
	 * @return 教师对象的集合
	 */
	public List<Staff> selectTeacher();
	/**
	 * 查询教师数据条数
	 * @return 教师数据条数
	 */
	public int selectTeacherCount();
	/**
	 * 删除教师信息
	 * @return 是否成功的标志位
	 */
	public int deleteTeacher(int eid);
	/**
	 * 删除教师角色
	 * @return 是否成功的标志位
	 */
	public int deleteTeacherRole(int eid);
	/**
	 * 修改教师信息
	 * @param eid 教师编号
	 * @param ename 教师姓名
	 * @param colid 学院号
	 * @param emnum 教师号
	 * @return 是否成功的标志位
	 */
	public int updateTeacher(int eid,String ename,int colid,int emnum);
	/**
	 * 添加教师
	 * @param ename 教师姓名
	 * @param colid 学院号
	 * @param emnum 教师号
	 * @param epsw 密码
	 * @return 是否成功的标志位
	 */
	public int insertTeacher(String ename,int colid,int emnum,String epsw);
	/**
	 * 根据教师号查询教师编号
	 * @param e_num 教师号
	 * @return 教师编号
	 */
	public int selectTeacherEidByEnum(int e_num);
}
