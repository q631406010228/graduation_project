package com.zr.service;

import java.util.List;

import com.zr.model.GraduationProcess;

public interface GraduationProcessService {

	public void setGraduationProcess(String gpContent,String graStartTime,String graEndTime);
	
	public List<GraduationProcess> getGraduationProcess();
	
}
