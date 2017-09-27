package com.zr.service.impl;

import com.zr.dao.StudentDao;
import com.zr.dao.SubDao;
import com.zr.dao.impl.StudentDaoImpl;
import com.zr.dao.impl.SubDaoImpl;

import com.zr.model.Sub;



import com.zr.service.SubService;

import net.sf.json.JSONArray;



public class SubServiceImpl implements SubService{
	SubDao subdao = new SubDaoImpl();
	@Override
	public int addSub(String subname, String subcontent, int subcount, int eid, int state) {
		// TODO Auto-generated method stub
		int i = subdao.insertSub(subname, subcontent, subcount, eid, state);
		return i;
	}
	 @Override
	public JSONArray selectSubBySid(int c_id) { 
		 //通过学院id，来获取对应的全部信息
		 JSONArray json_arr = new JSONArray();
		 json_arr=subdao.selectSubByTeacherEcol(c_id);
		 System.out.println("SubServiceImpl.selectSubBySid.json_arr"+json_arr);
		return json_arr;
	}

	 
	 @Override
	public synchronized boolean addSubToStudent(int s_id, int sub_id) {
		 System.out.println("进入SubServiceImpl.addSubToStudent,s_id="+s_id+"sub_id"+sub_id);
		//先判断已选人数是否达到最大容量，若没有，则将选题的已选人数+1（用到线程安全）
		 Sub sub = new Sub();
		sub= subdao.getSelectnumSub_countBySubid(sub_id);
		//selectNumber 课题的剩余人数
		int selectNumber = sub.getSubcount()-sub.getSelectnum();
		if(selectNumber>0){//可以添加
			 //将选题的id添加到学生表中
			System.out.println("选择该课题的剩余人数SubServiceImpl.addSubToStudent.selectNumber="+selectNumber);
			StudentDao studentDao = new StudentDaoImpl();
			boolean b1= studentDao.setSubidBySid(sub_id, s_id);
			if(b1){//添加成功
				//查询所有选择该课题的学生人数
				Integer studentNumber=studentDao.getStudentNumberBySubid(sub_id);
				//设置选题的已选人数
				boolean b2= subdao.setSelectnumByStudentNum(studentNumber, sub_id);
				if(b2){
					//设置结果成功，选题操作结束
					System.out.println("SubServiceImpl.addSubToStudent.b1(将选题的id添加到学生表中)="+b1+"  b2(设置选题的已选人数)="+b2);
					return true;
				}
			}
			
		}
	
		return false;
	}

	@Override
	public Sub selectSubByEid(int eid) {
		// TODO Auto-generated method stub
		Sub sub = subdao.selectSubByEid(eid);
		return sub;
	}
	
}

