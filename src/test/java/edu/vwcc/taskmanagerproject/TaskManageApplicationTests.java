package edu.vwcc.taskmanagerproject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import java.time.LocalDate;

import edu.vwcc.taskmanagerproject.model.Task;
import edu.vwcc.taskmanagerproject.repository.StatusRepository;
import edu.vwcc.taskmanagerproject.service.StatusService;

@SpringBootTest
@AutoConfigureMockMvc
class TaskManageApplicationTests {
	
	@Autowired private MockMvc mockMvc;
    @Autowired private StatusRepository repository;
    @Autowired private StatusService service;

    @Test
	void contextLoads() {
		assertThat(repository).isNotNull();
        assertThat(service).isNotNull();
        }
	
	 @Test
	 void homeLoads() throws Exception {
	    mockMvc.perform(get("/"))
	    .andExpect(status().isOk())
	    .andExpect(view().name("index.html"));
	    }
	 
	 @Test
	 void tasksLoads() throws Exception {
	    mockMvc.perform(get("/"))
	    .andExpect(status().isOk())
	    .andExpect(view().name("index.html"))
	    .andExpect(model().attributeExists("tasks"));
	    }
	 
	 @Test
	 void formsLoad() throws Exception {
		 mockMvc.perform(get("/add"))
	     .andExpect(status().isOk())
	     .andExpect(view().name("add.html"))
	     .andExpect(model().attributeExists("task"));
	 
		 mockMvc.perform(get("/edit/1"))
	     .andExpect(status().isOk())
	     .andExpect(view().name("edit.html"))
	     .andExpect(model().attributeExists("task"));
		 }
	 
	 @Test
	 void findsTaskbyID() {
		 Task task = new Task();
	     task.setName("Test Task");
	     task.setDate(LocalDate.parse("2026-01-01")); 
	     task.setStatus("In Progress");

	     service.save(task);

	     assertThat(service.findTaskbyID(task.getId()));
	     }
	 
	 @Test
	 void deletesTask() {
		 Task task = new Task();
	     task.setName("Test Task");
	     task.setDate(LocalDate.parse("2026-01-01")); 
	     task.setStatus("In Progress");

	     service.save(task);

	     service.deletebyID(task.getId());
	     }

}
