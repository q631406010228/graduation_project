package com.zr.daoimpl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zr.connection.JDBCUtil;
import com.zr.dao.FunctionDao;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/** 
* @author SkySK: 
* @version 创建时间：2017年9月25日 上午2:58:02 
* 说明 ：
*/
public class FunctionDaoImpl implements FunctionDao {

	Connection con = JDBCUtil.getConnection();

	@Override
	public JSONArray getChildFunctionsObject(int parentNode, String functions) {
		// System.out.println("执行FunctionDaoImpl.getChildFunctionsObject方法，获取parentNode："+parentNode+"获取functions:"+functions);

		JSONArray json_arr = new JSONArray();

		// 定义数据库语句
		StringBuffer sql = new StringBuffer();
		sql.append("select *  from function ");
		sql.append("where fun_id in (" + functions + ") and fun_father=? ;");
		try {
			// 进行预编译
			PreparedStatement pre = con.prepareStatement(sql.toString());
			// 赋值
			pre.setInt(1, parentNode);
			// 运行
			ResultSet set = pre.executeQuery();

			while (set.next()) {
				JSONObject json = new JSONObject();
				json.put("id", set.getInt("fun_id"));
				json.put("text", set.getString("fun_name"));
				json.put("state", set.getString("fun_state"));
				JSONObject attr = new JSONObject();
				attr.put("src", set.getString("url"));
				json.put("attributes", attr);
				json_arr.add(json);
			}
			// System.out.println("FunctionDao.getChildFunctionsObject
			// 中通过parentNode,fid 返回的jsonarr结果 "+json_arr.toString() );
			return json_arr;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public JSONArray getCurrentAllfunctionObject(int parentNode, String functions) {
		// System.out.println("执行FunctionDaoImpl.getCurrentAllfunctionObject方法，获取parentNode："+parentNode+"获取functions:"+functions);
		JSONArray json_allArr = this.getChildFunctionsObject(parentNode, functions);
		for (int i = 0; i < json_allArr.size(); i++) {
			// 获取第i个对象的state
			String state = json_allArr.getJSONObject(i).getString("state");
			// System.out.println("获取该节点的状态state"+state);
			// 进行判断该节点的状态
			if (state.equals("open")) {
				// 是叶子节点，不需要寻找其子节点
				continue;
			} else {
				// 获取该节点的id ，作为他子节点的父亲节点
				int fParentNode = json_allArr.getJSONObject(i).getInt("id");
				// System.out.println();
				// 获取该节点下的所有节点
				JSONArray json_Arr = this.getCurrentAllfunctionObject(fParentNode, functions);
				json_allArr.getJSONObject(i).put("children", json_Arr);
			}

		}
		// System.out.println("FunctionDao.getCurrentAllfunctionObject中通过parentNode,fid
		// 返回的jsonarr结果 "+json_allArr.toString() );

		return json_allArr;
	}



}
