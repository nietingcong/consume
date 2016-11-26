package com.wiseweb.ntc.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiseweb.ntc.dao.DepartmentDao;

@Service
@Transactional
public class DepartmentMng {
	@Autowired
	private DepartmentDao departmentDao;
	
	public void getAll() {
		this.departmentDao.getAll();
	}
}
