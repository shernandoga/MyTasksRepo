package com.AppAquitecture.MyTasks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@AutoConfigureTestDatabase
class MyTasksApplicationTests {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
    TasksService service;
	@MockBean
    TasksRepository countryRepository;
	
	@Test
    public void sizeTest() {
		when(countryRepository.findAll()).thenReturn(new ArrayList<>());	
		assertThat(service.getAll()).isEmpty();
        verify(countryRepository, times(1)).findAll();
    }
	
	@Test
    public void checkFirstElementTest() {
//		List<Tasks> list =service.getAll();
//		Tasks task = list.get(0);
//		
//        assertEquals(1, task.getId());
//        assertEquals("PENDING", task.getTask_state().toUpperCase());
//        assertEquals("LECHE", task.getDescription().toUpperCase());
    }
	
	@Test
    public void testAdd() {
		
    }

}
