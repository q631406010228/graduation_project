package com.zr.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.zr.connection.DBConnection;
import com.zr.dao.StudentDao;
import com.zr.model.Student;

public class StudentDaoImpl implements StudentDao{

	@Override
	public List<Student> selectStudentByEid(int eid) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("select s_id,s_name from student,sub ");
		sql.append("where student.sub_id = sub.sub_id and sub.e_id =?");
		List<Student> list = new ArrayList<Student>();
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			pst.setInt(1, eid);
			ResultSet res = pst.executeQuery();
			while(res.next()){
				Student stu = new Student();
				stu.setSid(res.getInt("s_id"));
				stu.setSname(res.getString("s_name"));
				list.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
