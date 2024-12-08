package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class StudentController {
	
	@Autowired
	StudentDAO studentDao;
	
	
	@PostMapping("/signup")
	  public String signUp(@RequestBody Student student) {
        if (studentDao.findByEmail(student.getEmail()) != null) {
            return "Email already exists";
        }
        studentDao.saveStudent(student);
        return "Student registered successfully";
    }
	

	

}
