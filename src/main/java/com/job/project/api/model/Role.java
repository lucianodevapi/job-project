package com.job.project.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.job.project.api.enums.ERole;

@Document(collection = "role")
public class Role {

	@Id
	private String id;

	private ERole name;

	public Role() {
		super();
	}

	public Role(ERole name) {
		super();
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}

}
