package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;

public class CreateStudemtDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = sf.openSession();
		
		Student student = new Student("Goku", "Henry", "del@gmail.com");
		
		session.beginTransaction();
		
		session.save(student);
		
		session.getTransaction().commit();
		
		sf.close();

	}

}
