package com.example.springdemo;

import org.springframework.stereotype.Component;

@Component("ttCoach")
public class TTCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "practise server and smash";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
