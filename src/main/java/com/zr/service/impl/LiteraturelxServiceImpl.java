package com.zr.service.impl;

import com.zr.dao.LiteraturelxDao;
import com.zr.dao.impl.LiteraturelxDaoImpl;
import com.zr.service.LiteraturelxService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class LiteraturelxServiceImpl implements LiteraturelxService{
	@Override
	public JSONArray getAllLiteraturelxInfoForCombobox() {
		//创建数据库对象
		LiteraturelxDao dao = new LiteraturelxDaoImpl();
		//创建json数组
		JSONArray json_arr1 = new JSONArray();
		JSONArray json_arr2 = new JSONArray();
		//获取值
		json_arr1= dao.getAllLiteraturelx();
		//进行循环替换
		for(int i = 0 ;i<json_arr1.size();i++){
			//创建json对象
			JSONObject json1 = new JSONObject();
			JSONObject json2 = new JSONObject();
			//获取对应位置的对象
			json1=json_arr1.getJSONObject(i);
			json2.put("id",json1.get("id"));
			json2.put("text", json1.get("wxlx_name"));
			json_arr2.add(json2);
		}
		System.out.println("LiteraturelxServiceImpl.getAllLiteraturelxInfoForCombobox中获取的文献类型信息json_arr2="+json_arr2);
		return json_arr2;
	}
}
