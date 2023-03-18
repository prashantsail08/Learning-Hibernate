package com.tut;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// entity means it will create table automatically
@Entity //(name="student_details") to change entity name, now it will create student_details table
//@Table // same as above
public class Student {
	@Id //primary key 
	private int id;
	private String name;
	private String city;
	
	public Student(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return this.id+" : "+this.name+" : "+this.city;
	}
	
	
}
