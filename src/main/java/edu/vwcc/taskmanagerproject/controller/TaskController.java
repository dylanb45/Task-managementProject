package edu.vwcc.taskmanagerproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;

import edu.vwcc.taskmanagerproject.model.Task;
import edu.vwcc.taskmanagerproject.service.StatusService;


@Controller
public class TaskController {
	
	private final StatusService statusService;

	public TaskController(StatusService statusService) {
		this.statusService = statusService;
		}
	  
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("tasks",  statusService.getAllTasks());
		return "index.html";
		}
	  
	@GetMapping("/add")
	public String addTask(Model model) {
	  	Task task = new Task();
	    model.addAttribute("task", task);
	    return "add.html";
	    }

	@PostMapping("/add")
	public String addedTask(@ModelAttribute Task task, Model model) {
		  
		statusService.save(task);
	    return "redirect:/";
		}

	@GetMapping("/edit/{id}")
	public String editTask(@PathVariable long id, Model model) {

		model.addAttribute("task", statusService.findTaskbyID(id));
		return "edit.html";
	    }

	@PostMapping("/edit/{id}")
	public String updatedTask(@PathVariable long id, @Valid @ModelAttribute Task task) {

		task.setId(id);

		statusService.save(task);
		return "redirect:/";
	    }

	@PostMapping("/delete/{id}")
	public String deletedTask(@PathVariable long id) {
	    	

		statusService.deletebyID(id);
		return "redirect:/";
	    }

}
