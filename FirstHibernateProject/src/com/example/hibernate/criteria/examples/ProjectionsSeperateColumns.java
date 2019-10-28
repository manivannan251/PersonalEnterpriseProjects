package com.example.hibernate.criteria.examples;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.example.hibernate.UserDetails;

public class ProjectionsSeperateColumns {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		Criteria cri = ses.createCriteria(UserDetails.class);
		ProjectionList projList = Projections.projectionList();
		projList.add(Projections.property("name"));
		projList.add(Projections.property("description"));
		cri.setProjection(projList);
		   
		
		List<Object[]> nameAndDescList = cri.list();
		nameAndDescList.forEach(ProjectionsSeperateColumns::printMap);
		//nameAndDescList.forEach(System.out::println);
		ses.getTransaction().commit();
		ses.close();
	}
	
	private static void printMap(Object[] objects) {
		System.out.println("Name is "+objects[0]+"---"+"Finisher "+objects[1]);
	}

}
