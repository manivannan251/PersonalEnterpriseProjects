package com.example.hibernate.hql.examples;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.object.types.Messages;

public class NamedParameterExample {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		//Example for Named Query
		//Query q = ses.getNamedQuery("Messages.id");
		//q.setInteger(0, 4);
		//Example for Native Named query
		Query q = ses.getNamedSQLQuery("Messages.name");
		q.setString(0, "F%");
		List<Messages> mesList = q.list();
		ses.getTransaction().commit();
		ses.close();
		
		mesList.forEach(System.out::println);

	}

}
