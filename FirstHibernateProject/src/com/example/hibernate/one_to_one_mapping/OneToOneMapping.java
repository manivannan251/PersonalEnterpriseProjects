package com.example.hibernate.one_to_one_mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneMapping {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session ses = sf.openSession();
		Customer cust = new Customer();
		cust.setName("Trunks");
		Account acc = new Account();
		acc.setAccountNo("123");
		cust.setAccount(acc);
		ses.beginTransaction();
		ses.save(cust);
		ses.save(acc);
		ses.getTransaction().commit();
		ses.close();

	}

}
