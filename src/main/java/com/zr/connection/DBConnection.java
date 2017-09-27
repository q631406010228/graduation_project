package com.zr.connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;
/**
 * 连接数据库工具类
 * @author 欧小峰
 *
 */
public class DBConnection {
	/**
	 * 
	 * @return 数据库连接对象
	 */
<<<<<<< HEAD

	private  final  static String DBURL = "jdbc:mysql://172.18.23.54:3306/graduation_project?useUnicode=true&characterEncoding=UTF8";
	private  final  static String  USERNAME = "qinhao";
	private  final  static String  PASSWORD = "123456";

=======
	private  final  static String DBURL = "jdbc:mysql://172.18.23.54:3306/graduation_project?useUnicode=true&characterEncoding=UTF8";
	private  final  static String  USERNAME = "qinhao";
	private  final  static String  PASSWORD = "123456";
>>>>>>> 5409f170b06381a27c5d0d71e63dfa785200b51a
	  //3.设置驱动名称 (根据不同的数据标准是不一样)
	  private  final  static String  DBDRIVER = "com.mysql.jdbc.Driver";
	  /**
	   * 获取数据库连接
	   * @return  返回数据库连接
	   */
	  public  static  Connection  getConnection(){
		  Connection  con = null;
		  try {
			Class.forName(DBDRIVER);
			con  =  (Connection) DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return  con;
			
	  }
	  /**
	   * 关闭连接
	   * @param st Statement
	   * @param con Connection
	   * @throws SQLException
	   */
	  public static void  closeJDBC(Statement st,java.sql.Connection  con) throws SQLException{
		    if(st!=null){
		    	st.close();
		    }
		    if(con!=null){
		    	con.close();
		    }
		   
	  }
	public static void main(String[] args) {
		System.out.println(DBConnection.getConnection());
	}
}

