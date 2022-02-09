package com.draggerco.hibernate.mapping.manytomany.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@ManyToMany(
			fetch = FetchType.LAZY, 
			cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,	CascadeType.REFRESH }
	)
	@JoinTable(
			name = "course_student", 
			joinColumns = @JoinColumn(name = "student_id"), 
			inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<Course> courses;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id = 0;

	@Column(name = "last_name")
	private String lastName;

	public Student() {
	}

	public Student(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public int getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

}
