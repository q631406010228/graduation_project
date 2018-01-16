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

import com.zr.model.Reply;

import com.zr.model.Student;
import com.zr.service.TeacherService;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TeacherDaoImpl implements TeacherDao {

	

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
			while (rst.next()) {
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

     
		}catch (SQLException e) {
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
			while (res.next()) {
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
			if (res.next()) {
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
		int i=0;
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
			 i = pst.executeUpdate();
             return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;

	}

	@Override
	public JSONObject checkReplyMisson() {

		JSONObject json = new JSONObject();
		List<Reply> list = new ArrayList<Reply>();
		StringBuffer sql = new StringBuffer();
		Connection con = DBConnection.getConnection();
		sql.append("select r.reply_site,b.sub_name,r.reply_start ");
		sql.append("from reply r ");
		sql.append("join sub b ");
		sql.append("on b.sub_id = r.sub_id ");

		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());

			ResultSet rst = pst.executeQuery();
			while (rst.next()) {
				Reply re = new Reply();
				re.setReplysite(rst.getString("reply_site"));
				re.setSubname(rst.getString("sub_name"));
				re.setReplystart(rst.getString("reply_start"));

				list.add(re);
				json.put("rows", list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}

	@Override
	public int insertTeacher(String ename, int colid, int emnum, String epsw) {
		// TODO Auto-generated method stub
		int i =0;
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
			i = pst.executeUpdate();
			return i;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}

	@Override
	public String getSnumBySid(int id) {
		StringBuffer sql = new StringBuffer();
		Connection con = DBConnection.getConnection();
		String s = "";
		int num;
		sql.append("select s_num from student ");
		sql.append("where s_id = ?");

		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			pst.setInt(1, id);
			ResultSet st = pst.executeQuery();
			while (st.next()) {
				num = (st.getInt("s_num"));
				s = "" + num;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return s;
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
			if (res.next()) {
				int eid = res.getInt("e_id");
				return eid;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public JSONArray getAllTeachers() {
		// TODO Auto-generated method stub
		JSONArray   teachers =  new JSONArray();
		Connection  con   =  DBConnection.getConnection();
		StringBuffer  sql = new StringBuffer("select * from staff ");
		PreparedStatement   pst = null;
		try {
			   pst =  (PreparedStatement) con.prepareStatement(sql.toString());
			
			ResultSet  rs  =  pst.executeQuery();
			while(rs.next()){
				  JSONObject  teacher =  new JSONObject();
				  teacher.put("id", rs.getInt("e_id"));
				  teacher.put("text", rs.getString("e_name"));
				  
				  teachers.add(teacher);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DBConnection.closeJDBC(pst, con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return teachers;
	}
}
