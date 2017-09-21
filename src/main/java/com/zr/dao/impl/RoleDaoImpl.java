package com.zr.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zr.dao.RoleDao;
import com.zr.model.Role;
import com.zr.model.Teacher;
import com.zr.util.JDBCUtil;

public class RoleDaoImpl implements RoleDao{
	
	public List<String> getAllRolesname() {
		
		List<String> rolesname = new ArrayList<String>();
		String name;
		
		StringBuffer sql = new StringBuffer("");
		sql.append("SELECT  rname ");
		sql.append("FROM  t_role ");
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql.toString());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				name=rs.getString("rname");
				
			
				rolesname.add(name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.closeJDBC(pst, con);
		}

		return rolesname; 
}

	@Override
	public int getRidByRname(String rname) {
		int a[] = new int[1];
	
		
		StringBuffer sql = new StringBuffer("");
		sql.append("SELECT  rid ");
		sql.append("FROM  t_role ");
		sql.append("WHERE  rname=? ");
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql.toString());
			pst.setString(1, rname);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				a[0] = rs.getInt("rid");
			
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.closeJDBC(pst, con);
		}

		
		return a[0]; 
		
		
	}

	@Override
	public int getRidByUname(String uname) {
		int a[] = new int[1];
	
		
		StringBuffer sql = new StringBuffer("");
		sql.append("SELECT  rid ");
		sql.append("FROM  t_user ");
		sql.append("WHERE  uname=? ");
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql.toString());
			pst.setString(1, uname);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				a[0] = rs.getInt("rid");
			
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.closeJDBC(pst, con);
		}

		
		return a[0]; 
	}

	
	

	@Override
	public void addRole(String rname, String fids) {
		Role r = new Role();
		Connection con = JDBCUtil.getConnection();
		StringBuffer sql = new StringBuffer("");
		sql.append("INSERT INTO t_role ");
		sql.append("(rname,fids) ");
		sql.append("values(?,?) ");
		PreparedStatement pst = null;
		try {
			 pst = con.prepareStatement(sql.toString());
			pst.setString(1, rname);
			pst.setString(2, fids);
			
			 pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.closeJDBC(pst, con);
		}
		
	}

	@Override
	public void updateRole(String uname, int rid) {
		// TODO Auto-generated method stub
		Role r = new Role();
		Connection con = JDBCUtil.getConnection();
		StringBuffer sql = new StringBuffer("");
		sql.append("UPDATE  t_user ");
		sql.append("SET rid=? ");
		sql.append("WHERE uname=? ");
		PreparedStatement pst = null;
		try {
			 pst = con.prepareStatement(sql.toString());
			pst.setInt(1, rid);
			pst.setString(2, uname);
			
			 pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.closeJDBC(pst, con);
		}
		
	}
   }
