package com.zr.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zr.dao.StaffDao;
import com.zr.dao.impl.StaffDaoImpl;
import com.zr.model.Role;
import com.zr.service.StaffService;

import net.sf.json.JSONObject;

public class StaffServiceImpl implements  StaffService {

	StaffDao sdao=new StaffDaoImpl();
	
	public JSONObject getSubjects(int page, int pageSize) {
		JSONObject  j = new JSONObject();
		j.put("total", sdao.getSubjectCount());
		j.put("rows", sdao.getSubjects((page-1)*pageSize, pageSize));
		return j;
	}

	@Override
	public void agreeSubject(int sub_id) {
		sdao.agreeSubject(sub_id);
		
		
		
	}

	@Override
	public void returnSubject(int sub_id) {
		sdao.returnSubject(sub_id);
		
	}

	@Override
	public void deleteSubject(int sub_id) {
		// TODO Auto-generated method stub
		sdao.deleteSubject(sub_id);
		
	}
}
