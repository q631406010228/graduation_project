package com.zr.service.impl;

import java.util.List;

import com.zr.dao.CollegeMajorDao;
import com.zr.dao.StudentDao;
import com.zr.dao.impl.CollegeMajorDaoImpl;
import com.zr.dao.impl.StudentDaoImpl;
import com.zr.model.Student;
import com.zr.service.StudentService;

public class StudentServiceImpl implements StudentService{
	StudentDao studao = new StudentDaoImpl();
	@Override
	public List<Student> selectStudentByEid(int eid) {
		List list = studao.selectStudentByEid(eid);
		return list;
	}
	@Override
	public List<Student> selectStudentFormByEid(int eid) {
		List list = studao.selectStudentFormByEid(eid);
		return list;
	}
	@Override
	public List<Student> selectStudentAll() {
		List list = studao.selectStudentAll();
		return list;
	}

	@Override
	public void insertStudent(int num, String name, int cID, int mID) {
		studao.insertStudent(num, name, cID, mID);
	}
	@Override
	public void deleteStudent(String num) {
		String[] s = num.split(",");
		int[] nums = new int[s.length];
		for(int i = 0;i < s.length;i++){
			nums[i] = Integer.parseInt(s[i]);
		}
		studao.deleteStudent(nums);
	}
	@Override
	public void updateStudent(int num, String name, int cID, int mID, int preNum) {
		studao.updateStudent(num, name, cID, mID, preNum);
	}
	@Override
	public List<Integer> getStudentScore(int cid) {
		// TODO Auto-generated method stub
		List list = studao.getStudentScore(cid);
		return list;
	}

}
