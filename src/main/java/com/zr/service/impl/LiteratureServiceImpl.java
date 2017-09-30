package com.zr.service.impl;

import java.util.List;

import com.zr.dao.LiteratureDao;
import com.zr.dao.impl.LiteratureDaoImpl;
import com.zr.model.Literature;
import com.zr.service.LiteratureService;

import net.sf.json.JSONArray;

public class LiteratureServiceImpl implements LiteratureService{
	LiteratureDao lidao = new LiteratureDaoImpl();
	@Override
	public List<Literature> selectLiteratureByEid(int eid) {
		// TODO Auto-generated method stub
		List<Literature>list = lidao.selectLiteratureByEid(eid);
		return list;
	}
	@Override
	public int updateLiterature(int wxid, int state) {
		// TODO Auto-generated method stub
		int i = lidao.updateLiterature(wxid, state);
		return i;
	}
	
	@Override
	public Boolean setLiteratureInfo(int s_id, int wxlx_id, String wx_content, String wx_name) {
		//调用数据库语句，将信息添加进去
		LiteratureDao dao = new LiteratureDaoImpl();
		Boolean result= dao.setLiteratureInfo(s_id, wxlx_id, wx_content, wx_name);
		return result;
	}
	
	@Override
	public JSONArray getLiteratureBySid(Integer s_id) {
		LiteratureDao dao=new LiteratureDaoImpl();
		//创建json数组
		JSONArray array=new JSONArray();
		array=	dao.getLiteratureBySid(s_id);
		return array;
	}

}
