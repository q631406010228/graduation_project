
package com.zr.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.zr.connection.DBConnection;
import com.zr.dao.SubDao;
import com.zr.model.Sub;

public class SubDaoImpl implements SubDao{

	@Override
	public int insertSub(String subname, String subcontent, int subcount, int eid, int state) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("insert into sub (sub_name,sub_count,sub_content,sub_state,e_id) ");
		sql.append("value (?,?,?,?,?)");
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			pst.setString(1, subname);
			pst.setInt(2, subcount);
			pst.setString(3, subcontent);
			pst.setInt(4, state);
			pst.setInt(5, eid);
			int i = pst.executeUpdate();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Sub selectSubByEid(int eid) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		Sub sub = new Sub();
		sql.append("select sub_name,sub_count,sub_content,sub_state ");
		sql.append("from sub ");
		sql.append("where e_id=? ");
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			pst.setInt(1, eid);
			ResultSet res = pst.executeQuery();
			while(res.next()){
				sub.setSubcontent(res.getString("sub_content"));
				sub.setSubcount(res.getInt("sub_count"));
				sub.setSubname(res.getString("sub_name"));
				sub.setSubstate(res.getInt("sub_state"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sub;
	}

}

