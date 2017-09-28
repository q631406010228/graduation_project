package com.zr.service;

import net.sf.json.JSONObject;

public interface StaffService {
	public JSONObject getSubjects(int page, int pageSize);
	
	public void agreeSubject(int sub_id);

	public void returnSubject(int sub_id);

	public void deleteSubject(int sub_id);
}
