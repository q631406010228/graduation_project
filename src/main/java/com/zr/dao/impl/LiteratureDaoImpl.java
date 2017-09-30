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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
		
		sql.append("INSERT INTO literature VALUES(null,?,0,?,?,?);");
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
	
	@Override
	public JSONArray getLiteratureBySid(Integer s_id) {
		//连接数据库
		Connection con = DBConnection.getConnection();
		//创建数据库语句
		StringBuffer sql = new StringBuffer();
		
		sql.append("select * from literature inner join literaturelx on literature.wxlx_id=literaturelx.id where literature.s_id=?");
		try {
			//预编译
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			//赋值
			pst.setInt(1, s_id);
			//创建json数组
			JSONArray jsaon_arr=new JSONArray();
			//获取值
			ResultSet set = pst.executeQuery();
			while(set.next())
			{//将结果进行接收
				
				//创建json对象
				JSONObject jsonObject= new JSONObject();
				Integer wx_id= set.getInt("wx_id");
				Integer wx_state=set.getInt("wx_state");
				Integer wxlx_id=set.getInt("wxlx_id");
				
				String wx_content=set.getString("wx_content");
				String wx_name=set.getString("wx_name");
				String wxlx_name=set.getString("wxlx_name");
				jsonObject.put("wx_id", wx_id);
				jsonObject.put("wx_state", wx_state);
				jsonObject.put("wxlx_id", wxlx_id);
				jsonObject.put("wx_content", wx_content);
				jsonObject.put("wx_name", wx_name);
				jsonObject.put("wxlx_name", wxlx_name);
				jsaon_arr.add(jsonObject);
				
			}
			System.out.println("LiteratureDaoImpl.getLiteratureBySid.jsaon_arr"+jsaon_arr);
			return jsaon_arr;
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}

