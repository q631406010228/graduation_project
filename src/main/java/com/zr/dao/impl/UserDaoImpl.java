package com.zr.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zr.connection.DBConnection;
import com.zr.dao.UserDao;
import com.zr.model.User;

/** 
* @author SkySK: 
* @version 创建时间：2017年9月26日 下午7:56:58 
* 说明 ：
*/
public class UserDaoImpl implements UserDao {
	@Override
        public User getUser(Integer unum,String upsw){
        	System.out.println("进入UserDaoImpl。getUser方法，获取参数unum:"+"和upsw");
        	User user = new User();
        	StringBuffer sql = new StringBuffer("");
        	sql.append("select u_id,u_num,u_psw,r_id ");
        	sql.append("from user ");
        	sql.append("where u_num=? ");
        	Connection con= DBConnection.getConnection();
        	try {
				PreparedStatement pst = con.prepareStatement(sql.toString());
				pst.setInt(1, unum);
				ResultSet re = pst.executeQuery();
				if (re.next()) {
					int u_id = re.getInt("u_id");
					user.setUid(u_id);
					String u_num = re.getString("u_num");
					user.setUnum(u_num);
					String u_psw = re.getString("u_psw");
					user.setUpsw(u_psw);
					int r_id = re.getInt("r_id");
					user.setRid(r_id);
					System.out.println("数据库中获取的结果u_id："+u_id+"u_num"+u_num+"u_psw"+u_psw+"r_id"+r_id);
				}
				return user;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
        	
        }

}
