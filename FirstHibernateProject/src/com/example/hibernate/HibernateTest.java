package com.example.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	private static SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	public static void main(String[] args) {
				
		save(createUserDetails(1, "Becky","Disarmer","CN"));
		save(createUserDetails(2, "Austin","Stunner","TX"));
		save(createUserDetails(3, "Seth","Stomp","CN"));
		save(createUserDetails(4, "Brown","PowerBomb","MS"));
		save(createUserDetails(5, "Cena","F5","BN"));
		save(createUserDetails(6, "Orton","RKO","NV"));
		save(createUserDetails(7, "HHH","Pedigree","TX"));
		save(createUserDetails(8, "Roman","Spear","CA"));
		UserDetails seth = getUserdetails(3);
		System.out.println(seth);
		updateDesc(3, "Pedigree");
		seth = getUserdetails(3);
		System.out.println("After changing finishing move");
		System.out.println(seth);
		//deleteUser(2);		
		
		
	}
	
	static UserDetails getUserdetails(int id) {
		Session session = sf.openSession();
		session.beginTransaction();
		UserDetails ud = session.get(UserDetails.class, id);
		session.getTransaction().commit();
		session.close();
		return ud;
	}
	
	static void updateDesc(int id,String desc) {
		Session ses = sf.openSession();
		ses.beginTransaction();
		UserDetails ud = ses.get(UserDetails.class, id);
		ud.setDescription(desc);
		ses.update(ud);
		ses.getTransaction().commit();
		ses.close();
	}
	
	static void deleteUser(int id) {
		Session ses = sf.openSession();
		ses.beginTransaction();
		UserDetails ud = ses.get(UserDetails.class, id);
		System.out.println("The user going to be deleted "+ud.getName());
		ses.delete(ud);
		ses.getTransaction().commit();
		ses.close();
		
	}
	
	static void save(UserDetails ud) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(ud);
		
		session.getTransaction().commit();
		session.close();
	}
	
	static UserDetails createUserDetails(int id,String name,String desc,String addr) {
		UserDetails ud = new UserDetails();
		ud.setId(id);
		ud.setName(name);
		ud.setJoiningDate(new Date());
		ud.setDescription(desc);
		ud.setAddress(addr);
		return ud;
	}

}
