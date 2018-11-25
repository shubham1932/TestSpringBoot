package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserListResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4925520731527350260L;
	private int count;
	private List<User> userList;
	private String errorMessage;

}
