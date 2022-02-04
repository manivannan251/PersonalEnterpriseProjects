package com.example.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanProcessDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new 
				ClassPathXmlApplicationContext("applicationContext.xml");	
				
		// retrieve bean from spring container
		Coach theCoach = context.getBean("wrestlingCoach", Coach.class);

		System.out.println("Daily workout: " + theCoach.getDailyWorkout());
		
		System.out.println("Daily fortune: " + theCoach.getDailyFortune());

		// close the context
		context.close();

	}

}
