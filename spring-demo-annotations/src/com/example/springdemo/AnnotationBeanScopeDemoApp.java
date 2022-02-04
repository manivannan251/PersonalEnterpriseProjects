package com.example.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach aplphaCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach betaCoach = context.getBean("tennisCoach", Coach.class);
		
		boolean equals = (aplphaCoach==betaCoach);
		
		System.out.println("Are the two coaches equal "+equals);
		
		System.out.println("Address of the aplha coach object "+aplphaCoach);
		
		System.out.println("Address of the beta coach object "+betaCoach);
		
		context.close();
		
		
	}

}
