package com.zr.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zr.connection.DBConnection;
import com.zr.dao.ReplyDao;
import com.zr.model.Replys;
import com.zr.model.Subject;
import com.zr.service.ReplyService;

public class ReplyDaoImpl implements ReplyDao{

	@Override
	public int getReplyCount() {
		// TODO Auto-generated method stub
		int p =0;
		Connection  con   =  DBConnection.getConnection();
		StringBuffer  sql = new StringBuffer("select count(reply_id) AS rcount from reply  ");
		PreparedStatement   pst = null;
		try {
			   pst =  con.prepareStatement(sql.toString());
			
			ResultSet  rs  =  pst.executeQuery();
			while(rs.next()){
				 
				  p=rs.getInt("rcount");
				 
				  
				  
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
		return p;
	}

	@Override
	public List<Replys> getReplys(int i, int pageSize) {
		// TODO Auto-generated method stub
List<Replys> replys = new ArrayList<Replys>();
		
		StringBuffer sql = new StringBuffer("");
		sql.append("SELECT reply.reply_id,reply.reply_site,reply.sub_id,sub.sub_name,reply_start,reply_end,sub.e_id,staff.e_name ");
		sql.append("FROM reply ");
		sql.append("INNER JOIN staff ON staff.e_id=reply.e_id  ");
		sql.append("INNER JOIN graduation_process ON graduation_process.gp_content=reply.gp_content  ");
		sql.append("INNER JOIN sub ON sub.sub_id=reply.sub_id  limit ?,? ");
		
		Connection con = DBConnection.getConnection();
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql.toString());
			pst.setInt(1, i);
			pst.setInt(2, pageSize);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Replys reply = new Replys();
				reply.setReply_id(rs.getInt("reply_id"));
				reply.setReply_site(rs.getString("reply_site"));
				reply.setSub_id(rs.getInt("sub_id"));
				reply.setSub_name(rs.getString("sub_name"));
				
				//System.out.println(rs.getString("reply_start"));
				reply.setReply_start(rs.getString("reply_start"));
				reply.setReply_end(rs.getString("reply_end"));
				reply.setE_id(rs.getInt("e_id"));
				reply.setE_name(rs.getString("e_name"));
				
				
				
				replys.add(reply);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}

		return replys;
	}
	@Override
	public void addReply(String reply_site,int sub_id,String reply_start,String reply_end,int e_id){
		
		//System.out.println("reply_start: "+reply_start);
		Connection  con   =  DBConnection.getConnection();
		StringBuffer  sql = new StringBuffer("");
		sql.append("INSERT INTO reply ");
		sql.append("(reply_site, sub_id,reply_start,reply_end,e_id,gp_content) ");
		sql.append("  VALUES (?,?,?,?,?,'最终答辩' ) ");
		
		
		PreparedStatement   pst = null;
		try {
			   pst =  con.prepareStatement(sql.toString());
			   pst.setString(1, reply_site);
				pst.setInt(2, sub_id);
				pst.setString(3, reply_start);
				pst.setString(4, reply_end);
				pst.setInt(5, e_id);
				 pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
	
	}

	@Override
	public void deleteReply(int reply_id) {
		// TODO Auto-generated method stub
		Connection  con   =  DBConnection.getConnection();
		StringBuffer  sql = new StringBuffer("");
		sql.append("DELETE FROM reply ");
		sql.append("WHERE reply_id=? ");
		
		
		
		PreparedStatement   pst = null;
		try {
			   pst =  con.prepareStatement(sql.toString());
			   pst.setInt(1, reply_id);
				
			   pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
	}

	@Override
	public void alertReply(int reply_id,String reply_site, int sub_id, String reply_start, String reply_end, int e_id) {
		// TODO Auto-generated method stub\
		Connection  con   =  DBConnection.getConnection();
		StringBuffer  sql = new StringBuffer("");
		sql.append("UPDATE  reply ");
		sql.append("SET reply_site = ?, ");
		sql.append(" sub_id = ?, ");
		sql.append(" reply_start = ?, ");
		sql.append(" reply_end = ?, ");
		sql.append(" e_id = ? ");
		sql.append(" WHERE reply_id =?  ");
		
		
		
		PreparedStatement   pst = null;
		try {
			   pst =  con.prepareStatement(sql.toString());
			   pst.setString(1, reply_site);
				pst.setInt(2, sub_id);
				pst.setString(3, reply_start);
				pst.setString(4, reply_end);
				pst.setInt(5, e_id);
				pst.setInt(6, reply_id);
				 pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
		
	}

	
	

}
