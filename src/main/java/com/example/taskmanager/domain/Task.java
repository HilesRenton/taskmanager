package com.example.taskmanager.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
public class Task {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Long id;
	public String taskname ;
	public String assigndate ;
	public String donedate ;
	public String priority ;
	public String status ;
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name = "personid")
    private Person person;
	
	
	public Task() {}
	
	public Task(String taskname, String assigndate, String donedate, String priority , String status, Person person) {
		super();
		this.taskname = taskname;
		this.assigndate = assigndate;
		this.donedate = donedate;
		this.priority = priority;
		this.status = status ;
		this.person = person ;
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	public String getAssigndate() {
		return assigndate;
	}
	public void setAssigndate(String assigndate) {
		this.assigndate = assigndate;
	}
	public String getDonedate() {
		return donedate;
	}
	public void setDonedate(String donedate) {
		this.donedate = donedate;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
	
	}
