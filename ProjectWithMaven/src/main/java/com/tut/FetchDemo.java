package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	public static void main(String[] args) {
		// get , load ....to get data

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		//get student -101
		Student student =(Student)session.get(Student.class, 101); //it will give object and that object we will store in studnet
//		Student student =(Student)session.load(Student.class, 101);
		System.out.println(student);
		
		Address ad = (Address)session.get(Address.class, 1);
		System.out.println(ad.getStreet()+" : "+ ad.getCity());
		//transaction is to save data;
				
		
		factory.close();
		
		
		
	}
}
