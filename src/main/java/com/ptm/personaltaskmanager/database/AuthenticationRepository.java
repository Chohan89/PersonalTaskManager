package com.ptm.personaltaskmanager.database;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ptm.personaltaskmanager.model.Users;

@Repository
public interface AuthenticationRepository extends JpaRepository<Users, Integer>{
	Optional<Users> findByUsername(String username);
}
