package com.example.hibernate.criteria.examples;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;

import com.example.hibernate.UserDetails;

public class UsingQueryByExampleDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session ses  = sf.openSession();
		UserDetails ud = new UserDetails();
		ud.setAddress("CN");
		Example eg = Example.create(ud);
		ses.beginTransaction();
		Criteria cri = ses.createCriteria(UserDetails.class).add(eg);
		List<UserDetails> userList = cri.list();
		userList.forEach(UsingQueryByExampleDemo::printWrestle);
		ses.getTransaction().commit();
		ses.close();
		

	}
	
	private static void printWrestle(UserDetails ud) {
		System.out.println("Name "+"-----"+ud.getName()+","+"Addr "+"----"+ud.getAddress());
	}

}
