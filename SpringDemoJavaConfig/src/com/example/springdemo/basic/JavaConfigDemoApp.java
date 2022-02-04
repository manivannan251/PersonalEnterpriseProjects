package com.example.springdemo.basic;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.springdemo.Coach;
import com.example.springdemo.SportsConfig;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportsConfig.class);
		
		Coach coach = context.getBean("singCoach", Coach.class);
		
		System.out.println(coach.getDailyFortune());
		
		System.out.println(coach.getDailyWorkout());
	}

}
