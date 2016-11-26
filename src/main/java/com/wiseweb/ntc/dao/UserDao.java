package com.wiseweb.ntc.dao;

import org.springframework.stereotype.Repository;

import com.wiseweb.ntc.comment.util.BaseDao;
import com.wiseweb.ntc.entity.User;

@Repository
public class UserDao extends BaseDao<User, Long> {

	public User findByName(String userName) {
		return (User) getSession().createQuery("from User where loginName=:loginName")
				.setString("loginName", userName).uniqueResult();
	}

}
