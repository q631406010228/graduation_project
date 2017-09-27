package com.zr.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.zr.connection.DBConnection;
import com.zr.dao.TeacherDao;
import com.zr.model.Paper;
import com.zr.model.Reply;
import com.zr.model.Student;
import com.zr.service.TeacherService;

import net.sf.json.JSONObject;

public class TeacherDaoImpl implements TeacherDao {
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
			while (rst.next()) {
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
	public String getSnumBySid(int id) {
		StringBuffer sql = new StringBuffer();
		Connection con = DBConnection.getConnection();
		String s ="";
		int num;
		sql.append("select s_num from student ");
		sql.append("where s_id = ?");

		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			pst.setInt(1, id);
			ResultSet st = pst.executeQuery();
			while(st.next()){
				num=(st.getInt("s_num"));
			    s=""+num;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return s;
	}
}
