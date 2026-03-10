package com.ptm.personaltaskmanager.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;

import com.ptm.personaltaskmanager.model.Tasks;

public interface ReadTasksRepository extends JpaRepository<Tasks, Integer>{
    List<Tasks> findByUsername(String username);
}
