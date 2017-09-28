package com.zr.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zr.connection.DBConnection;
import com.zr.dao.StaffDao;
import com.zr.model.Staff;

/** 
* @author SkySK: 
* @version 创建时间：2017年9月25日 上午1:14:26 
* 说明 ：
*/
public class StaffDaoImpl implements StaffDao {


	@Override
	public Staff getStaff(String ename, String epsw) {
		System.out.println("进入StaffDaoImpl。getStaff方法 ，获取 参数ename：" + ename + "和epsw：" + epsw);
		// 创建职工对象
		Staff staff = new Staff();
		// 定义数据库语句
		StringBuffer sql = new StringBuffer("");
		sql.append("select e_id,e_name,e_psw,e_col ");
		sql.append("from staff ");
		sql.append("where e_num=? ");
		// 创建数据库连接
		Connection con = DBConnection.getConnection();
		try {
			// 进行数据库语句预编译
			PreparedStatement pst = con.prepareStatement(sql.toString());
			// 为数据库语句赋值
			pst.setString(1, ename);

			// 获取查询后的结果
			ResultSet re = pst.executeQuery();
			if (re.next()) {

				int e_id = re.getInt("e_id");
				staff.setEid(e_id);
				String e_name = re.getString("e_name");
				staff.setEname(e_name);
				String e_psw = re.getString("e_psw");
				staff.setEpsw(e_psw);
				int c_id = re.getInt("e_col");
				staff.setEcol(c_id);
				System.out.println("数据库中获取的结果e_id:" + e_id + " e_name:" + e_name + " e_psw:" + e_psw+"c_id"+c_id);
			}
			// 将职工对象返回
			return staff;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
