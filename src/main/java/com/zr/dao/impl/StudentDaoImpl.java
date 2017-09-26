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

	@Override
	public List<Student> selectStudentFormByEid(int eid) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("select a.s_num,a.c_id,a.m_id,a.s_id,a.s_psw,a.sub_id,a.s_name,b.c_name,c.m_name,d.sub_name ");
		sql.append("from student a,college b,major c,sub d ");
		sql.append("where a.c_id = b.c_id and a.m_id = c.m_id and b.c_id = c.c_id and a.sub_id = d.sub_id ");
		sql.append("and e_id=?");
		List<Student> list = new ArrayList<Student>();
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			pst.setInt(1, eid);
			ResultSet res = pst.executeQuery();
			while(res.next()){
				Student stu = new Student();
				stu.setNum(res.getInt("s_num"));
				stu.setSname(res.getString("s_name"));
				stu.setColname(res.getString("c_name"));
				stu.setMajname(res.getString("m_name"));
				stu.setSubname(res.getString("sub_name"));
				stu.setColid(res.getInt("c_id"));
				stu.setMajid(res.getInt("m_id"));
				stu.setSpsw(res.getString("s_psw"));
				stu.setSubid(res.getInt("sub_id"));
				list.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public boolean setSubidBySid(int sub_id, int s_id) {
		System.out.println("进入StudentDaoImpl.setSubidBySid,sub_id="+sub_id+"s_id="+s_id);
		Connection con = DBConnection.getConnection();
		//定义数据库语句
		StringBuffer sql = new StringBuffer();
		sql.append("update student set sub_id =?");
		sql.append(" where s_id =?");
		try {
			//预编译
			PreparedStatement pre = (PreparedStatement)con.prepareStatement(sql.toString());
			//赋值
			pre.setInt(1, sub_id);
			pre.setInt(2, s_id);
			//获取结果
			int i= pre.executeUpdate();
			if(i==1){
				System.out.println("获取结果(1为成功)StudentDaoImpl.setSubidBySid.i="+i);
				con.close();
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	@Override
	public Integer getStudentNumberBySubid(int sub_id){
		Connection con = DBConnection.getConnection();
		//定义数据库语句
		StringBuffer sql = new StringBuffer();
		sql.append("select COUNT(s_id)as number ");
		sql.append("from student");
		sql.append(" where sub_id=? ");
		try {
			//预编译
			PreparedStatement pre =(PreparedStatement)con.prepareStatement(sql.toString());
			//赋值
			pre.setInt(1, sub_id);
			//获取值
			ResultSet set = pre.executeQuery();
			if(set.next()){
				Integer i =set.getInt("number");
				System.out.println("选择该课题的人数StudentDaoImpl.getStudentNumberBySubid.i="+i);
				return i;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
