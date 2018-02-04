package com.moghadam.pmMVC.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="project")
@Table(name="PROJECT")
public class Project extends PO {
	
	
	@Column(name="Proj_NAME")
	private String name;
	
	@OneToMany(mappedBy="project",fetch=FetchType.LAZY)
	private List<Task> tasks=new ArrayList<Task>();

	
	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
