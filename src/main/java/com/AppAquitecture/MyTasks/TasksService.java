package com.AppAquitecture.MyTasks;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AppAquitecture.MyTasks.TasksRepository;

@Service
public class TasksService {
	// @Autowired annotation provides the automatic dependency injection.
	@Autowired
	TasksRepository repository;

	// Save student entity in the h2 database.
	public void save(final Tasks tasks) {
		repository.save(tasks);
	}

	// Get all students from the h2 database.
	public List<Tasks> getAll() {
		final List<Tasks> students = new ArrayList<>();
		repository.findAll().forEach(student -> students.add(student));
		return students;
	}
	
	public Tasks getPersonById(int id) {
        return repository.findById(id).get();
    }

    public void saveOrUpdate(Tasks task) {
    	repository.save(task);
    }

    public void delete(int id) {
    	repository.deleteById(id);
    }
}

