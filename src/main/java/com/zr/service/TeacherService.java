package com.zr.service;

import java.util.List;

import com.zr.model.Staff;

import net.sf.json.JSONObject;

public interface TeacherService {
	/**
	 * 获取学生所有论文
	 * @return json数据对象
	 */
	public JSONObject getPapers();
	/**
<<<<<<< HEAD

=======
>>>>>>> 5409f170b06381a27c5d0d71e63dfa785200b51a
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

    /*

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

}
