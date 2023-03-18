package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Hello World!");
//        interface ... we cant create new SessionFactory bcz its an interface so we need class
//		SessionFactory factory = new Configuration().configure().buildSessionFactory(); // buildSessionFactory(); it
		// will return session to
		// factory

//        it is a connection with help of it we can take sessions, and with the help of sessions we can save etc. it is a thread save object, for one project only one SeesionFactory must there. By using SessionFactory it will give session and session will help to save data, to save objects

//      3  Steps
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); // if the file is not present in same file path.
		SessionFactory factory = cfg.buildSessionFactory();

//		System.out.println(factory);
//		System.out.println(factory.isClosed());

		// creating Student Object
		Student st = new Student();
		st.setId(101);
		st.setName("Prasha");
		st.setCity("Mumbai");
		System.out.println(st);

		// creating Object of Address
		Address ad = new Address();
		ad.setStreet("street1");
		ad.setCity("Mumbai");
		ad.setOpen(true);
		ad.setAddDate(new Date());
		ad.setX(1234.1234);

		// reading image
		FileInputStream fis = new FileInputStream("src/main/java/githublogo.png");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		ad.setImage(data);
		
		// we wanted session
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction(); // we tell session to begin transaction and it will store in tc
		session.save(st); // and then save st object
		session.save(ad);

		tx.commit(); // and then commit
		session.close();
		System.out.println("Done");
	}
}
