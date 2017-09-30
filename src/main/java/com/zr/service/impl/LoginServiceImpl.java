package com.zr.service.impl;

import com.zr.dao.StaffDao;
import com.zr.dao.StudentDao;
import com.zr.dao.UserDao;
import com.zr.dao.impl.StaffDaoImpl;
import com.zr.dao.impl.StudentDaoImpl;
import com.zr.dao.impl.UserDaoImpl;
import com.zr.model.Staff;
import com.zr.model.Student;
import com.zr.model.User;
import com.zr.service.LoginService;

import net.sf.json.JSONObject;

/** 
* @author SkySK: 
* @version 创建时间：2017年9月26日 下午5:40:47 
* 说明 ：
*/
public class LoginServiceImpl implements LoginService {
	@Override
	public JSONObject getUserIdByUsernum(String user_type, String ename, String epsw) {
	/*	System.out.println(
				"进入LoginService。getUserIdByUsernum方法，获得的参数user_type：" + user_type + "ename " + ename + "epsw:" + epsw);*/
		// 创建各表对象
		Staff staff = new Staff();
		Student student = new Student();
		User user = new User();
		// 创建各个数据库对象
		// 职工
		StaffDao staffdao = new StaffDaoImpl();
		// 学生
	    StudentDao studentdao = new StudentDaoImpl();
		// 管理员
	    UserDao userdao = new UserDaoImpl();
		// 创建json对象
		JSONObject json = new JSONObject();
		// 判断用户类型
		if (user_type.equals("2")) {
			// 学生
			Integer snum = new Integer(ename);
			student = studentdao.getStudent(snum,epsw);
            //System.out.println("LoginServiceImpl学生中 "+student);
        	if (student.getSpsw()== null) {
				// 用户不存在
				json.put("ok", false);
				json.put("msg", "登录失败,用户不存在！");
			} else if (!student.getSpsw().equals(epsw)) {
				// 用户密码错误
				json.put("ok", false);
				json.put("msg", "登录失败,用户密码错误!");
			} else {
				// 信息匹配成功
				json.put("ok", true);
				json.put("c_id", student.getColid());
				json.put("r_id", 2);
				json.put("msg", "登录成功!");
				// 获取职工的id
				json.put("e_id", student.getSid());
			}
		} else if (user_type.equals("3")||(user_type.equals("4"))) {

			// 职工
			staff = staffdao.getStaff(ename, epsw);
			if (staff.getEpsw() == null) {
				// 用户不存在
				json.put("ok", false);
				json.put("msg", "登录失败,用户不存在！");
			} else if (!staff.getEpsw().equals(epsw)) {
				// 用户密码错误
				json.put("ok", false);
				json.put("msg", "登录失败,用户密码错误!");
			} else {
				// 信息匹配成功
				json.put("ok", true);
				json.put("c_id", staff.getEcol());
				json.put("msg", "登录成功!");
				// 获取职工的id
				json.put("e_id", staff.getEid());
				json.put("r_id", 0);

			}

		} else if (user_type.equals("1")) {
				// 管理员
				Integer unum = new Integer(ename);				
				user = userdao.getUser(unum,epsw);
	            //System.out.println("LoginServiceImpl管理员中 "+user);
	        	if (user.getUpsw()== null) {
					// 用户不存在
					json.put("ok", false);
					json.put("msg", "登录失败,用户不存在！");
				} else if (!user.getUpsw().equals(epsw)) {
					// 用户密码错误
					json.put("ok", false);
					json.put("msg", "登录失败,用户密码错误!");
				} else {
					// 信息匹配成功
					json.put("ok", true);
					json.put("r_id", user.getRid());
					json.put("msg", "登录成功!");
					// 获取职工的id
					json.put("e_id", user.getUid());
				}
			}
		//System.out.println("LoginService。getUserIdByUsernum方法返回的结果" + json);
		
		return json;
	}
}
