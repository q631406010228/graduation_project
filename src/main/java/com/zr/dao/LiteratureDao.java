package com.zr.dao;

import java.util.List;

import javax.json.JsonArray;

import com.zr.model.Literature;

import net.sf.json.JSONArray;

public interface LiteratureDao {
	/**
	 * 查询文献根据教师ID
	 * @param eid  教师ID
	 * @return 文献对象的集合
	 */
	public List<Literature> selectLiteratureByEid(int eid);
	
	/**
	 * 审核文献改变文献状态
	 * @param wxid 文献ID
	 * @param state 文献状态
	 * @return 是否成功的标志位
	 */
	public int updateLiterature(int wxid,int state);
	/**
	 * 将学生上传的文件信息录入数据库
	 * @param s_id
	 * @param wxlx_id
	 * @param wx_content
	 * @param wx_name
	 * @return
	 */
	public Boolean setLiteratureInfo(int s_id, int wxlx_id, String wx_content, String wx_name);
	/**
	 * 根据学号获取所有的文献信息，包括文献类型名及id
	 * @param s_id  学号
	 * @return 
	 */
	public JSONArray getLiteratureBySid(Integer s_id);
}
