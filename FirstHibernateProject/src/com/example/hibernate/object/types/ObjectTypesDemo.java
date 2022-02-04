package com.example.hibernate.object.types;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ObjectTypesDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session ses = sf.openSession();
		Messages mes = new Messages();
		mes.setMessage("Hi There");
		ses.beginTransaction();
		ses.save(mes);
		mes.setMessage("Hello Again");
		ses.getTransaction().commit();
		mes.setMessage("After commit");
		ses.getTransaction().commit();
		ses.close();

	}

}
