package com.zr.service.impl;

import java.util.List;

import com.zr.dao.FuncDao;
import com.zr.dao.RoleDao;

import com.zr.dao.impl.FuncDaoImpl;
import com.zr.dao.impl.RoleDaoImpl;

import com.zr.service.RoleService;

import net.sf.json.JSONArray;

public class RoleServiceImpl implements  RoleService{
	FuncDao  fdao = new FuncDaoImpl();
	RoleDao  rdao = new RoleDaoImpl();

	
	

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
	
	public int getRidByUname(String uname){
		int a =rdao.getRidByUname(uname);
		
		return a;
	}
	@Override
	public String getFidsByRid(int rid) {
		// TODO Auto-generated method stub
		String s=fdao.getFidsByRid(rid);
		return s;
	}




	

}
