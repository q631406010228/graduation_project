package com.zr.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.zr.connection.DBConnection;
import com.zr.dao.GraduationProcessDao;
import com.zr.model.GraduationProcess;
import net.sf.json.JSONArray;

public class GraduationProcessDaoImpl implements GraduationProcessDao{

	//保存毕业设计进程信息
	@Override
	public void setGraduationProcess(String gpContent,String graStartTime,String graEndTime,int cID) {
		SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );	//日期的格式
		Connection conn = DBConnection.getConnection();
		StringBuffer s = new StringBuffer();
		s.append("insert into graduation_process(gp_starttime,gp_endtime,gp_content,c_id) values(?,?,?,?);");
		try {
			String[] start = graStartTime.split("/");	//将easyuir的datebox的日期转化为mysql的日期
			StringBuffer s1 = new StringBuffer();
			s1.append(start[start.length-1]);
			for(int i = start.length-2;i >= 0;i--){		//反转开始日期的年月日
				s1.append("-"+start[i]);
			}
			PreparedStatement ps = conn.prepareStatement(s.toString());
			ps.setDate(1, new java.sql.Date(sdf.parse(s1.toString()).getTime()));
			String[] end = graEndTime.split("/");
			s1 = new StringBuffer();
			s1.append(end[end.length-1]);
			for(int i = end.length-2;i >= 0;i--){
				s1.append("-"+end[i]);
			}
			ps.setDate(2, new java.sql.Date(sdf.parse(s1.toString()).getTime()));
			ps.setString(3, gpContent);
			ps.setInt(4, cID);
			ps.executeUpdate();	
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	//查询比当前时间前的毕业设计进程
	@Override
	public List<GraduationProcess> getGraduationProcess(int cID) {
		List<GraduationProcess> gps = new LinkedList<GraduationProcess>();
		Connection conn = DBConnection.getConnection();
		StringBuffer s = new StringBuffer();
		s.append("select gp_starttime,gp_endtime,gp_content ");
		s.append("from graduation_process ");
		s.append("where gp_starttime < current_date() and c_id = ? order by gp_starttime asc ");
		try {
			PreparedStatement ps = conn.prepareStatement(s.toString());
			ps.setInt(1, cID);
			ResultSet re = ps.executeQuery();
			while(re.next()){
				GraduationProcess gp = new GraduationProcess();
				gp.setGpstartime(re.getString("gp_starttime"));
				gp.setGpendtime(re.getString("gp_endtime"));
				gp.setGpcontent(re.getString("gp_content"));
				gps.add(gp);
			}	
			ps.close();
			re.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return gps;
	}

}
