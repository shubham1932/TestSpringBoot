package com.example.demo.model;

import javax.annotation.Generated;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document
public class User {
	
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	
	@Id
	@Generated(value = { "233645" })
	private String UID;

}
