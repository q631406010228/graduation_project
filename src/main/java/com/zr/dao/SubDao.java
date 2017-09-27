package com.zr.dao;
import com.zr.model.Sub;

import net.sf.json.JSONArray;
public interface SubDao {
	/**
	 * 选题申报
	 * @param subname 课题名称
	 * @param subcontent 课题描述
	 * @param subcount 课题容量
	 * @param eid 提交教师ID
	 * @param state 课题状态
	 * @return 是否成功的标志位
	 */
	public int insertSub(String subname,String subcontent,int subcount,int eid,int state);
	/**
	 * 根据教师查询选题申报
	 * @param eid 教师ID
	 * @return 选题申报（sub）对象
	 */
	public Sub selectSubByEid(int eid);
	/**
	 * 通过专业id 获取全部该专业的教师毕设课题
	 * @param e_col 专业id
	 * @return
	 */
	public JSONArray selectSubByTeacherEcol(int e_col);

	/**
	 * 删除选题
	 * @param eid 教师ID
	 * @return 是否成功的标志位
	 */
	public int deleteSub(int eid);
<<<<<<< HEAD
    /**
=======
	/**
>>>>>>> edb45fe6cd0177f620b12cff36781fe446007bbd
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

