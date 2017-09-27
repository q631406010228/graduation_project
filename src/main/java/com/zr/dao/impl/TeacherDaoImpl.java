package com.zr.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.zr.connection.DBConnection;
import com.zr.dao.TeacherDao;
import com.zr.model.Staff;

public class TeacherDaoImpl implements TeacherDao{

	@Override
	public List<Staff> selectTeacher() {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("select a.e_id,a.e_name,a.e_col,b.c_name,a.e_num,a.e_psw ");
		sql.append("from staff a,college b,staff_role c ");
		sql.append("where a.e_col = b.c_id and a.e_id = c.e_id and c.r_id = 3");
		List<Staff> list = new ArrayList<Staff>();
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			ResultSet res = pst.executeQuery();
			while(res.next()){
				Staff sta = new Staff();
				sta.setEcol(res.getInt("e_col"));
				sta.setEcolname(res.getString("c_name"));
				sta.setEname(res.getString("e_name"));
				sta.setEid(res.getInt("e_id"));
				sta.setEmnum(res.getInt("e_num"));
				sta.setEpsw(res.getString("e_psw"));
				list.add(sta);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int selectTeacherCount() {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("select count(a.e_id)as t_count ");
		sql.append("from staff a,college b,staff_role c ");
		sql.append("where a.e_col = b.c_id and a.e_id = c.e_id and c.r_id = 3");
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			ResultSet res = pst.executeQuery();
			if(res.next()){
				int count = res.getInt("t_count");
				return count;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteTeacher(int eid) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("delete from staff ");
		sql.append("where e_id=? ");
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			pst.setInt(1, eid);
			int i = pst.executeUpdate();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteTeacherRole(int eid) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("delete from staff_role ");
		sql.append("where e_id=? ");
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			pst.setInt(1, eid);
			int i = pst.executeUpdate();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
}
