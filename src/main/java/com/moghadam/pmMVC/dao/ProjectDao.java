package com.moghadam.pmMVC.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.moghadam.pmMVC.model.Project;

public interface ProjectDao extends PagingAndSortingRepository<Project, Long> {

}
