package com.zr.dao;

import java.util.List;

public interface RoleDao {
	
	public List<String> getAllRolesname();

	public int getRidByRname(String rname);
	
	public int getRidByUname(String uname);
	

	
	public void addRole(String rname,String fids);

	public void updateRole(String uname, int rid);
}
