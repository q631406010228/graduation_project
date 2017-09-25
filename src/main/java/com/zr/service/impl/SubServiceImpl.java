package com.zr.service.impl;

import com.zr.dao.SubDao;
import com.zr.dao.impl.SubDaoImpl;
import com.zr.service.SubService;

public class SubServiceImpl implements SubService{
	SubDao subdao = new SubDaoImpl();
	@Override
	public int addSub(String subname, String subcontent, int subcount, int eid, int state) {
		// TODO Auto-generated method stub
		int i = subdao.insertSub(subname, subcontent, subcount, eid, state);
		return i;
	}
	
}
