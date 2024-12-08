package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class LoginController {
	
	@Autowired
	StudentDAO studentDao;
	
	@Autowired
	AdminDAO adminDao;
	
	@PostMapping("/login")
	public Object login(@RequestBody Map<String, String> credentials) {
	    String email = credentials.get("email");
	    String password = credentials.get("password");

	    Student st = studentDao.findByEmail(email);
	    Admin at = adminDao.findByEmail(email);
	    System.out.println("admin : "+at);

	    if (st != null && st.getPassword().equals(password)) {
	    	System.out.println("student");
	        return st;
	    } else if (at != null && at.getPassword().equals(password)) {
	        return at;
	    } else {
	        return null; 
	    }
	}

}
