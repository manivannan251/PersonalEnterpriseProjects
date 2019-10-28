package com.example.hibernate.criteria.examples;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.example.hibernate.object.types.Messages;

public class CriteriaExample {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		Criteria cri = ses.createCriteria(Messages.class);
		cri.add(Restrictions.eq("id", 5));
		List<Messages> mesList = cri.list();
		mesList.forEach(System.out::println);
		ses.getTransaction().commit();
		ses.close();
		

	}

}
