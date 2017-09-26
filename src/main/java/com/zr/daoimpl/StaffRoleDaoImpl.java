package com.zr.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zr.connection.JDBCUtil;
import com.zr.dao.StaffRoleDao;

/** 
* @author SkySK: 
* @version 创建时间：2017年9月26日 下午5:34:09 
* 说明 ：
*/
public class StaffRoleDaoImpl implements StaffRoleDao {
	@Override
	public int getRidByEid(int e_id) {
		System.out.println("StaffRoleDaoImpl.getRidByEid.e_id" + e_id);
		StringBuffer sql = new StringBuffer();
		sql.append("select r_id from staff_role ");
		sql.append("where e_id = ? ");
		Connection con = JDBCUtil.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setInt(1, e_id);
			ResultSet res = pst.executeQuery();
			if (res.next()) {
				int r_id = res.getInt("r_id");
				System.out.println("StaffRoleDaoImpl.getRidByEid.r_id" + r_id);
				return r_id;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}

