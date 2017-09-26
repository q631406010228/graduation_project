package com.zr.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 鏁版嵁搴撶殑杩炴帴鎿嶄綔
 * 
 * @author SkySk
 *
 */
public class JDBCUtil {

	/*
	 * private final static String DBURL =
	 * "jdbc:mysql://localhost:3306/bysj?useUnicode=true&characterEncoding=UTF-8";
	 */
	private final static String DBURL = "jdbc:mysql://172.18.23.54:3306/graduation_project?useUnicode=true&characterEncoding=UTF8";
	private final static String USERNAME = "qinhao";
	private final static String PASSWORD = "123456";

	/*
	 * private final static String USERNAME = "root"; private final static
	 * String PASSWORD = "123";
	 */
	/**
	 * 鑾峰彇鏁版嵁搴撹繛鎺�
	 * 
	 * @return 閾炬帴
	 */
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * 鍏抽棴鏁版嵁搴撹繛鎺�
	 * 
	 * @param pst
	 *            闇�鍏抽棴棰勭紪璇戝璞�
	 * @param con
	 *            闇�鍏抽棴鐨勮繛鎺�
	 */
	public static void closeJDBC(PreparedStatement pst, Connection con) {
		if (pst != null) {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
