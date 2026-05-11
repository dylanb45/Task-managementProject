package edu.vwcc.taskmanagerproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.vwcc.taskmanagerproject"})
public class TaskManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManageApplication.class, args);
	}

}
