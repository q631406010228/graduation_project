package com.zr.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zr.connection.DBConnection;
import com.zr.dao.RoleDao;
import com.zr.model.Role;

/** 
* @author SkySK: 
* @version 创建时间：2017年9月25日 上午1:51:15 
* 说明 ：
*/
public class RoleDaoImpl implements RoleDao {

	@Override
	public String getfidsByRid(int r_id) {
		System.out.println("RoleDaoImpl.getfidsByRid.r_id" + r_id);
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer("");
		sql.append("select fids from role ");
		sql.append("where r_id = ? ");
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setInt(1, r_id);
			ResultSet res = pst.executeQuery();
			if (res.next()) {
				String fids = res.getString("fids");
				System.out.println("RoleDaoImpl.getfidsByRid.fids" + fids);
				return fids;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Role> selectAllRole() {
		// TODO Auto-generated method stub
		List<Role> roles = new ArrayList<Role>();
		StringBuffer sql = new StringBuffer("");
		sql.append("select * from role ");
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				Role role = new Role();
				role.setRid(res.getInt("r_id"));
				role.setRname(res.getString("r_name"));
				role.setFids(res.getString("fids"));
				roles.add(role);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roles;
	}

	public int selectRoleIDbyRoleNname(String rolename) {
		StringBuffer sql = new StringBuffer();
		sql.append("select r_id ");
		sql.append("from role ");
		sql.append("where rolename=? ");
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, rolename);
			ResultSet res = pst.executeQuery();
			if (res.next()) {
				int roleid = res.getInt("roleid");
				return roleid;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;

	}

	@Override
	public String selectAllRole(int staffid) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer("");
		sql.append("select fids from role where r_id ");
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setInt(1, staffid);
			ResultSet res = pst.executeQuery();
			if (res.next()) {
				String fids = res.getString("fids");
				return fids;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int updateRoleFunction(int roleid, String fids) {
		StringBuffer sql = new StringBuffer();
		sql.append("update role set fids = ? where r_id = ? ");
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, fids);
			pst.setInt(2, roleid);
			int i = pst.executeUpdate();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	@Override
	public String getStafffidsByStaffID(int staffid) {
		// TODO Auto-generated method stub
		return null;
	}
	
public List<String> getAllRolesname() {
		
		List<String> rolesname = new ArrayList<String>();
		String name;
		
		StringBuffer sql = new StringBuffer("");
		sql.append("SELECT  r_name ");
		sql.append("FROM  role ");
		Connection con = DBConnection.getConnection();
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql.toString());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				name=rs.getString("r_name");
				
			
				rolesname.add(name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}

		return rolesname; 
}

	@Override
	public int getRidByRname(String rname) {
		int a[] = new int[1];
	
		
		StringBuffer sql = new StringBuffer("");
		sql.append("SELECT  r_d ");
		sql.append("FROM  role ");
		sql.append("WHERE  r_name=? ");
		Connection con = DBConnection.getConnection();
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql.toString());
			pst.setString(1, rname);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				a[0] = rs.getInt("r_id");
			
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}

		
		return a[0]; 
		
		
	}


}
