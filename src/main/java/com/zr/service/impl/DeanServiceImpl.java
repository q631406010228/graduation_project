package com.zr.service.impl;

import java.util.LinkedList;
import java.util.List;

import com.zr.dao.DeanDao;
import com.zr.dao.StaffRoleDao;
import com.zr.dao.impl.DeanDaoImpl;
import com.zr.dao.impl.StaffDaoImpl;
import com.zr.dao.impl.StaffRoleDaoImpl;
import com.zr.model.Staff;
import com.zr.service.DeanService;

public class DeanServiceImpl implements DeanService {
	
	DeanDao dd = new DeanDaoImpl();
	StaffRoleDao srd = new StaffRoleDaoImpl();

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

	@Override
	public void insertDean(String ename, int ecol, int e_num) {
		dd.insertDean(ename, ecol, e_num);
		int eid = dd.getDean(e_num);
		srd.insertDeanRole(eid);		
	}

	@Override
	public void deleteDean(String eid) {
		String[] s = eid.split(",");
		int[] nums = new int[s.length];
		for(int i = 0;i < s.length;i++){
			nums[i] = Integer.parseInt(s[i]);
			dd.deleteDeanRole(nums[i]);		//循环调用存储过程进行事务管理
		}
		/*srd.deleteDeanRole(nums);
		dd.deleteDean(nums);*/		
	}

}
