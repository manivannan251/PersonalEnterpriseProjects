package com.example.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportsConfig.class);
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		System.out.println(theCoach.getDailyWorkout());
		Coach ttCoach = context.getBean("ttCoach",Coach.class);
		System.out.println(ttCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		context.close();


	}

}
