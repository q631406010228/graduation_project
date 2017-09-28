package com.zr.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zr.connection.DBConnection;
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
		Connection con = DBConnection.getConnection();
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

	@Override
	public void insertDeanRole(int eid) {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into staff_role(e_id,r_id)  ");
		sql.append("values(?,?);");
		System.out.println(eid);
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			pst.setInt(1, eid);
			pst.setInt(2, 4);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void insertTeacerRole(int eid) {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into staff_role(e_id,r_id)  ");
		sql.append("values(?,?);");
		System.out.println(eid);
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			pst.setInt(1, eid);
			pst.setInt(2, 3);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteDeanRole(int[] eid) {
		Connection conn = DBConnection.getConnection();
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}	//禁止自动提交
		StringBuffer s = new StringBuffer();
		s.append("delete from staff_role where e_id = ?;");
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(s.toString());
			for(int i = 0;i < eid.length;i++){
				ps.setInt(1, eid[i]);	
				ps.addBatch();	
			}	
			ps.executeBatch();	//批量执行上面的语句
			conn.commit();		//一起提交	
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}

