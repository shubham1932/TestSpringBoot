package com.example.demo.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.enums.RoleTypeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User implements Serializable {
	
	private static final long serialVersionUID = -7821782589422453919L;
	
	@Id
	private String uid;
	
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	private String role;
	private String organization;
	private String userDescription;
	
	private String errorMessage;
	

}
