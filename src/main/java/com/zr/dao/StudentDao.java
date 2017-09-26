package com.zr.dao;

import com.zr.model.Student;

/** 
* @author SkySK: 
* @version 创建时间：2017年9月26日 下午5:32:07 
* 说明 ：
*/
public interface StudentDao {
	Student getStudent(int snum, String spsw);
}
