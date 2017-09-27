package com.zr.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;

import com.mysql.jdbc.PreparedStatement;
import com.zr.connection.DBConnection;
import com.zr.dao.DeanDao;
import com.zr.model.Staff;
import com.zr.model.Staff;

public class DeanDaoImpl implements DeanDao{

	@Override
	public List<Staff> getDean() {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from staff s,staff_role sr,college c ");
		sql.append("where s.e_col = c.c_id and s.e_id = sr.e_id and sr.r_id = 3 ");
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
	public void updateDean(String ename, int ecol, int e_num,String epsw) {
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
			pst.setInt(5, 1);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
