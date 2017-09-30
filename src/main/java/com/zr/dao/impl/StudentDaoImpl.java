package com.zr.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.zr.connection.DBConnection;
import com.zr.dao.StudentDao;
import com.zr.model.Student;

public class StudentDaoImpl implements StudentDao{

	@Override
	public List<Student> selectStudentByEid(int eid) {
		StringBuffer sql = new StringBuffer();
		sql.append("select s_id,s_name from student,sub ");
		sql.append("where student.sub_id = sub.sub_id and sub.e_id =?");
		List<Student> list = new ArrayList<Student>();
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			pst.setInt(1, eid);
			ResultSet res = pst.executeQuery();
			while(res.next()){
				Student stu = new Student();
				stu.setSid(res.getInt("s_id"));
				stu.setSname(res.getString("s_name"));
				list.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Student> selectStudentFormByEid(int eid) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("select a.s_num,a.c_id,a.m_id,a.s_id,a.s_psw,a.sub_id,a.s_name,b.c_name,c.m_name,d.sub_name ");
		sql.append("from student a,college b,major c,sub d ");
		sql.append("where a.c_id = b.c_id and a.m_id = c.m_id and b.c_id = c.c_id and a.sub_id = d.sub_id ");
		sql.append("and e_id=?");
		List<Student> list = new ArrayList<Student>();
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			pst.setInt(1, eid);
			ResultSet res = pst.executeQuery();
			while(res.next()){
				Student stu = new Student();
				stu.setNum(res.getInt("s_num"));
				stu.setSname(res.getString("s_name"));
				stu.setColname(res.getString("c_name"));
				stu.setMajname(res.getString("m_name"));
				stu.setSubname(res.getString("sub_name"));
				stu.setColid(res.getInt("c_id"));
				stu.setMajid(res.getInt("m_id"));
				stu.setSpsw(res.getString("s_psw"));
				stu.setSubid(res.getInt("sub_id"));
				list.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean setSubidBySid(int sub_id, int s_id) {
		//System.out.println("进入StudentDaoImpl.setSubidBySid,sub_id="+sub_id+"s_id="+s_id);
		Connection con = DBConnection.getConnection();
		//定义数据库语句
		StringBuffer sql = new StringBuffer();
		sql.append("update student set sub_id =?");
		sql.append(" where s_id =?");
		try {
			//预编译
			PreparedStatement pre = (PreparedStatement)con.prepareStatement(sql.toString());
			//赋值
			pre.setInt(1, sub_id);
			pre.setInt(2, s_id);
			//获取结果
			int i= pre.executeUpdate();
			if(i==1){
				//System.out.println("获取结果(1为成功)StudentDaoImpl.setSubidBySid.i="+i);
				con.close();
				return true;
			}
			}catch (Exception e) {
				// TODO: handle exception
			}
		return false;
	}

	@Override
	public List<Student> selectStudentAll() {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("select a.s_num,a.c_id,a.m_id,a.s_id,a.s_psw,a.sub_id,a.s_name,b.c_name,c.m_name,d.sub_name ");
		sql.append("from student a,college b,major c,sub d ");
		sql.append("where a.c_id = b.c_id and a.m_id = c.m_id and b.c_id = c.c_id and a.sub_id = d.sub_id ");
		List<Student> list = new ArrayList<Student>();
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			ResultSet res = pst.executeQuery();
			while(res.next()){
				Student stu = new Student();
				stu.setNum(res.getInt("s_num"));
				stu.setSname(res.getString("s_name"));
				stu.setColname(res.getString("c_name"));
				stu.setMajname(res.getString("m_name"));
				stu.setSubname(res.getString("sub_name"));
				stu.setSubid(res.getInt("sub_id"));
				stu.setColid(res.getInt("c_id"));
				stu.setMajid(res.getInt("m_id"));
				stu.setSpsw(res.getString("s_psw"));				
				list.add(stu);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	

	return list;
}
	
	@Override
	public Integer getStudentNumberBySubid(int sub_id){
		Connection con = DBConnection.getConnection();
		//定义数据库语句
		StringBuffer sql = new StringBuffer();
		sql.append("select COUNT(s_id)as number ");
		sql.append("from student");
		sql.append(" where sub_id=? ");
		try {
			//预编译
			PreparedStatement pre =(PreparedStatement)con.prepareStatement(sql.toString());
			//赋值
			pre.setInt(1, sub_id);
			//获取值
			ResultSet set = pre.executeQuery();
			if(set.next()){
				Integer i =set.getInt("number");
				//System.out.println("选择该课题的人数StudentDaoImpl.getStudentNumberBySubid.i="+i);
				return i;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void insertStudent(int num, String name, int cID, int mID) {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into student(s_num,s_name,c_id,m_id,r_id,s_psw,sub_id)  ");
		sql.append("values(?,?,?,?,?,?,?);");
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			pst.setInt(1, num);
			pst.setString(2, name);
			pst.setInt(3, cID);
			pst.setInt(4, mID);
			pst.setInt(5, 2);
			pst.setString(6, "123456");
			pst.setInt(7, 7);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteStudent(int[] num) {
		Connection conn = DBConnection.getConnection();
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}	//禁止自动提交
		StringBuffer s = new StringBuffer();
		s.append("delete from student where s_num = ?;");
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(s.toString());
			for(int i = 0;i < num.length;i++){
				ps.setInt(1, num[i]);	
				ps.addBatch();	
			}
		
			ps.executeBatch();	//批量执行上面的语句
			conn.commit();		//一起提交	
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	@Override
	public void updateStudent(int num, String name, int cID, int mID,int preNum) {
		StringBuffer sql = new StringBuffer();
		sql.append("update student   ");
		sql.append("set s_num = ?,s_name = ?,c_id = ?,m_id = ? where s_num = ?;");
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			pst.setInt(1, num);
			pst.setString(2, name);
			pst.setInt(3, cID);
			pst.setInt(4, mID);
			pst.setInt(5, preNum);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Student getStudent(int snum,String spsw) {
		// TODO Auto-generated method stub
		//System.out.println("进入StudentDaoImpl。getStudent方法，获取参数snum："+snum+"和spsw"+spsw);
		Student student = new Student();
		StringBuffer sql = new StringBuffer("");
		sql.append("select s_id,s_num,s_psw,c_id ");
		sql.append("from student ");
		sql.append("where s_num=? ");
		Connection con = DBConnection.getConnection();
		try {
			//数据库语句预编译
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
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
				//System.out.println("数据库中获取的结果s_id："+s_id+"s_id"+s_id+"s_psw"+s_psw+"c_id"+c_id);
				
			}
		    //将学生对象返回
		    return student;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public String getStudentnumBys_id(int s_id) {
		//创建连接
		Connection con = DBConnection.getConnection();
		//数据库语句
		StringBuffer sql = new StringBuffer();
		sql.append("select s_num from student where s_id=?");
		try {
			//预编译
			PreparedStatement pre = (PreparedStatement)con.prepareStatement(sql.toString());
			//赋值
			pre.setInt(1, s_id);
			//取值
			ResultSet set = pre.executeQuery();
			if(set.next()){
				Integer studentNum=set.getInt("s_num");
				return studentNum.toString();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public List<Integer> getStudentScore(int cid) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		List<Integer> list = new ArrayList<Integer>();
		sql.append("select score from student where c_id =?");
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql.toString());
			pst.setInt(1, cid);
			ResultSet re = pst.executeQuery();
			while(re.next()){
				list.add(re.getInt("score"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
