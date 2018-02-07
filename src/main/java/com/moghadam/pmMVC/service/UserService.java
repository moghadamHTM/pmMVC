package com.moghadam.pmMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moghadam.pmMVC.dao.UserDao;
import com.moghadam.pmMVC.model.User;

@Service
@Transactional
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	
	
	public void save(User user) {
		userDao.save(user);
	}

	
	public void activateUserById(Long userId) {
		userDao.activateUserById(userId);
	}
	
	public User findById(Long userId) {
		return userDao.findOne(userId);
	}
}
