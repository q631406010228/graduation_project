package com.zr.serviceimpl;

import com.zr.dao.FunctionDao;
import com.zr.dao.RoleDao;
import com.zr.dao.StaffRoleDao;
import com.zr.daoimpl.FunctionDaoImpl;
import com.zr.daoimpl.RoleDaoImpl;
import com.zr.daoimpl.StaffRoleDaoImpl;
import com.zr.service.FunctionService;

import net.sf.json.JSONArray;

/**
 * @author SkySK:
 * @version 创建时间：2017年9月25日 上午2:50:47 说明 ：
 */
public class FunctionServiceImpl implements FunctionService {
	FunctionDao fdao = new FunctionDaoImpl();

	@Override
	public JSONArray getStaffFunction(int e_id,int rid) {
		int r_id=0;
		//判断rid是否为空
	if (rid!=0) {
		//是学生
		r_id=rid;
	} else {
		// 通过e_id在staff_role 中找出r_id
				StaffRoleDao srdao = new StaffRoleDaoImpl();
				 r_id = srdao.getRidByEid(e_id);
	}
	// 通过r_id,在role中的获取fids
	RoleDao rdao = new RoleDaoImpl();
	String fids = rdao.getfidsByRid(r_id);
	// 通过fids获取方法树

	JSONArray j = fdao.getCurrentAllfunctionObject(-1, fids);
	System.out.println("FunctionServiceImpl.getStaffFunction.JSONArray" + j);
	return j;

	}

	@Override
	public JSONArray getAllFunction(int pid) {
		// TODO Auto-generated method stub
		// JSONArray j = fdao.getCurrentAllFuncsByParetId(pid);
		// return j;
		return null;
	}
}
