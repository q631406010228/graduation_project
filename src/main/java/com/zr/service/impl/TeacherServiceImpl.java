package com.zr.service.impl;

import java.util.List;

import javax.websocket.Session;

import com.zr.dao.TeacherDao;
import com.zr.dao.impl.TeacherDaoImpl;
import com.zr.model.Staff;
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
	@Override
	public List<Staff> selectTeacher() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int selectTeacherCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<Integer> deleteTeacher(List<Integer> eids) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public JSONObject showReplymisson() {
		JSONObject json = tdao.checkReplyMisson();
		return json;
	}
	@Override
	public String getSnum(int id) {
		String s = tdao.getSnumBySid(id);
		return s;
	}
    
}
