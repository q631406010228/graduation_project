package com.zr.dao;

import java.util.List;

import com.zr.model.Staff;
import com.zr.model.Subject;

/** 
* @author SkySK: 
* @version 创建时间：2017年9月25日 上午1:13:13 
* 说明 ：
*/
public interface StaffDao {
	public Staff getStaff(String ename, String epsw);
	
	public int getSubjectCount();

	public List<Subject> getSubjects(int i, int pageSize);
	
	public void agreeSubject(int sub_id);

	public void returnSubject(int sub_id);

	public void deleteSubject(int sub_id);
}
