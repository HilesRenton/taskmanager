package com.example.taskmanager.domain;

import org.springframework.data.repository.CrudRepository;



public interface TaskRepository extends CrudRepository<Task, Long> {
	Task findByTaskname(String taskname);
}
