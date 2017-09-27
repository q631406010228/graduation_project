package com.zr.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.zr.connection.DBConnection;
import com.zr.dao.SubDao;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.zr.model.Sub;

public class SubDaoImpl implements SubDao {

	@Override
	public int insertSub(String subname, String subcontent, int subcount, int eid, int state) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("insert into sub (sub_name,sub_count,sub_content,sub_state,e_id) ");
		sql.append("value (?,?,?,?,?)");
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			pst.setString(1, subname);
			pst.setInt(2, subcount);
			pst.setString(3, subcontent);
			pst.setInt(4, state);
			pst.setInt(5, eid);
			int i = pst.executeUpdate();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public JSONArray selectSubByTeacherEcol(int e_col) {
		//创建连接
		Connection con = DBConnection.getConnection();
		//定义数据库语句
		StringBuffer sql = new StringBuffer();
		//通过学院id，来获取对应的全部信息，因为需要获取教师名，所以数据库的查询应该使用内联
		sql.append("SELECT *FROM sub INNER JOIN staff ");
		sql.append("on sub.e_id = staff.e_id ");
		sql.append("WHERE staff.e_col=?;");
		try {
			//进行预编译
			PreparedStatement pre = (PreparedStatement)con.prepareStatement(sql.toString());
			//赋值
			pre.setInt(1,e_col);
			//获取结果
			ResultSet set = pre.executeQuery();
			JSONArray json_arr= new JSONArray();
			
			while (set.next()) {
				JSONObject json = new JSONObject();
				//获取选题名
				String sub_name = set.getString("sub_name");
				//获取选题内容
				String sub_content=set.getString("sub_content");
				//获取负责教师姓名
				String e_name= set.getString("e_name");
				//获取限选人数
				Integer sub_count=set.getInt("sub_count");
				//获取已选名额
				Integer selectnum=set.getInt("selectnum");
				//计算剩余名额
				Integer number = sub_count-selectnum;
				//存入json对象
				json.put("sub_name", sub_name);
				json.put("sub_content", sub_content);
				json.put("e_name", e_name);
				json.put("sub_count", sub_count);
				json.put("number", number);
				//将对象放入json数组
				json_arr.add(json);
			}
			System.out.println("SubDaoImpl.selectSubByTeacherEcol返回数据："+json_arr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public Sub getSelectnumSub_countBySubid(int sub_id) {
		Sub sub = new Sub();
		// 创建连接
		Connection con = DBConnection.getConnection();
		// 定义数据库语句
		StringBuffer sql = new StringBuffer();
		sql.append("select sub_count , selectnum ");
		sql.append(" from sub");
		sql.append(" where sub_id =?");
		try {
			// 进行预编译
			PreparedStatement pre = (PreparedStatement) con.prepareStatement(sql.toString());
			// 赋值
			pre.setInt(1, sub_id);
			// 获取值
			ResultSet set = pre.executeQuery();
			if (set.next()) {
				int selectnum = set.getInt("selectnum");
				sub.setSelectnum(selectnum);
				int sub_count = set.getInt("sub_count");
				sub.setSubcount(sub_count);
				System.out.println(
						"SubDaoImpl.getSelectnumSub_countBySubid.selectnum=" + selectnum + "sub_count=" + sub_count);
			}
			return sub;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean setSelectnumByStudentNum(int number, int sub_id) {
		Connection con = DBConnection.getConnection();
		// 定义数据库语句
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE sub set selectnum=? ");
		sql.append(" where sub_id=? ");
		try {
			// 进行预编译
			PreparedStatement pre = (PreparedStatement) con.prepareStatement(sql.toString());
			// 赋值
			pre.setInt(1, number);
			pre.setInt(2, sub_id);
			// 获取结果
			int i = pre.executeUpdate();
			if (i == 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int deleteSub(int eid) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("delete from sub ");
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
	public Sub selectSubByEid(int eid) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		Sub sub = new Sub();
		sql.append("select sub_name,sub_count,sub_content,sub_state ");
		sql.append("from sub ");
		sql.append("where e_id=? ");
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			pst.setInt(1, eid);
			ResultSet res = pst.executeQuery();
			while(res.next()){
				sub.setSubcontent(res.getString("sub_content"));
				sub.setSubcount(res.getInt("sub_count"));
				sub.setSubname(res.getString("sub_name"));
				sub.setSubstate(res.getInt("sub_state"));
				return sub;
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

