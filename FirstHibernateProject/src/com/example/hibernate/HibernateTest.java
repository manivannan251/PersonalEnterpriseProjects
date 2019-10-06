package com.example.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetails ud = new UserDetails();
		ud.setId(1);
		ud.setName("Gohan");
		ud.setJoiningDate(new Date());
		ud.setDescription("description");
		ud.setAddress("Earth");
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(ud);
		session.getTransaction().commit();

	}

}
