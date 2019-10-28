package com.example.hibernate.cache.examples;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.UserDetails;

public class QueryCacheDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		Query q1 = ses.createQuery("from UserDetails where id=1");
		q1.setCacheable(true);
		List<UserDetails> q1List= q1.list();
		ses.getTransaction().commit();
		ses.close();
		
		
		
		Session ses2 = sf.openSession();
		ses2.beginTransaction();
		Query q2 = ses2.createQuery("from UserDetails where id=1");
		q2.setCacheable(true);
		List<UserDetails> q2List= q2.list();
		ses2.getTransaction().commit();
		ses2.close();
		System.out.println("Line 29");

	}

}
