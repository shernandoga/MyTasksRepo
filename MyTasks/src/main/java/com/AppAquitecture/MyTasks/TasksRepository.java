package com.AppAquitecture.MyTasks;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface TasksRepository extends CrudRepository<Tasks, Integer>{
 
}