package com.example.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimCoachConfig {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportsConfig.class);
		
		//Coach coach = context.getBean("swimCoach", Coach.class);
		
		SwimCoach coach = context.getBean("swimCoach", SwimCoach.class);
		
		System.out.println("The team's email addr is "+coach.getEmail());
		
		System.out.println("The team's name is "+coach.getTeam());
		
		System.out.println(coach.getDailyFortune());
		
		System.out.println(coach.getDailyWorkout());

	}

}
