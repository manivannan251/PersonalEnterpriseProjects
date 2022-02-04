package com.example.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanscope-applicationContext.xml");
		
		Coach theCoach = context.getBean("myCoach",Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach",Coach.class);
		
		boolean result = (theCoach==alphaCoach);
		
		System.out.println("Pointing to same reference "+result);
		
		System.out.println("Memory Location of theCoach "+theCoach);
		
		System.out.println("Memory Location of alphaCoach "+alphaCoach);
		
		context.close();

	}

}
