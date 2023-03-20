package com.ManyToMany;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MappingDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernateManyToMany.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		//min 2 emps 
		Emp e1 = new Emp();
		e1.setEid(34);
		e1.setName("Prashant");
		
		Emp e2 = new Emp();
		e2.setEid(35);
		e2.setName("Prasha");
		
		Project p1 = new Project();
		Project p2 = new Project();
		p1.setPid(11);
		p1.setProjectName("Lib Management");
		p2.setPid(12);
		p2.setProjectName("Chat Bot");
		
		List<Emp> list1 = new ArrayList<Emp>();
		List<Project> list2 = new ArrayList<Project>();
		
		list1.add(e1);
		list1.add(e2);
		
		list2.add(p1);
		list2.add(p2);
		
		e1.setProjects(list2); //e1 has assign 2 projects
		p2.setEmps(list1); //p2 has assign 2 emp
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		
		s.save(e1);
		s.save(e2);
		s.save(p1);
		s.save(p2);
		
		tx.commit();
 		
		s.close();
		factory.close();
	}

}
