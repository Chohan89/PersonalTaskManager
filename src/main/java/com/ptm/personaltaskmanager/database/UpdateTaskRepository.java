package com.ptm.personaltaskmanager.database;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ptm.personaltaskmanager.model.Tasks;

public interface UpdateTaskRepository extends JpaRepository<Tasks, Integer>{
	Optional<Tasks> findByTaskNumber(Integer taskNumber);
}
