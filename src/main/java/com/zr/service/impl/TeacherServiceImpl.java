package com.zr.service.impl;

import javax.websocket.Session;

import com.zr.dao.TeacherDao;
import com.zr.dao.impl.TeacherDaoImpl;
import com.zr.service.TeacherService;

import net.sf.json.JSONObject;

public class TeacherServiceImpl implements TeacherService{
     TeacherDao  tdao = new  TeacherDaoImpl();
	@Override
	public JSONObject getPapers() {
		JSONObject json = tdao.selectAllPapers();
		return json;
	}
	@Override
	public JSONObject getScoresOfStu(int eid) {
		
		
		JSONObject json = new JSONObject();
		json = tdao.selectAllScores(eid);
		return json;
	}
	@Override
	public void alterStudentScore(int sid, int score) {
		tdao.insertStudentScore(sid,score);
	
	}
    
}
