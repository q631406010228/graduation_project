package com.zr.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import javax.xml.crypto.Data;

import com.zr.connection.DBConnection;
import com.zr.dao.NoticeDao;
import com.zr.model.Notice;
import com.zr.model.Notice;

public class NoticeDaoImpl implements NoticeDao{

	@Override
	public void setDeanNotice(int sendID, int receiveID, String title, String content, String data) {
		Connection conn = DBConnection.getConnection();
		StringBuffer s = new StringBuffer();
		s.append("insert into notice(send_id,receive_role_id,title,content,`data`) values(?,?,?,?,?);");
		try {
			PreparedStatement ps = conn.prepareStatement(s.toString());
			ps.setInt(1, 1);
			ps.setInt(2, receiveID);
			ps.setString(3, title);
			ps.setString(4, content);
			ps.setString(5, data);
			ps.executeUpdate();	
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	@Override
	public List<Notice> getNotices(int role,int num) {
		List<Notice> ns = new LinkedList<Notice>();
		Connection conn = DBConnection.getConnection();
		StringBuffer s = new StringBuffer();
		s.append("select * from notice "); 
		s.append("where receive_role_id = ? and (receive_num is null or receive_num = ?);");
		try {
			PreparedStatement ps = conn.prepareStatement(s.toString());
			ps.setInt(1, role);
			ps.setInt(2, num);
			ResultSet re = ps.executeQuery();		
			while(re.next()){
				Notice n = new Notice();
				n.setTitle(re.getString("title"));
				n.setContent(re.getString("content"));
				n.setData(re.getString("data"));
				ns.add(n);
			}	
			ps.close();
			re.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return ns;
	}

	@Override
	public void setTeacherNotice(int sendID, int receiveID, String title, String content, String data, int[] num) {
		Connection conn = DBConnection.getConnection();
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}	//禁止自动提交
		StringBuffer s = new StringBuffer();
		s.append("insert into notice(send_id,receive_role_id,title,content,`data`,receive_num) values(?,?,?,?,?,?);");
		try {
			PreparedStatement ps = conn.prepareStatement(s.toString());
			for(int i = 0;i < num.length;i++){
				ps.setInt(1, 2);	//在session找教师角色表的id）
				ps.setInt(2, 2);	//固定发给学生角色
				ps.setString(3, title);
				ps.setString(4, content);
				ps.setString(5, data);
				ps.setInt(6, num[i]);
				ps.addBatch();	
			}
		
			ps.executeBatch();	//批量执行上面的语句
			conn.commit();		//一起提交	
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

}
