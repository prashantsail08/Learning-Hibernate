package com.tut.OneToOne;



import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneApp {
public static void main(String[] args) {
	Configuration cfg = new Configuration();
	cfg.configure("hibernateOneToOne.cfg.xml");
	SessionFactory factory = cfg.buildSessionFactory();
	
	Question q1 = new Question();
	q1.setQuestionId(1);
	q1.setQuestion("What is Java ?");
//	q1.setAnswer();
	
	Answer ans = new Answer();
	ans.setAnswerId(12);
	ans.setAnswer("Java is Programming Language");
	ans.setQuestion(q1);
	
	Session session = factory.openSession();
	Transaction tx = session.beginTransaction();	
	
	session.save(q1);
	session.save(ans);
	
	tx.commit();
	
	session.close();
	factory.close();
	
	
}
}
