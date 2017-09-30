package com.zr.service;

import java.util.List;

import com.zr.model.Literature;

import net.sf.json.JSONArray;

public interface LiteratureService {
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
	 * 设置学生上传的文件路径名
	 * @param s_id 学生的学号
	 * @param wxlx_id 文献类型id
	 * @param wx_content 文献路径
	 * @param wx_name 文献名
	 * @return
	 */
	public Boolean setLiteratureInfo(int s_id,int wxlx_id,String wx_content,String wx_name);
	/**
	 * 根据学号获取该生的全部的文献
	 * @param s_id 学号
	 * @return
	 */
	public JSONArray getLiteratureBySid(Integer s_id);
}
