package com.zr.service;

import java.util.List;

import com.zr.model.GraduationProcess;

public interface GraduationProcessService {

	/**
	 * 保存毕业设计进程
	 * @param gpContent	内容
	 * @param graStartTime	开始时间
	 * @param graEndTime	结束时间
	 */
	public void setGraduationProcess(String gpContent,String graStartTime,String graEndTime,int cID);
	
	/**
	 * 获取毕业设计进程
	 * @return	毕业设计进程类的集合
	 */
	public List<GraduationProcess> getGraduationProcess(int cID);
	
}
