package com.job.project.api.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.job.project.api.enums.ERole;
import com.job.project.api.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
	
	Optional<Role> findByName(ERole name);
}
