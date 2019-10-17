package com.example.hibernate.hql.examples;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.object.types.Messages;

public class HqlExampleDemo1 {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		Query query = ses.createQuery("from Messages");
		query.setFirstResult(5);
		query.setMaxResults(5);
		List<Messages> mesList = query.list();
		ses.getTransaction().commit();
		ses.close();
		System.out.println("The entries in column are "+mesList.size());
		mesList.forEach(System.out::println);

	}

}
