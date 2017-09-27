package com.zr.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zr.connection.DBConnection;
import com.zr.dao.CollegeMajorDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class CollegeMajorDaoImpl implements CollegeMajorDao{

	@Override
	public JSONArray getMajors(int cID) {
		JSONArray majors = new JSONArray();
		Connection con = DBConnection.getConnection();
		StringBuffer sql = new StringBuffer("select * from major where c_id = ? ");
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setInt(1, cID);
			ResultSet rs = pst.executeQuery();
			int i = 0;
			while (rs.next()) {
				JSONObject major = new JSONObject();
				major.put("id", rs.getInt("m_id"));
				major.put("text", rs.getString("m_name"));
				if(i == 0){
					major.put("selected", true);
					i++;
				}
				majors.add(major);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return majors;
	}

	@Override
	public JSONArray getCollege() {
		JSONArray colleges = new JSONArray();
		Connection con = DBConnection.getConnection();
		StringBuffer sql = new StringBuffer("select * from college ");
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			ResultSet rs = pst.executeQuery();
			int i = 0;
			while (rs.next()) {
				JSONObject college = new JSONObject();
				college.put("id", rs.getInt("c_id"));
				college.put("text", rs.getString("c_name"));
				if(i == 0){
					college.put("selected", true);
					i++;
				}
				colleges.add(college);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return colleges;
	}

	

}
