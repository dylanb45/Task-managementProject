package edu.vwcc.taskmanagerproject.repository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.vwcc.taskmanagerproject.model.Task;

@Repository
public interface StatusRepository extends CrudRepository<Task, Long> {
	
	@Modifying
	@Query("update Task set status = :status where id = :id")
	void changeStatus(long id, String status);
	
	@Modifying
	@Query("update Task set date = :date where id = :id")
	void changeDate(long id, String date);
	
	@Modifying
	@Query("update Task set name = :name where id = :id")
	void changeName(long id, String name);
	
	@Modifying
	@Query("delete from Task WHERE id = :id")
	void deletebyID(int id);
	

}
