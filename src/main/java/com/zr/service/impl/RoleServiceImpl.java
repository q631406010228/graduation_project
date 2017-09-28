package com.zr.service.impl;

import com.zr.dao.FuncDao;
import com.zr.dao.RoleDao;
import com.zr.dao.impl.FuncDaoImpl;
import com.zr.dao.impl.RoleDaoImpl;
import com.zr.service.RoleService;

import net.sf.json.JSONArray;

/** 
* @author SkySK: 
* @version 创建时间：2017年9月25日 上午10:09:51 
* 说明 ：
*/
public class RoleServiceImpl implements RoleService {
	
	FuncDao  fdao = new FuncDaoImpl();
	RoleDao  rdao = new RoleDaoImpl();

	@Override
	public String getStafffids(int staffid) {
		// TODO Auto-generated method stub
		RoleDao rdao = new RoleDaoImpl();
		String staff_fid = rdao.getStafffidsByStaffID(staffid);
		System.out.println("RoleServiceImpl.getStafffids.staff_fid" + staff_fid);
		return staff_fid;
	}
	
	@Override
	public JSONArray getAllRoles(int parentId) {
		JSONArray   j =  fdao.getCurrentUserFuncsByParentId(parentId);
		return j;
	}
	public JSONArray getAllRoles2() {
		JSONArray   j =  fdao.getAllRoles2();
		return j;
	}
	@Override
	public JSONArray getuserRoles(int parentId, String fids) {
		JSONArray   j =  fdao.getCurrentUserFuncsByParentId1(parentId, fids);
		return j;
	}
	


	public int getRidByRname(String rname){
		int a =rdao.getRidByRname(rname);
		
		return a;
		
	}
	

	@Override
	public String getFidsByRid(int rid) {
		// TODO Auto-generated method stub
		String s=fdao.getFidsByRid(rid);
		return s;
	}

}
