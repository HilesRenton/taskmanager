package com.example.taskmanager.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Person {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Long personid;
	public String firstName ;
	public String lastName ;
	public String email ;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
	private List<Task> tasks;
	
	
	public Person() {}
	
	public Person(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Long getId() {
		return personid;
	}

	public void setId(Long personid) {
		this.personid = personid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
		
}
