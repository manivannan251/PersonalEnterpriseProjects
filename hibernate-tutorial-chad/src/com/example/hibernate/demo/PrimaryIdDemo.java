package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;

public class PrimaryIdDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = sf.openSession();
		
		Student student1 = new Student("Goku", "Henry", "del@gmail.com");
		Student student2 = new Student("Matt", "Henry", "Matt@gmail.com");
		Student student3 = new Student("Rinku", "Henry", "rinku@gmail.com");
		
		session.beginTransaction();
		
		session.save(student1);
		session.save(student2);
		session.save(student3);
		
		session.getTransaction().commit();
		
		sf.close();

	}

}
