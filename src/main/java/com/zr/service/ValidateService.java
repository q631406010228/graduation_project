package com.zr.service;

import com.zr.model.Staff;

/** 
* @author SkySK: 
* @version 创建时间：2017年9月25日 上午1:06:01 
* 说明 ：根据教师的账户名和密码验证账户是否存在
* ename 老师账户名
* epsw  老师密码
*/
public interface ValidateService {

	public Staff validateStaff(String ename,String epsw);    
}
