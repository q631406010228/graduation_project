package com.zr.serviceimpl;

import com.zr.dao.RoleDao;
import com.zr.daoimpl.RoleDaoImpl;
import com.zr.service.RoleService;

/** 
* @author SkySK: 
* @version 创建时间：2017年9月25日 上午10:09:51 
* 说明 ：
*/
public class RoleServiceImpl implements RoleService {

	@Override
	public String getStafffids(int staffid) {
		// TODO Auto-generated method stub
		RoleDao rdao = new RoleDaoImpl();
		String staff_fid = rdao.getStafffidsByStaffID(staffid);
		System.out.println("RoleServiceImpl.getStafffids.staff_fid" + staff_fid);
		return staff_fid;
	}

}
