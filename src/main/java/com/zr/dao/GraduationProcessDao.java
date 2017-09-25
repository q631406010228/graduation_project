package com.zr.dao;

import java.util.List;

import com.zr.model.GraduationProcess;

import net.sf.json.JSONArray;

public interface GraduationProcessDao {

	/**
	 * 保存毕业设计进程
	 * @param gpContent	内容
	 * @param graStartTime	开始时间
	 * @param graEndTime	结束时间
	 */
	public void setGraduationProcess(String gpContent,String graStartTime,String graEndTime);
	
	/**
	 * 获取毕业设计进程
	 * @return	毕业设计进程类的集合
	 */
	public List<GraduationProcess> getGraduationProcess();
	
}
