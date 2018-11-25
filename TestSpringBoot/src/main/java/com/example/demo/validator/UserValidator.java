package com.example.demo.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.example.demo.model.User;

@Component
public class UserValidator {
	
	public Boolean validateUser(User user) {
		if(StringUtils.isEmpty(user.getFirstName())
				|| StringUtils.isEmpty(user.getEmail())
				|| StringUtils.isEmpty(user.getPassword())) {
			return Boolean.FALSE;
		}
		
		if(!StringUtils.isEmpty(user.getEmail()) && !validateEmail(user.getEmail())) {
			return Boolean.FALSE;
		}
		
		if(!StringUtils.isEmpty(user.getPassword()) && !validatePassword(user.getPassword())) {
			return Boolean.FALSE;
		}
		
		
		return Boolean.TRUE;
	}

	private Boolean validateEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                "[a-zA-Z0-9_+&*-]+)*@" + 
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                "A-Z]{2,7}$"; 
                  
		Pattern pat = Pattern.compile(emailRegex);
		if (email == null) {
			return false;
		}
		return pat.matcher(email).matches();
		
	}
	
	private Boolean validatePassword(String password) {
		String passwordRegex= "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
		
		/*^                 # start-of-string
		(?=.*[0-9])       # a digit must occur at least once
		(?=.*[a-z])       # a lower case letter must occur at least once
		(?=.*[A-Z])       # an upper case letter must occur at least once
		(?=.*[@#$%^&+=])  # a special character must occur at least once
		(?=\S+$)          # no whitespace allowed in the entire string
		.{8,}             # anything, at least eight places though
		$                 # end-of-string*/
		Pattern pat = Pattern.compile(passwordRegex);
		return pat.matcher(password).matches();
		
		
	}

}
