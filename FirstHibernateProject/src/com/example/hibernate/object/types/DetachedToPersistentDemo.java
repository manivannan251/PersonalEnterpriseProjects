package com.example.hibernate.object.types;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DetachedToPersistentDemo {

	public static void main(String[] args) {
		Messages mes = new Messages();
		mes.setMessage("First Message");
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		ses.save(mes);
		ses.getTransaction().commit();
		ses.close();
		Session secondSes = sf.openSession();
		secondSes.beginTransaction();
		Messages mesFromDb = secondSes.get(Messages.class, 1);
		secondSes.getTransaction().commit();
		secondSes.close();
		mesFromDb.setMessage("Second Message");
		Session tses = sf.openSession();
		tses.beginTransaction();
		tses.update(mesFromDb);
		tses.getTransaction().commit();
		tses.close();

	}

}
