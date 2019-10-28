package com.example.hibernate.cache.examples;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.UserDetails;

public class FirstLevelCacheDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		UserDetails ud1 = ses.get(UserDetails.class, 2);
		
		ud1.setAddress("HS");
		System.out.println("Line 18");
	
		ses.getTransaction().commit();
		ses.close();
		//ud1.setAddress("CN");
		System.out.println("Line 23");
		Session ses2 = sf.openSession();
		ses2.beginTransaction();
		UserDetails ud2 = ses2.get(UserDetails.class, 2);
		ses2.getTransaction().commit();
		ses2.close();
		System.out.println("Line 29");

	}

}
