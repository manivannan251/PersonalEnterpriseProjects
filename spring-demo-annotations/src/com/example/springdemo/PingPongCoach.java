package com.example.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PingPongCoach implements Coach {
	
	private FortuneService fortuneService;
	
	@Autowired
	public PingPongCoach(@Qualifier("fileFortuneService") FortuneService fortuneService) {
		System.out.println("Inside def con of Ping Pong Coach");
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice your pingpong drop shot";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
