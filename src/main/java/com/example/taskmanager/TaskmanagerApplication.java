package com.example.taskmanager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.taskmanager.domain.Person;
import com.example.taskmanager.domain.PersonRepository;
import com.example.taskmanager.domain.Task;
import com.example.taskmanager.domain.TaskRepository;
import com.example.taskmanager.domain.User;
import com.example.taskmanager.domain.UserRepository;

@SpringBootApplication
public class TaskmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskmanagerApplication.class, args);
	}
	
	
	@Bean
	
	public CommandLineRunner demo (TaskRepository trepository, UserRepository urepository, PersonRepository prepository) {
		
		return(args) -> {
			
			
			

			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			
			urepository.save(user1);
			urepository.save(user2);
			
			Person person1 = new Person("Matti", "Meikäläinen", "matti.meikalainen@gmail.com");
			Person person2 = new Person("Maija", "Meikäläinen", "maija.meikalainen@gmail.com");
			 
			prepository.save(person1) ;
			prepository.save(person2) ;
			
			Task task1 = new Task("Dishes","24.11.1997","25.11.1997","High","Done",  prepository.findByfirstName("Matti"));
			Task task2 = new Task("Eat","24.11.1997","25.11.1997","Low", "Not Done", prepository.findByfirstName("Maija"));
			
			trepository.save(task1) ;
			trepository.save(task2) ;
			
			
		};
		
		
		
		
	}

}
