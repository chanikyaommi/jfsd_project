package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentDAO {
	@Autowired
	StudentInterface studentRepository;
	 public Student findByEmail(String email) {
		 
	        return studentRepository.findByEmail(email);
	    }

	    public void saveStudent(Student student) {
	        studentRepository.save(student);
	    }
	    public Student findUser(String email)
		{
			return studentRepository.findByEmail(email);
		}
	    
	    

}
