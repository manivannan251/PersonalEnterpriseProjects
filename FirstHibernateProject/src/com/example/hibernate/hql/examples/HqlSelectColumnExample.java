package com.example.hibernate.hql.examples;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HqlSelectColumnExample {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		Query q = ses.createQuery("select message from Messages");
		q.setFirstResult(4);
		q.setMaxResults(2);
		List<String> mess = q.list();
		mess.forEach(System.out::println);
		ses.getTransaction().commit();
		ses.close();

	}

}
