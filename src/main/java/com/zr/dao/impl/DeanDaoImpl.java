package com.zr.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.zr.connection.DBConnection;
import com.zr.dao.DeanDao;
import com.zr.model.Staff;

public class DeanDaoImpl implements DeanDao{

	@Override
	public List<Staff> getDean() {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from staff s,staff_role sr,college c ");
		sql.append("where s.e_col = c.c_id and s.e_id = sr.e_id and sr.r_id = 4 ");
		List<Staff> list = new ArrayList<Staff>();
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			ResultSet res = pst.executeQuery();
			while(res.next()){
				Staff s = new Staff();
				s.setEmnum(res.getInt("e_num"));
				s.setEid(res.getInt("e_id"));				
				s.setEname(res.getString("e_name"));				
				s.setEcol(res.getInt("e_col"));				
				s.setCname(res.getString("c_name"));
				s.setEpsw(res.getString("e_psw"));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void updateDean(String ename, int ecol, int e_num,String epsw,int eid) {
		StringBuffer sql = new StringBuffer();
		sql.append("update staff   ");
		sql.append("set e_name = ?,e_col = ?,e_num = ?,e_psw = ? where e_id = ?;");
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			pst.setString(1, ename);
			pst.setInt(2, ecol);
			pst.setInt(3, e_num);
			pst.setString(4, epsw);
			pst.setInt(5, eid);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertDean(String ename, int ecol, int e_num) {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into staff(e_name,e_col,e_num,e_psw)  ");
		sql.append("values(?,?,?,?);");
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			pst.setString(1, ename);
			pst.setInt(2, ecol);
			pst.setInt(3, e_num);
			pst.setInt(4, 123);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteDean(int[] eid) {
		Connection conn = DBConnection.getConnection();
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}	//禁止自动提交
		StringBuffer s = new StringBuffer();
		s.append("delete from staff where e_id = ?;");
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

	@Override
	public int getDean(int num) {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from staff ");
		sql.append("where e_num = ?");
		int eid = 0;
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			pst.setInt(1, num);
			ResultSet res = pst.executeQuery();
			while(res.next()){
				eid = res.getInt("e_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eid;
	}

	@Override
	public void deleteDeanRole(int num) {
		Connection conn = DBConnection.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("call deleteDeanRole(?);");
		try {
			CallableStatement cst = conn.prepareCall(sql.toString());
			cst.setInt(1, num);
			cst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
