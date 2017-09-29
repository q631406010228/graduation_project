package com.zr.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.zr.connection.DBConnection;
import com.zr.dao.LiteratureDao;
import com.zr.model.Literature;

public class LiteratureDaoImpl implements LiteratureDao{

	@Override
	public List<Literature> selectLiteratureByEid(int eid) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("select a.wx_name,a.wx_id,a.wx_state,a.wx_content,b.s_name,c.wxlx_name ");
		sql.append("from literature a ,student b,literaturelx c,sub d ");
		sql.append("where a.wxlx_id = c.id and a.s_id = b.s_id and b.sub_id = d.sub_id ");
		sql.append("and e_id=?");
		List<Literature> list = new ArrayList<Literature>();
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			pst.setInt(1, eid);
			ResultSet res = pst.executeQuery();
			while(res.next()){
				Literature li = new Literature();
				li.setWxid(res.getInt("wx_id"));
				li.setSname(res.getString("s_name"));
				li.setWxcontent(res.getString("wx_content"));
				li.setWxlxname(res.getString("wxlx_name"));
				if(res.getInt("wx_state")==0){
					li.setWxstate("未审核");
				}else
				if(res.getInt("wx_state")==1){
					li.setWxstate("通过");
				}else if(res.getInt("wx_state")==2){
					li.setWxstate("驳回");
				}
				
				li.setWxname(res.getString("wx_name"));
				list.add(li);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int updateLiterature(int wxid, int state) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("update literature ");
		sql.append("set wx_state=? ");
		sql.append("where wx_id=? ");
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			pst.setInt(1, state);
			pst.setInt(2, wxid);
			int i = pst.executeUpdate();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public Boolean setLiteratureInfo(int s_id, int wxlx_id, String wx_content, String wx_name) {
		Connection con = DBConnection.getConnection();
		StringBuffer sql = new StringBuffer();
		
		if(wxlx_id ==7){
			StringBuffer sql2 = new StringBuffer();
			sql2.append("insert into paper(lw_name,s_id) values(?,?)");
			try {
				PreparedStatement pst1 = (PreparedStatement) con.prepareStatement(sql2.toString());
				pst1.setString(1,wx_name);
				pst1.setInt(2, s_id);
				pst1.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sql.append("INSERT INTO literature VALUES(?,0,?,?,?); ");
		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			pst.setString(1, wx_content);
			pst.setInt(2, wxlx_id);
			pst.setInt(3, s_id);
			pst.setString(4, wx_name);
			int i = pst.executeUpdate();
			if(i==1)
			{
				return true;
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}

