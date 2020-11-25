package com.example.taskmanager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.taskmanager.domain.Person;
import com.example.taskmanager.domain.PersonRepository;
import com.example.taskmanager.domain.Task;
import com.example.taskmanager.domain.TaskRepository;


@Controller
public class TaskmanagerController {
	@Autowired TaskRepository trepository ;
	 @Autowired PersonRepository prepository ;
	
	 

	@RequestMapping("/tasklist")
	public String tasklist (Model model) {
		model.addAttribute("tasks", trepository.findAll());
		
		return "tasklist";
		
	}
	
	@RequestMapping(value="/addt")
	public String addTask(Model model){
		model.addAttribute("task", new Task());
		model.addAttribute("persons",prepository.findAll());
		return"addtask";
		
	}
	
	@RequestMapping(value="/savet",method=RequestMethod.POST)
	public String saveT(Task task){
		trepository.save(task);
		return"redirect:/tasklist";
		}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value ="/deletet/{id}",method =RequestMethod.GET)
	public String deleteTask (@PathVariable("id") Long id, Model model) {
		trepository.deleteById(id);
		return"redirect:../tasklist" ;
		}
	
	@RequestMapping (value = "/editt/{id}")
	public String addTask(@PathVariable("id")Long id, Model model){
		model.addAttribute("task", trepository.findById(id));
		model.addAttribute("persons",prepository.findAll());
		return "edittask";
	}
	

	
	
	@RequestMapping("/personlist")
	public String userlist (Model model) {
		model.addAttribute("persons", prepository.findAll());
		return "personlist";
		
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/addp")
	public String addPerson(Model model){
		model.addAttribute("person", new Person());
		return"addperson";
		
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/savep",method=RequestMethod.POST)
	public String saveP(Person person){
		prepository.save(person);
		return"redirect:personlist";
		}
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping (value = "/editp/{id}")
	public String editPerson(@PathVariable("id")Long id, Model model){
		model.addAttribute("person", prepository.findById(id));
		
		return "editperson";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value ="/deletep/{id}",method =RequestMethod.GET)
	public String deletePerson (@PathVariable("id") Long id, Model model) {
		prepository.deleteById(id);
		return"redirect:../personlist" ;
		}
	
}
