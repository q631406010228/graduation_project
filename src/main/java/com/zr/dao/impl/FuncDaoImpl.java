package com.zr.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zr.connection.DBConnection;
import com.zr.dao.FuncDao;
import com.zr.model.Role;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class FuncDaoImpl implements  FuncDao{
	//-1
	
	public JSONArray getAllRoles2() {
		JSONArray   funcs =  new JSONArray();
		Connection  con   =  DBConnection.getConnection();
		StringBuffer  sql = new StringBuffer("select * from t_role ");
		PreparedStatement   pst = null;
		try {
			   pst =  con.prepareStatement(sql.toString());
			
			ResultSet  rs  =  pst.executeQuery();
			while(rs.next()){
				  JSONObject  func =  new JSONObject();
				  func.put("id", rs.getInt("rid"));
				  func.put("text", rs.getString("rname"));
				  
				  funcs.add(func);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
		return funcs;
	}
	
	
	public JSONArray getfuncsByParentId(int parentId) {
		JSONArray   funcs =  new JSONArray();
		Connection  con   =  DBConnection.getConnection();
		StringBuffer  sql = new StringBuffer("select * from t_func where fpid=?");
		PreparedStatement pst=null;
		try {
			   pst =  con.prepareStatement(sql.toString());
			pst.setInt(1, parentId);
			ResultSet  rs  =  pst.executeQuery();
			while(rs.next()){
				  JSONObject  func =  new JSONObject();
				  func.put("id", rs.getInt("fid"));
				  func.put("text", rs.getString("fname"));
				  func.put("state", rs.getString("fstate"));
				  JSONObject  attr  = new JSONObject();
				  attr.put("fpath", rs.getString("fcontent"));
				  func.put("attributes", attr);
				  funcs.add(func);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
		return funcs;
	}

//-1   1   2
public JSONArray getCurrentUserFuncsByParentId(int parentId) {
		JSONArray   userfuncs  = this.getfuncsByParentId(parentId);
		//                              2
		for (int i = 0; i < userfuncs.size(); i++) {
			   //                     
			  String state = userfuncs.getJSONObject(i).getString("state");
			  if("open".equals(state)){
				     continue;
			  }else{
				  //  id=1  id=2
				   int currentId = userfuncs.getJSONObject(i).getInt("id");
				   JSONArray   children  =  this.getCurrentUserFuncsByParentId(currentId);
				   userfuncs.getJSONObject(i).put("children", children);
			  }
		}
		
		
		
		return  userfuncs;
	}
//------------------------------------------------------------------------------------

    //   -1   1 2 4  5
			@Override
			public JSONArray getfuncsByParentId1(int parentId, String fids) {
				JSONArray   funcs =  new JSONArray();
				Connection  con   =  DBConnection.getConnection();
				StringBuffer  sql = new StringBuffer("select * from function where fun_id in (");
				sql.append(fids);
				sql.append(")");
				sql.append( " and fun_father=?");
				PreparedStatement pst = null;
				try {
					   pst =  con.prepareStatement(sql.toString());
					pst.setInt(1, parentId);
					ResultSet  rs  =  pst.executeQuery();
					while(rs.next()){
						  JSONObject  func =  new JSONObject();
						  func.put("id", rs.getInt("fun_id"));
						  func.put("text", rs.getString("fun_name"));
						  func.put("state", rs.getString("fun_state"));
						  JSONObject  attr  = new JSONObject();
						  attr.put("fpath", rs.getString("fun_jsp"));
						  func.put("attributes", attr);
						  funcs.add(func);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
				}
				
				return funcs;
			}
			
			
			//  -1   1 2 4 5
			@Override
			public JSONArray getCurrentUserFuncsByParentId1(int parentId, String fids) {
				JSONArray   userfuncs  = this.getfuncsByParentId1(parentId,fids);
				//                              1
				for (int i = 0; i < userfuncs.size(); i++) {
					   //                  
					  String state = userfuncs.getJSONObject(i).getString("state");
					  if("open".equals(state)){
						     continue;
					  }else{
						  // 1  1,2,4,5
						   int currentId = userfuncs.getJSONObject(i).getInt("id");
						   JSONArray   children  =  this.getCurrentUserFuncsByParentId1(currentId,fids);
						   userfuncs.getJSONObject(i).put("children", children);
					  }
				}
			
				
				
				return  userfuncs;
			}

			
			
			@Override
			public String getFidsByRid(int rid) {
				String s = new String();
				
				
				StringBuffer sql = new StringBuffer("");
				sql.append("SELECT  fids ");
				sql.append("FROM  t_role ");
				sql.append("WHERE  rid=? ");
				Connection con = DBConnection.getConnection();
				PreparedStatement pst = null;
				try {
					pst = con.prepareStatement(sql.toString());
					pst.setInt(1, rid);
					
					ResultSet rs = pst.executeQuery();
					if(rs.next()){
						s = rs.getString("fids");
					
					}
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
				}

				
				return s; 
			}


			@Override
			public void updatefunction(int a, String b) {
				Role r = new Role();
				Connection con = DBConnection.getConnection();
				StringBuffer sql = new StringBuffer("");
				sql.append("UPDATE  t_role ");
				sql.append("SET fids=? ");
				sql.append("WHERE rid=? ");
				PreparedStatement pst = null;
				try {
					 pst = con.prepareStatement(sql.toString());
					pst.setInt(2, a);
					pst.setString(1, b);
					
					 pst.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
				}
				
				
			}


			@Override
			public JSONArray findParent() {
				JSONArray   funcs =  new JSONArray();
				Connection  con   =  DBConnection.getConnection();
				StringBuffer  sql = new StringBuffer("SELECT fid,fname ");
				sql.append("FROM t_func ");
				sql.append("WHERE fpid=1");
				try {
					PreparedStatement   pst =  con.prepareStatement(sql.toString());
					ResultSet  rs  =  pst.executeQuery();
					while(rs.next()){
						  JSONObject  func =  new JSONObject();
						  func.put("id", rs.getInt("fid"));
						  func.put("text", rs.getString("fname"));
						  funcs.add(func);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.println(funcs);
				return funcs;
			}


			@Override
			public void addFunc(String fname, String furl, String fcontent, int fpid) {
				StringBuffer sql = new StringBuffer("");
				sql.append("INSERT INTO t_func ");
				sql.append("(fname,furl,fcontent,fpid,fstate) ");
				sql.append("values(?,?,?,?,?) ");
				Connection con = DBConnection.getConnection();
				PreparedStatement pst;
				try {
					pst = con.prepareStatement(sql.toString());
					pst.setString(1, fname);
					pst.setString(2, furl);
					pst.setString(3, fcontent);
					pst.setInt(4, fpid);
					pst.setString(5, "open");
					pst.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
}
