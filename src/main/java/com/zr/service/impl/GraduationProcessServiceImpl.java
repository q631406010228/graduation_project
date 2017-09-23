package com.zr.service.impl;

import java.util.LinkedList;
import java.util.List;

import com.zr.model.GraduationProcess;
import com.zr.service.GraduationProcessService;

public class GraduationProcessServiceImpl implements GraduationProcessService{
	
	com.zr.dao.impl.GraduationProcessDaoImpl gpd = new com.zr.dao.impl.GraduationProcessDaoImpl();

	@Override
	public void setGraduationProcess(String gpContent, String graStartTime, String graEndTime) {
		gpd.setGraduationProcess(gpContent, graStartTime, graEndTime);
	}

	@Override
	public List<GraduationProcess> getGraduationProcess() {
		List<GraduationProcess> gps = new LinkedList<GraduationProcess>();
		gps = gpd.getGraduationProcess();
		return gps;
	}		

}
