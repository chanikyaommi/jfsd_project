package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminInterface extends JpaRepository<Admin, String> {
	
	
	 Admin findByEmail(String email);
	 
	 
}
