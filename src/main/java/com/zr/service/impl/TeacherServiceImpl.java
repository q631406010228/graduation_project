package com.zr.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.zr.dao.SubDao;
import com.zr.dao.TeacherDao;
import com.zr.dao.impl.SubDaoImpl;
import com.zr.dao.impl.TeacherDaoImpl;
import com.zr.model.Staff;
import com.zr.service.TeacherService;

import net.sf.json.JSONObject;

public class TeacherServiceImpl implements TeacherService{
	TeacherDao tdao = new TeacherDaoImpl();
	SubDao subdao = new SubDaoImpl();
	@Override
	public JSONObject getPapers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Staff> selectTeacher() {
		// TODO Auto-generated method stub
		List<Staff> list = tdao.selectTeacher();
		return list;
	}

	@Override
	public int selectTeacherCount() {
		// TODO Auto-generated method stub
		int count = tdao.selectTeacherCount();
		return count;
	}

	@Override
	public List<Integer> deleteTeacher(List<Integer> eids) {
		// TODO Auto-generated method stub
		List <Integer> flag = new ArrayList<Integer>();
		for (int i = 0; i < eids.size(); i++) {
			//int fla = tdao.deleteTeacherRole(eids.get(i));
			//int f = subdao.deleteSub(eids.get(i));
			//System.out.println(f);
			flag.add( tdao.deleteTeacher(eids.get(i)));
		}
		return flag;
	}

}
