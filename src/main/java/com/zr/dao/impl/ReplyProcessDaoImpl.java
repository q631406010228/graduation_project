package com.zr.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.zr.connection.DBConnection;
import com.zr.dao.ReplyProcessDao;
import com.zr.model.ReplyProcess;
/**
 * 
 * @author 欧小峰
 *
 */
public class ReplyProcessDaoImpl implements ReplyProcessDao{

	@Override
	public List<ReplyProcess> selectReplyProcess(int eid) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("select reply_process.s_id,sub.sub_name,s_name,ques,answer from reply_process,student,sub  ");
		sql.append("where reply_process.s_id = student.s_id and student.sub_id = sub.sub_id ");
		sql.append("and sub.e_id = ? ");
		List<ReplyProcess> list = new ArrayList<ReplyProcess>();
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			pst.setInt(1, eid);
			ResultSet res = pst.executeQuery();
			while(res.next()){
				ReplyProcess rp = new ReplyProcess();
				rp.setSid(res.getInt("s_id"));
				rp.setSname(res.getString("s_name"));
				rp.setSubname(res.getString("sub_name"));
				rp.setQues(res.getString("ques"));
				rp.setAnswer(res.getString("answer"));
				list.add(rp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int selectReplyProcessAcount(int eid) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer("");
		sql.append("select count(reply_process.s_id) as rp_count from reply_process,student,sub  ");
		sql.append("where reply_process.s_id = student.s_id and student.sub_id = sub.sub_id ");
		sql.append("and sub.e_id = ? ");
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			pst.setInt(1, eid);
			ResultSet res = pst.executeQuery();
			if(res.next()){
				int count = res.getInt("rp_count");
				return count;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteReplyProcess(int sid) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("delete from reply_process ");
		sql.append("where s_id=? ");
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			pst.setInt(1, sid);
			int i = pst.executeUpdate();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int insertReplyProcess(int sid, String ques, String answer) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("insert into reply_process (ques,answer,s_id) ");
		sql.append("value (?,?,?) ");
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			pst.setString(1, ques);
			pst.setString(2, answer);
			pst.setInt(3, sid);
			int i = pst.executeUpdate();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateReplyProcess(int sid, String ques, String answer) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("update reply_process ");
		sql.append("set ques=?,answer=? ");
		sql.append("where s_id=? ");
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			pst.setString(1, ques);
			pst.setString(2, answer);
			pst.setInt(3, sid);
			int i = pst.executeUpdate();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
