package com.example.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HiberNateAutoGenerateIdDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		UserDetailsId udi = new UserDetailsId();
		udi.setName("Mani");
		UserDetailsId udi2 = new UserDetailsId();
		udi2.setName("Indhu");
		session.beginTransaction();
		session.save(udi);
		session.save(udi2);
		session.getTransaction().commit();
		session.close();

	}

}
