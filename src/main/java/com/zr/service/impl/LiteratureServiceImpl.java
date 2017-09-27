package com.zr.service.impl;

import java.util.List;

import com.zr.dao.LiteratureDao;
import com.zr.dao.impl.LiteratureDaoImpl;
import com.zr.model.Literature;
import com.zr.service.LiteratureService;

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

}
