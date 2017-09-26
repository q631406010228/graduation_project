package com.zr.serviceimpl;

import com.zr.dao.StaffDao;
import com.zr.dao.StudentDao;
import com.zr.daoimpl.StaffDaoImpl;
import com.zr.daoimpl.StudentDaoImpl;
import com.zr.model.Staff;
import com.zr.model.Student;

import net.sf.json.JSONObject;

/** 
* @author SkySK: 
* @version 创建时间：2017年9月26日 下午5:40:47 
* 说明 ：
*/
public class LoginServiceImpl {
	public JSONObject getUserIdByUsernum(String user_type, String ename, String epsw) {
		System.out.println(
				"进入LoginService。getUserIdByUsernum方法，获得的参数user_type：" + user_type + "ename " + ename + "epsw:" + epsw);
		// 创建各表对象
		Staff staff = new Staff();
		Student student = new Student();
		// 创建各个数据库对象
		// 职工
		StaffDao staffdao = new StaffDaoImpl();
		// 学生
	    StudentDao studentdao = new StudentDaoImpl();
		// 管理员
	    //UserDao userdao = new UserDaoImpl();
		// 创建json对象
		JSONObject json = new JSONObject();
		// 判断用户类型
		if (user_type.equals("2")) {
			// 学生
			Integer snum = new Integer(ename);
			student = studentdao.getStudent(snum,epsw);
            System.out.println("这个是在哪里啊 "+student);
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

		} else {
			// 管理员
		}
		System.out.println("LoginService。getUserIdByUsernum方法返回的结果" + json);
		return json;
	}
}
