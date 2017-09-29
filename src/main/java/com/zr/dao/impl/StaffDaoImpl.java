package com.zr.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zr.connection.DBConnection;
import com.zr.dao.StaffDao;
import com.zr.model.Staff;
import com.zr.model.Subject;

/** 
* @author SkySK: 
* @version 创建时间：2017年9月25日 上午1:14:26 
* 说明 ：
*/
public class StaffDaoImpl implements StaffDao {


	@Override
	public Staff getStaff(String ename, String epsw) {
		//System.out.println("进入StaffDaoImpl。getStaff方法 ，获取 参数ename：" + ename + "和epsw：" + epsw);
		// 创建职工对象
		Staff staff = new Staff();
		// 定义数据库语句
		StringBuffer sql = new StringBuffer("");
		sql.append("select e_id,e_name,e_psw,e_col ");
		sql.append("from staff ");
		sql.append("where e_num=? ");
		// 创建数据库连接
		Connection con = DBConnection.getConnection();
		try {
			// 进行数据库语句预编译
			PreparedStatement pst = con.prepareStatement(sql.toString());
			// 为数据库语句赋值
			pst.setString(1, ename);

			// 获取查询后的结果
			ResultSet re = pst.executeQuery();
			if (re.next()) {

				int e_id = re.getInt("e_id");
				staff.setEid(e_id);
				String e_name = re.getString("e_name");
				staff.setEname(e_name);
				String e_psw = re.getString("e_psw");
				staff.setEpsw(e_psw);
				int c_id = re.getInt("e_col");
				staff.setEcol(c_id);
				//System.out.println("数据库中获取的结果e_id:" + e_id + " e_name:" + e_name + " e_psw:" + e_psw+"c_id"+c_id);
			}
			// 将职工对象返回
			return staff;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	@Override
	public int getSubjectCount() {
		// TODO Auto-generated method stub
		int p =0;
		Connection  con   =  DBConnection.getConnection();
		StringBuffer  sql = new StringBuffer("select count(sub_id) AS scount from sub  ");
		PreparedStatement   pst = null;
		try {
			   pst =  con.prepareStatement(sql.toString());
			
			ResultSet  rs  =  pst.executeQuery();
			while(rs.next()){
				 
				  p=rs.getInt("scount");
				 
				  
				  
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
		return p;
	}

	@Override
	public List<Subject> getSubjects(int i, int pageSize) {
		// TODO Auto-generated method stub
List<Subject> subjects = new ArrayList<Subject>();
		
		StringBuffer sql = new StringBuffer("");
		sql.append("SELECT sub_id,sub_name,sub_count,sub_content,sub_state,sub.e_id ");
		sql.append("FROM sub ");
		sql.append("INNER JOIN staff ON staff.e_id=sub.e_id  limit ?,? ");
		
		Connection con = DBConnection.getConnection();
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql.toString());
			pst.setInt(1, i);
			pst.setInt(2, pageSize);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Subject subject = new Subject();
				subject.setSub_id(rs.getInt("sub_id"));
				subject.setSub_name(rs.getString("sub_name"));
				subject.setSub_count(rs.getInt("sub_count"));
				subject.setSub_content(rs.getString("sub_content"));
				subject.setSub_state(rs.getInt("sub_state"));
				if (rs.getInt("sub_state")==0) {
					subject.setSub_statecn("未审核");
				}else if (rs.getInt("sub_state")==1) {
					subject.setSub_statecn("通过");
				} else{
					subject.setSub_statecn("驳回");
				}
				
				subject.setE_id(rs.getInt("e_id"));
				
				
				subjects.add(subject);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}

		return subjects;
	}

	@Override
	public void agreeSubject(int sub_id) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		StringBuffer sql = new StringBuffer("");
		sql.append("UPDATE  sub ");
		sql.append("SET sub_state=1 ");
		sql.append("WHERE sub_id=? ");
		PreparedStatement pst = null;
		try {
			 pst = con.prepareStatement(sql.toString());
			pst.setInt(1, sub_id);
			
			
			 pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
		
	}

	@Override
	public void returnSubject(int sub_id) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		StringBuffer sql = new StringBuffer("");
		sql.append("UPDATE  sub ");
		sql.append("SET sub_state=2 ");
		sql.append("WHERE sub_id=? ");
		PreparedStatement pst = null;
		try {
			 pst = con.prepareStatement(sql.toString());
			pst.setInt(1, sub_id);
			
			
			 pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
		
	}

	@Override
	public void deleteSubject(int sub_id) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		StringBuffer sql = new StringBuffer("");
		sql.append("DELETE FROM  sub ");
		
		sql.append("WHERE sub_id=? ");
		PreparedStatement pst = null;
		try {
			 pst = con.prepareStatement(sql.toString());
			pst.setInt(1, sub_id);
			
			
			 pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
		
	}

}
