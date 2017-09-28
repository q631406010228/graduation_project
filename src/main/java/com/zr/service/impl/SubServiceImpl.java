package com.zr.service.impl;

import com.zr.dao.SubDao;
import com.zr.dao.impl.SubDaoImpl;

import com.zr.service.SubService;

import net.sf.json.JSONArray;

import com.zr.model.Sub;
import com.zr.service.SubService;

public class SubServiceImpl implements SubService {
	SubDao subdao = new SubDaoImpl();

	@Override
	public int addSub(String subname, String subcontent, int subcount, int eid, int state) {
		// TODO Auto-generated method stub
		int i = subdao.insertSub(subname, subcontent, subcount, eid, state);
		return i;
	}

	@Override
	public JSONArray selectSubBySid(int c_id) {
		// 通过学院id，来获取对应的全部信息
		JSONArray json_arr = new JSONArray();
		json_arr = subdao.selectSubByTeacherEcol(c_id);

		return null;
	}

	@Override
	public Sub selectSubByEid(int eid) {
		// TODO Auto-generated method stub
		Sub sub = subdao.selectSubByEid(eid);
		return sub;
	}

}
