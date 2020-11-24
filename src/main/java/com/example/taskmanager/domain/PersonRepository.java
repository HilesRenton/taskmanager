package com.example.taskmanager.domain;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

	Person findByfirstName(String firstName);
		
}
