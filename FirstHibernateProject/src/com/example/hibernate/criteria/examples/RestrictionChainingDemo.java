package com.example.hibernate.criteria.examples;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.example.hibernate.object.types.Messages;

public class RestrictionChainingDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		Criteria cri = ses.createCriteria(Messages.class);
		//cri.add(Restrictions.gt("id", 4)).add(Restrictions.lt("id", 10));
		//using or in criteria example
		cri.add(Restrictions.or(Restrictions.lt("id", 3), Restrictions.gt("id", 7)));
		List<Messages>mesList = cri.list();
		mesList.forEach(System.out::println);
		ses.getTransaction().commit();
		ses.close();

	}

}
