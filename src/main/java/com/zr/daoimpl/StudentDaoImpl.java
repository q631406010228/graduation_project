package com.zr.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zr.connection.JDBCUtil;
import com.zr.dao.StudentDao;
import com.zr.model.Student;

/** 
* @author SkySK: 
* @version 创建时间：2017年9月26日 下午5:35:25 
* 说明 ：
*/
public class StudentDaoImpl implements StudentDao {

	@Override
	public Student getStudent(int snum,String spsw) {
		// TODO Auto-generated method stub
		System.out.println("进入StudentDaoImpl。getStudent方法，获取参数snum："+snum+"和spsw"+spsw);
		Student student = new Student();
		StringBuffer sql = new StringBuffer("");
		sql.append("select s_id,s_num,s_psw,c_id ");
		sql.append("from student ");
		sql.append("where s_num=? ");
		Connection con = JDBCUtil.getConnection();
		try {
			//数据库语句预编译
			PreparedStatement pst = con.prepareStatement(sql.toString());
			//为数据库语句赋值
		    pst.setInt(1, snum);
		    //获取查询后的结果
		    ResultSet re = pst.executeQuery();
		    if (re.next()) {
				int s_id=re.getInt("s_id");
				student.setSid(s_id);
				int s_num = re.getInt("s_id");
				student.setNum(s_num);
				String s_psw = re.getString("s_psw");
				student.setSpsw(s_psw);
				int c_id = re.getInt("c_id");
				student.setColid(c_id);
				System.out.println("数据库中获取的结果s_id："+s_id+"s_id"+s_id+"s_psw"+s_psw+"c_id"+c_id);
				
			}
		    //将学生对象返回
		    return student;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
  
}
