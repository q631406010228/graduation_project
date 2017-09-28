package com.zr.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.zr.dao.StaffRoleDao;
import com.zr.dao.SubDao;
import com.zr.dao.TeacherDao;
import com.zr.dao.impl.StaffRoleDaoImpl;
import com.zr.dao.impl.SubDaoImpl;

import java.util.List;

import javax.websocket.Session;

import com.zr.dao.TeacherDao;
import com.zr.dao.impl.TeacherDaoImpl;
import com.zr.model.Staff;
import com.zr.service.TeacherService;

import net.sf.json.JSONObject;

public class TeacherServiceImpl implements TeacherService {

	TeacherDao tdao = new TeacherDaoImpl();
	StaffRoleDao srdao = new StaffRoleDaoImpl();

	@Override
	public JSONObject getScoresOfStu(int eid) {

		JSONObject json = new JSONObject();
		json = tdao.selectAllScores(eid);
		return json;
	}

	@Override
	public void alterStudentScore(int sid, int score) {
		tdao.insertStudentScore(sid, score);

	}

	@Override
	public List<Staff> selectTeacher() {
		List<Staff> list = tdao.selectTeacher();
		return list;

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

	@Override
	public int selectTeacherCount() {
		// TODO Auto-generated method stub
		int count = tdao.selectTeacherCount();
		return count;
	}

	@Override
	public List<Integer> deleteTeacher(List<Integer> eids) {
		// TODO Auto-generated method stub
		List<Integer> flag = new ArrayList<Integer>();
		for (int i = 0; i < eids.size(); i++) {
			// int fla = tdao.deleteTeacherRole(eids.get(i));
			// int f = subdao.deleteSub(eids.get(i));
			// System.out.println(f);
			flag.add(tdao.deleteTeacher(eids.get(i)));
		}
		return flag;
	}

	@Override
	public int updateTeacher(int eid, String ename, int colid, int emnum) {
		// TODO Auto-generated method stub
		int i = tdao.updateTeacher(eid, ename, colid, emnum);
		return i;
	}

	@Override
	public int insertTeacher(String ename, int colid, int emnum, String epsw) {
		// TODO Auto-generated method stub
		int i = tdao.insertTeacher(ename, colid, emnum, epsw);
		int eid = tdao.selectTeacherEidByEnum(emnum);
		srdao.insertTeacerRole(eid);
		return i;
	}
}
