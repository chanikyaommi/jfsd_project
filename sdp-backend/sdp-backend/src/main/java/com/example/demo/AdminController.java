package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin
@RequestMapping("admin/")
public class AdminController {
	
	@Autowired
	AdminDAO adminDao;
	
	@PostMapping("/addStudent")
	public String addStudent(@RequestBody Student stduent)
	{
		if(adminDao.findByEmailStudent(stduent.getEmail())!= null)
		{
			return "Email already exits";
		}
		else
		{
			adminDao.addStudent(stduent);
			return "Student added Successfully";
		}
	}
	
	@GetMapping("/all")
	public List<Student> getAllStudents()
	{
		return adminDao.getAllStudents();
	}
	 @PutMapping("/updateStudent")
	    public String updateStudent(@RequestBody Student student) {
	        if (adminDao.findByEmailStudent(student.getEmail()) == null) {
	            return "Student not found";
	        } else {
	            adminDao.updateStudent(student);
	            return "Student updated successfully";
	        }
	    }
	 
	 @DeleteMapping("/deleteStudent")
	 public String deleteStudent(@RequestBody String email)
	 {
		 if(adminDao.findByEmailStudent(email)!=null)
		 {
			 adminDao.deleteStudent(email);
			 return "Student Deleted Successfully";
		 }
		 else return "Student not found";
	 }
	 
	 
	 @PostMapping("/addClub")
	 public String addClub(@RequestBody Club club)
	 {
		 System.out.println(adminDao.clubRepo.findByName(club.getName()));
		 if(adminDao.clubRepo.findByName(club.getName())==null)
		 {
			 adminDao.addClub(club);
			 return "Club added Successfully";
		 }
		 else return "Club already exits";
	 }
	 
	 @GetMapping("/getAllClubs")
	 public List<Club> getAllClubs()
	 {
		 return adminDao.getAllClubs();
	 }
	 @PutMapping("/updateClub")
	    public String updateClub(@RequestBody Club club) {
	        if (adminDao.clubRepo.findById(club.getId()) == null) {
	            return "Club not found";
	        } else {
	            adminDao.updateClub(club);
	            return "Student updated successfully";
	        }
	    }
	 @DeleteMapping("/deleteClub")
	 public String deleteClub(@RequestBody Club club)
	 {
		 if (adminDao.clubRepo.findById(club.getId()) == null) {
	            return "Club not found";
	        } else {
	            adminDao.deleteClub(club);
	            return "Student updated successfully";
	        }
	 }
	 
	 
}
