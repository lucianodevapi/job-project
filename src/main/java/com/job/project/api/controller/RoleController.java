package com.job.project.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.project.api.enums.ERole;
import com.job.project.api.model.Role;
import com.job.project.api.repository.RoleRepository;
import com.job.project.api.request.RoleRequest;
import com.job.project.api.response.MessageResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/role")
public class RoleController {

	@Autowired
	RoleRepository roleRepository;

	@PostMapping("/add")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody RoleRequest request) {

		Role entity = toEntity(request);
		roleRepository.save(entity);
		return ResponseEntity.ok(new MessageResponse("Role registered successfully!"));
	}

	private Role toEntity(RoleRequest request) {
		Role entity = new Role();
		String role = request.getName();
		switch (role) {
		case "admin":
			entity.setName(ERole.ROLE_ADMIN);
			break;
		case "mod":
			entity.setName(ERole.ROLE_MODERATOR);
			break;
		case "user":
			entity.setName(ERole.ROLE_USER);
			break;
		default:
			entity.setName(ERole.ROLE_USER);
		}
		return entity;
	}
}
