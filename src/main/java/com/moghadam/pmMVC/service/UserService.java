package com.moghadam.pmMVC.service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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
	
	
	public User findByUsername(String username) {
		
		return userDao.findAll(new Usernamespec(username)).iterator().next();
		
	}
	
	public static class Usernamespec implements Specification<User> {

		private String username;
		
		
		public Usernamespec(String username) {
			super();
			this.username = username;
		}


		public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
			//cb.or(cb.equal(root.get("email"), this.email))
			return cb.equal(root.get("username"), this.username);
		}
		
	}
}
