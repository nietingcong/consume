package com.wiseweb.ntc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiseweb.ntc.dao.MenuDao;
import com.wiseweb.ntc.entity.Menu;

@Service
@Transactional
public class MenuMng {
	@Autowired
	private MenuDao menuDao;
	
	public List<Menu> findAll() {
		return menuDao.getAll();
	}
}
