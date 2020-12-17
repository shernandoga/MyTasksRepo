package com.AppAquitecture.MyTasks;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.AppAquitecture.MyTasks.TasksService;;



@RestController
public class TasksController {

	private final Logger log = LoggerFactory.getLogger(this.getClass()); 

	// @Autowired annotation provides the automatic dependency injection.
	@Autowired
	TasksService service;

	// Get all students from the h2 database.
	// @GetMapping annotation handles the http get request matched with the given uri.
	@GetMapping(value= "/tasks")
	public List<Tasks> getAll() {
		log.info("Getting task details from the database.");
		return service.getAll();
	}
	
	
	  @GetMapping("/tasks/{id}")
	    private Tasks getTask(@PathVariable("id") int id) {
	        return service.getPersonById(id);
	    }

	  @DeleteMapping("/tasks/{id}")
	    private void deleteTask(@PathVariable("id") int id) {
		  service.delete(id);
	    }
	  
	    @ResponseStatus(HttpStatus.CREATED)
	    @PostMapping("/tasks")
	    private String savePerson(@RequestBody Tasks task) {
	    	service.saveOrUpdate(task);
	    	String taskmessage = task.getId() +" | "+ task.getTask_state()+" | " + task.getDescription();
	        return taskmessage;
	    }
}
