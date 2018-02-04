package com.moghadam.pmMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moghadam.pmMVC.dao.ProjectDao;
import com.moghadam.pmMVC.model.Project;

@Service
public class ProjectService {
	
	@Autowired
	ProjectDao projectDao;
	
	@Transactional
	public void persist(Project project) {
		projectDao.save(project);
	}
	
	
	public Iterable<Project> findAll(){
		Iterable<Project> result=projectDao.findAll();
		return result;
	}
	

}
