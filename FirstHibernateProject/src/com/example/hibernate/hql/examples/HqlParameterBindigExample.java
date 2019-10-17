package com.example.hibernate.hql.examples;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.object.types.Messages;

public class HqlParameterBindigExample {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session ses = sf.openSession();
		
		System.out.println("Enter which message you want");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		ses.beginTransaction();
		//Query query = ses.createQuery("from Messages where id>?0");
		//query.setInteger(0, id);
		//Get using another method
		Query query = ses.createQuery("from Messages where id=:mesid");
		query.setInteger("mesid", id);
		List<Messages> mesList = query.list();
		ses.getTransaction().commit();
		ses.close();
		mesList.forEach(System.out::println);
		

	}

}
