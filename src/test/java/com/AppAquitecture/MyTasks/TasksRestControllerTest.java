package com.AppAquitecture.MyTasks;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import com.fasterxml.jackson.databind.ObjectMapper;
 
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@AutoConfigureMockMvc
public class TasksRestControllerTest {
	@Mock
	private TasksService service = new TasksService();
	private static final Logger logger = LoggerFactory.getLogger(TasksRestControllerTest.class);
	private String apiRootPath = "http://localhost:8080";
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    ObjectMapper objectmapper;
    
    @Test
    public void testGetDescription() throws Exception {
        String response = mockMvc.perform(get(apiRootPath +"/tasks/{id}/", 3))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.description", is("Asucares")))
                .andReturn().getResponse().getContentAsString();
 
        logger.info("response: " + response);
    }
    
    @Test
    public void testAddNewTask() throws Exception {
    	Tasks task = new Tasks(4,"","");
//		Mockito.when(service.saveOrUpdate(task)).thenReturn(
//				task
//				);	
    	String taskjson = "{\"task_state\":\"Pending\",\"description\":\"test_description\"}";
        logger.info(apiRootPath);
        
        //Por alguna razón al crear se devuelve un response status 200(OK) y no un 201(Creación)
        String response = mockMvc.perform(post(apiRootPath + "/tasks/")
                .content(taskjson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(HttpStatus.CREATED.value()))
//        		.andExpect(status().is(HttpStatus.OK.value()))
                .andReturn().getResponse().getContentAsString();
        assertEquals(response, "4 | Pending | test_description");
        logger.info(response);
    }
 
}