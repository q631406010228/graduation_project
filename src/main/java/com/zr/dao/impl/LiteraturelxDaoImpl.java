package com.zr.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.sun.star.lib.uno.environments.remote.remote_environment;
import com.zr.connection.DBConnection;
import com.zr.dao.LiteraturelxDao;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class LiteraturelxDaoImpl implements LiteraturelxDao{
 @Override
public JSONArray getAllLiteraturelx() {
	 //创建连接
	 Connection con = DBConnection.getConnection();
	//创建数据库语句
	 StringBuffer sql = new StringBuffer();
	 sql.append("select * from literaturelx");
	 try {
		 //预编译
		PreparedStatement pre = (PreparedStatement)con.prepareStatement(sql.toString());
	    //获取值
		ResultSet set= pre.executeQuery();
		//创建json数组
		JSONArray json_arr = new JSONArray();
		
		while (set.next()) {
		Integer id = set.getInt("id"); 
		Integer wxlx_id = set.getInt("wxlx_id");
		String wxlx_name=set.getString("wxlx_name");
		//System.out.println("LiteraturelxDaoImpl.getAllLiteraturelx.id="+id+"wxlx_name"+wxlx_name);
		//创建json对象
		JSONObject json = new JSONObject();
		json.put("id", id);
		json.put("wxlx_id", wxlx_id);
		json.put("wxlx_name", wxlx_name);
		json_arr.add(json);
		}
		System.out.println("LiteraturelxDaoImpl.getAllLiteraturelx.获取的文件类型信息json_arr= "+json_arr);
		return json_arr;
	 } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
}
