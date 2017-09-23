package com.zr.dao;

import java.util.List;

import com.zr.model.GraduationProcess;

import net.sf.json.JSONArray;

public interface GraduationProcessDao {

	public void setGraduationProcess(String gpContent,String graStartTime,String graEndTime);
	
	public List<GraduationProcess> getGraduationProcess();
	
}
