package com.zr.dao;

import com.zr.model.Staff;

/** 
* @author SkySK: 
* @version 创建时间：2017年9月25日 上午1:13:13 
* 说明 ：
*/
public interface StaffDao {
	public Staff getStaff(String ename, String epsw);
}
