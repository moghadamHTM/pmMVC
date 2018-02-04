package com.moghadam.pmMVC.dao;

import org.springframework.data.repository.CrudRepository;

import com.moghadam.pmMVC.model.Task;

public interface TaskDao extends CrudRepository<Task, Long> {
	

}
