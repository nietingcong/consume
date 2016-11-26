package com.wiseweb.ntc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiseweb.ntc.dao.UserDao;
import com.wiseweb.ntc.entity.User;

@Service
@Transactional
public class UserMng {
	@Autowired
	private UserDao userDao;

	public User findByName(String userName) {
		// TODO Auto-generated method stub
		return this.userDao.findByName(userName);
	}

	public List<User> getAll(User user) {
		return userDao.getAll();
	}

	public void save(User user) {
		userDao.save(user);
	}
	
}
