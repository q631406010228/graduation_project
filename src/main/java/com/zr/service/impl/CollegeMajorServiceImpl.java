package com.zr.service.impl;

import com.zr.dao.CollegeMajorDao;
import com.zr.dao.impl.CollegeMajorDaoImpl;
import com.zr.service.CollegeMajorService;

import net.sf.json.JSONArray;

public class CollegeMajorServiceImpl implements CollegeMajorService{
	
	CollegeMajorDao cmd = new CollegeMajorDaoImpl();

	@Override
	public JSONArray getMajors(int cID) {
		JSONArray major = cmd.getMajors(cID);
		return major;
	}

	@Override
	public JSONArray getCollege() {
		JSONArray college = cmd.getCollege();
		return college;
	}
	
	

}
