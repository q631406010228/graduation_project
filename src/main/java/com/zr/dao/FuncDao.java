package com.zr.dao;

import net.sf.json.JSONArray;

public interface FuncDao {
		
	public JSONArray getfuncsByParentId(int parentId);
	
	
	public JSONArray getCurrentUserFuncsByParentId(int parentId);
	
	
	
	public JSONArray getfuncsByParentId1(int parentId,String fids);
	
	
	public JSONArray getCurrentUserFuncsByParentId1(int parentId,String fids);
	
	public String getFidsByRid(int rid);


	public JSONArray getAllRoles2();


	public void updatefunction(int a, String b);


	public JSONArray findParent();


	public void addFunc(String fname, String furl, String fcontent, int fpid);


	
}
