package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentInterface extends JpaRepository<Student, String> {
	Student findByEmail(String email);

}
