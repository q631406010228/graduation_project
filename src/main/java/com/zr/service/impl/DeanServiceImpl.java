package com.zr.service.impl;

import java.util.LinkedList;
import java.util.List;

import com.zr.dao.DeanDao;
import com.zr.dao.impl.DeanDaoImpl;
import com.zr.model.Staff;
import com.zr.service.DeanService;

public class DeanServiceImpl implements DeanService {
	
	DeanDao dd = new DeanDaoImpl();

	@Override
	public List<Staff> getDean() {
		List<Staff> ls = new LinkedList<>();
		ls = dd.getDean();
		return ls;
	}

	@Override
	public void updateDean(String ename, int ecol, int e_num,String epsw,int eid) {
		dd.updateDean(ename, ecol, e_num,epsw,eid);
	}

}
