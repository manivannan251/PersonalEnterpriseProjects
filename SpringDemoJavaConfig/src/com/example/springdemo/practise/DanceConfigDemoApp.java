package com.example.springdemo.practise;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.springdemo.Coach;

public class DanceConfigDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new 
				AnnotationConfigApplicationContext(DanceConfig.class);
		
		Coach coach = context.getBean("getDanceCoach", Coach.class);
		
		System.out.println(coach.getDailyFortune());
		
		System.out.println(coach.getDailyWorkout());
		
		context.close();

	}

}
