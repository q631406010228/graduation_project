package com.zr.service.impl;

import java.util.List;

import com.zr.dao.StudentDao;
import com.zr.dao.impl.StudentDaoImpl;
import com.zr.model.Student;
import com.zr.service.StudentService;

public class StudentServiceImpl implements StudentService{
	StudentDao studao = new StudentDaoImpl();
	@Override
	public List<Student> selectStudentByEid(int eid) {
		// TODO Auto-generated method stub
		List list = studao.selectStudentByEid(eid);
		return list;
	}

}
