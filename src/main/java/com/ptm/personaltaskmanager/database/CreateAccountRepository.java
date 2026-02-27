package com.ptm.personaltaskmanager.database;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ptm.personaltaskmanager.model.Users;

@Repository
public interface CreateAccountRepository extends JpaRepository<Users, String>{
	//Will leverage find by method in our createAccountService, we will check if user exists and throw an exception via this line of code.
	Optional<Users> findByUsername(String username);
}
