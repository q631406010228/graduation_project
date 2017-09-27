package com.zr.dao;

import com.zr.model.User;

/** 
* @author SkySK: 
* @version 创建时间：2017年9月26日 下午7:56:25 
* 说明 ：
*/
public interface UserDao {

	User getUser(Integer unum, String epsw);

    
}
