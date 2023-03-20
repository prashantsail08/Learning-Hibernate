package com.tut.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyFetchData {
public static void main(String[] args) {
	Configuration cfg = new Configuration();
	cfg.configure("hibernateOneToMany.cfg.xml");
	SessionFactory factory = cfg.buildSessionFactory();
	Session session = factory.openSession();


	QuestionOneToMany q= (QuestionOneToMany)session.get(QuestionOneToMany.class, 1212);
	System.out.println(q.getQuestion());
	for(AnswerOneToMany a: q.getAnswerOneToManies())
	{
		System.out.println(a.getAnswer());
	}
	
	session.clear();
	factory.close();
}
}
