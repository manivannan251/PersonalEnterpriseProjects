package com.example.hibernate.embedded.examples;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateEmbeddedDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session ses = sf.openSession();
		Address addr = new Address();
		addr.setStreet("vivek street");
		addr.setCity("chennai");
		addr.setState("TN");
		Address offAddr = new Address();
		offAddr.setStreet("madivala street");
		offAddr.setCity("bangalore");
		offAddr.setState("KN");
		UserWithAddress ua = new UserWithAddress();
		ua.setName("BAT");
		ua.setAddress(addr);
		ua.setOfficeAddress(offAddr);
		ses.beginTransaction();
		ses.save(ua);
		ses.getTransaction().commit();
		ses.close();

	}

}
