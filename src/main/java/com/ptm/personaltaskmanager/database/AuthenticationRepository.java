package com.ptm.personaltaskmanager.database;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ptm.personaltaskmanager.model.Users;

public interface AuthenticationRepository extends JpaRepository<Users, String>{
	Optional<Users> findByUsername(String username);
}
