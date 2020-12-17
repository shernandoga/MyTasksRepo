package com.AppAquitecture.MyTasks;

import javax.persistence.*;

@Entity
@Table(name = "TASKS")
public class Tasks {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private String task_state;
	    private String description;
	    
	    public Tasks(){ }
	    
		public Tasks(int id, String task_state, String description) {
			this.id =id;
			this.task_state = task_state;
			this.description = description;
		}
	    
		public int getId() {
			return id;
		}
		public String getTask_state() {
			return task_state;
		}
		public void setTask_state(String task_state) {
			this.task_state = task_state;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}

		@Override
		public String toString() {
			return "Tasks [id=" + id + ", task_state=" + task_state + ", description=" + description + "]";
		}
	
	}

