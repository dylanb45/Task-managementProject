package edu.vwcc.taskmanagerproject.service;

import org.springframework.stereotype.Service;

import edu.vwcc.taskmanagerproject.model.Task;
import edu.vwcc.taskmanagerproject.repository.StatusRepository;

@Service
public class StatusService {
		private final StatusRepository statusRepository;

		public StatusService(StatusRepository statusRepository) {
			this.statusRepository = statusRepository;
		}
	  
		public Iterable<Task> getAllTasks() {
			return statusRepository.findAll();
		}
		
		public Task findTaskbyID(long id) {
		    return statusRepository.findById(id).get();
		}
		
		public void deletebyID(long id) {
		    statusRepository.deleteById(id);
		}
		
		public void save(Task task) {
	        statusRepository.save(task);
	    }
}
