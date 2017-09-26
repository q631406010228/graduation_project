package com.zr.serviceimpl;

import com.zr.dao.StaffDao;
import com.zr.daoimpl.StaffDaoImpl;
import com.zr.model.Staff;
import com.zr.service.ValidateService;

/** 
* @author SkySK: 
* @version 创建时间：2017年9月25日 上午1:07:31 
* 说明 ：
*/
public class ValidateServiceImpl implements ValidateService {
	StaffDao dao = new StaffDaoImpl();

	@Override
	public Staff validateStaff(String ename, String epsw) {
		Staff staff = dao.getStaff(ename, epsw);
		// TODO Auto-generated method stub
		return staff;
	}

}

