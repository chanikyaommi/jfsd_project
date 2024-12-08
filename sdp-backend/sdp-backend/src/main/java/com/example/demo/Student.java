package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.UniqueConstraint;

@Entity
public class Student {
    @Id
    private String email;
    private String fullName;
    private String idNumber;
    private String password;
    private String role = "student"; // Default role set to "student"

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role; // Provide a getter for the role
    }
    
    // Optionally, you can set the role from outside, but it defaults to "student"
    public void setRole(String role) {
        this.role = role;
    }

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
}
