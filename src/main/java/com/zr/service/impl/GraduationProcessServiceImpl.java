package com.zr.service.impl;

import java.util.LinkedList;
import java.util.List;

import com.zr.model.GraduationProcess;
import com.zr.service.GraduationProcessService;

public class GraduationProcessServiceImpl implements GraduationProcessService{
	
	com.zr.dao.impl.GraduationProcessDaoImpl gpd = new com.zr.dao.impl.GraduationProcessDaoImpl();

	@Override
	public void setGraduationProcess(String gpContent, String graStartTime, String graEndTime,int cID) {
		gpd.setGraduationProcess(gpContent, graStartTime, graEndTime,cID);
	}

	@Override
	public List<GraduationProcess> getGraduationProcess(int cID) {
		List<GraduationProcess> gps = new LinkedList<GraduationProcess>();
		gps = gpd.getGraduationProcess(cID);
		return gps;
	}		

}
