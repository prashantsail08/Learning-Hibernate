package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedDemo {
public static void main(String[] args) {
	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory factory = cfg.buildSessionFactory();
	
	Student student1 = new Student();
	student1.setId(1);
	student1.setName("Don");
	student1.setCity("goa");
	
	Certificate certificate = new Certificate();
	certificate.setCourse("Java");
	certificate.setDuration("6 months");
	student1.setCerti(certificate);
	
	Student student2 = new Student();
	student2.setId(2);
	student2.setName("Abhishek");
	student2.setCity("MUM");
	
	Certificate certificate1 = new Certificate();
	certificate1.setCourse("Web Dev");
	certificate1.setDuration("3 months");
	student2.setCerti(certificate1);
	
	Session s = factory.openSession();
	Transaction tx = s.beginTransaction();
	
	//object save
	s.save(student1);
	s.save(student2);
	
	
	tx.commit();
	s.close();
	factory.close();
}
}
