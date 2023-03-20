package com.tut.OneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.OneToOne.Answer;
import com.tut.OneToOne.Question;

public class OneToManyApp {
	public static void main(String[] args) {


		Configuration cfg = new Configuration();
		cfg.configure("hibernateOneToMany.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		QuestionOneToMany q1 = new QuestionOneToMany();
		q1.setQuestionId(1212);
		q1.setQuestion("What is Java ?");
		
		AnswerOneToMany ans = new AnswerOneToMany();
		ans.setAnswerId(343);
		ans.setAnswer("Java is Programming Language");
		ans.setQuestion(q1);
		
		//now we can keep multiple answer in question

		AnswerOneToMany ans1 = new AnswerOneToMany();
		ans1.setAnswerId(33);
		ans1.setAnswer("with the help of Java we can create Softwares");
		ans1.setQuestion(q1);
		

		AnswerOneToMany ans2 = new AnswerOneToMany();
		ans2.setAnswerId(34);
		ans2.setAnswer("Java has different types of framework");
		ans2.setQuestion(q1);
	
		// now to have to add 2 questio in a list
		List<AnswerOneToMany> list = new ArrayList<AnswerOneToMany>();
		list.add(ans);
		list.add(ans1);
		list.add(ans2);
		
		//now we will add this list in out question
		q1.setAnswerOneToManies(list); //now 1 question has many answer set.

		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();	
//save
		//now we are saving our question
		s.save(q1);
		s.save(ans);
		s.save(ans1);
		s.save(ans2);
	

		tx.commit();

//		//fetching
//		QuestionOneToMany q= (QuestionOneToMany)s.get(QuestionOneToMany.class, 242);
//		System.out.println(q.getQuestion());
//		System.out.println(q.getAnswerOneToManies().ge);
		
		
		
		s.close();
		factory.close();

	}
}