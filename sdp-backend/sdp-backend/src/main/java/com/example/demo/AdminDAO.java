package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class AdminDAO {
	@Autowired
	AdminInterface adminRepo;
	
	@Autowired
	StudentInterface studentrepo;
	
	@Autowired
	ClubInterface clubRepo;
	
	public Admin findByEmail(String email)
	{
		return adminRepo.findByEmail(email);
	}

	 public Admin findUser(String email)
		{
			return adminRepo.findByEmail(email);
		}
	 
	 public Student addStudent(Student student)
	 {
		 return studentrepo.save(student);
	 }
	 
	 public List<Student> getAllStudents()
	 {
		 return studentrepo.findAll();
	 }
	 public Student findByEmailStudent(String email) {
	        return studentrepo.findByEmail(email);
	    }
	 public Student updateStudent(Student student) {
	        return studentrepo.save(student);  // Save will update if the student entity has an ID
	    }
	 
	 public void deleteStudent(String email)
	 {
		 studentrepo.delete(studentrepo.findByEmail(email));
	 }
	 
	 public Club addClub( Club club)
	 {
			 return clubRepo.save(club);
				
	 }
	 
	 public List<Club> getAllClubs()
	 {
		 return clubRepo.findAll();
	 }

	public void updateClub(Club club) {
		// TODO Auto-generated method stub
		clubRepo.save(club);
		
	}

	public void deleteClub(Club club) {
		// TODO Auto-generated method stub
		clubRepo.delete(club);
		
	}
	 
	 
	
	 
}
