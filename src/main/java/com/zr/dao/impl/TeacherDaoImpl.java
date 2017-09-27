<<<<<<< HEAD
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

import com.mysql.jdbc.PreparedStatement;
import com.zr.connection.DBConnection;
import com.zr.dao.TeacherDao;
import com.zr.model.Paper;
import com.zr.model.Student;
import com.zr.service.TeacherService;

import net.sf.json.JSONObject;

public class TeacherDaoImpl implements TeacherDao{
	@Override
	public JSONObject selectAllPapers() {
		JSONObject json = new JSONObject();
		List<Paper> list = new ArrayList<Paper>();
		StringBuffer sql = new StringBuffer();
		Connection con = DBConnection.getConnection();
       sql.append("select lw_name,s_id,lw_count ");
       sql.append("from paper");
     try {
		PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
		ResultSet rst = pst.executeQuery();
		while(rst.next()){
			Paper paper = new Paper();
			paper.setLwname(rst.getString("lw_name"));
			paper.setSid(rst.getInt("s_id"));
			paper.setLwcount(rst.getInt("lw_count"));
			list.add(paper);
			json.put("rows", list);
			
			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return json;
	}

	@Override
	public JSONObject selectAllScores(int eid) {
		JSONObject json = new JSONObject();
		List<Student> list = new ArrayList<Student>();
		StringBuffer sql = new StringBuffer();
		Connection con = DBConnection.getConnection();
       sql.append("select s.s_num,s.s_id,s.s_name,s.score ");
       sql.append("from student s ");
       sql.append("join sub b ");
       sql.append("on b.sub_id = s.sub_id ");
       sql.append("where b.e_id = ? ");
     try {
		PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
		pst.setInt(1, eid);
		ResultSet rst = pst.executeQuery();
		while(rst.next()){
			Student stu = new Student();
			stu.setSid(rst.getInt("s_id"));
			stu.setSname(rst.getString("s_name"));
			stu.setNum(rst.getInt("s_num"));
			stu.setScore(rst.getInt("score"));
			list.add(stu);
			json.put("rows", list);
			
			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return json;
	}

	@Override
	public void insertStudentScore(int sid, int score) {
		JSONObject json = new JSONObject();

		StringBuffer sql = new StringBuffer();
		Connection con = DBConnection.getConnection();
       sql.append("update student set score = ? ");
       sql.append("where s_id = ?");
      
     try {
		PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());	
		pst.setInt(1, score);
		pst.setInt(2, sid);
		pst.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
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

	@Override
	public int updateTeacher(int eid, String ename, int colid, int emnum) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("update staff ");
		sql.append("set e_name=?,e_col=?,e_num=? ");
		sql.append("where e_id=? ");
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			pst.setString(1, ename);
			pst.setInt(2, colid);
			pst.setInt(3, emnum);
			pst.setInt(4, eid);
			int i = pst.executeUpdate();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int insertTeacher(String ename, int colid, int emnum, String epsw) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("insert into staff (e_name,e_col,e_num,e_psw) ");
		sql.append("value (?,?,?,?) ");
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			pst.setString(1, ename);
			pst.setInt(2, colid);
			pst.setInt(3, emnum);
			pst.setString(4, epsw);
			int i = pst.executeUpdate();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int selectTeacherEidByEnum(int e_num) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("select e_id from staff where e_num=? ");
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			pst.setInt(1, e_num);
			ResultSet res = pst.executeQuery();
			if(res.next()){
				int eid = res.getInt("e_id");
				return eid;
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}	
}

=======
package com.zr.dao.impl;


import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.zr.connection.DBConnection;
import com.zr.dao.TeacherDao;
import com.zr.model.Paper;
import com.zr.model.Student;
import com.zr.service.TeacherService;

import net.sf.json.JSONObject;

public class TeacherDaoImpl implements TeacherDao{
	@Override
	public JSONObject selectAllPapers() {
		JSONObject json = new JSONObject();
		List<Paper> list = new ArrayList<Paper>();
		StringBuffer sql = new StringBuffer();
		Connection con = DBConnection.getConnection();
       sql.append("select lw_name,s_id,lw_count ");
       sql.append("from paper");
     try {
		PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
		ResultSet rst = pst.executeQuery();
		while(rst.next()){
			Paper paper = new Paper();
			paper.setLwname(rst.getString("lw_name"));
			paper.setSid(rst.getInt("s_id"));
			paper.setLwcount(rst.getInt("lw_count"));
			list.add(paper);
			json.put("rows", list);
			
			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return json;
	}

	@Override
	public JSONObject selectAllScores(int eid) {
		JSONObject json = new JSONObject();
		List<Student> list = new ArrayList<Student>();
		StringBuffer sql = new StringBuffer();
		Connection con = DBConnection.getConnection();
       sql.append("select s.s_num,s.s_id,s.s_name,s.score ");
       sql.append("from student s ");
       sql.append("join sub b ");
       sql.append("on b.sub_id = s.sub_id ");
       sql.append("where b.e_id = ? ");
     try {
		PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
		pst.setInt(1, eid);
		ResultSet rst = pst.executeQuery();
		while(rst.next()){
			Student stu = new Student();
			stu.setSid(rst.getInt("s_id"));
			stu.setSname(rst.getString("s_name"));
			stu.setNum(rst.getInt("s_num"));
			stu.setScore(rst.getInt("score"));
			list.add(stu);
			json.put("rows", list);
			
			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return json;
	}

	@Override
	public void insertStudentScore(int sid, int score) {
		JSONObject json = new JSONObject();
		
		StringBuffer sql = new StringBuffer();
		Connection con = DBConnection.getConnection();
       sql.append("update student set score = ? ");
       sql.append("where s_id = ?");
      
     try {
		PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());	
		pst.setInt(1, score);
		pst.setInt(2, sid);
		pst.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	}
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
>>>>>>> edb45fe6cd0177f620b12cff36781fe446007bbd
