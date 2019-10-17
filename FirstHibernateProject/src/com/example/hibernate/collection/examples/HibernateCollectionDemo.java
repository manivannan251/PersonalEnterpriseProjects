package com.example.hibernate.collection.examples;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateCollectionDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session ses = sf.openSession();
		AddressCollection addr = new AddressCollection();
		addr.setStreet("vivek street");
		addr.setCity("chennai");
		addr.setState("TN");
		AddressCollection offAddr = new AddressCollection();
		offAddr.setStreet("madivala street");
		offAddr.setCity("bangalore");
		offAddr.setState("KN");
		UserDetailsCollection udc = new UserDetailsCollection();
		udc.setName("Goku");
		udc.getAddresList().add(addr);
		udc.getAddresList().add(offAddr);
		AddressCollection addr2 = new AddressCollection();
		addr2.setStreet("madivala street");
		addr2.setCity("bangalore");
		addr2.setState("KN");
		UserDetailsCollection udc2 = new UserDetailsCollection();
		udc2.setName("Gohan");
		udc2.getAddresList().add(addr2);
		ses.beginTransaction();
		ses.save(udc);
		ses.save(udc2);
		ses.getTransaction().commit();
		ses.close();
		

	}

}
