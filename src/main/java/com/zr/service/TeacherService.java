package com.zr.service;

import java.util.List;

import com.zr.model.Staff;

import net.sf.json.JSONObject;

public interface TeacherService {
	
	/**

	 * 获取学生答辩成绩
	 * @return json数据对象
	 */
    public JSONObject getScoresOfStu(int eid,int page,int pageSize);
    
   /**
    * 添加学生成绩    
    * @param snum 学生学号
    * @param sname 学生姓名
    * @param score  成绩
    */
    public void alterStudentScore(int sid ,int score);
    /**
	 * 查看答辩任务
	 * @return
	 */
	public JSONObject showReplymisson();



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
	public List<Integer> deleteTeacher(List<Integer> eids);
	/**
	 * 获取学生学号
	 *  @return
	 */
	public String getSnum(int id);
	
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
	 * 通过老师id获取其所有学生的id
	 * @param eid
	 * @return
	 */
	public int[] getSidsOfStudentByEid(int eid);
	
	/**
	 * 获取学生论文
	 */
	public void insertStudentPapers();
	
	/**
	 * 获取学生论文信息
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public JSONObject showPapersofStudent(int eid,int page,int pageSize);
    

}
