package com.moghadam.pmMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moghadam.pmMVC.dao.TaskDao;
import com.moghadam.pmMVC.model.Task;

@Service
public class TaskService {

	@Autowired
	TaskDao taskDao;
	
	@Transactional
	public void persist(Task task) {
		taskDao.save(task);
	}
}
