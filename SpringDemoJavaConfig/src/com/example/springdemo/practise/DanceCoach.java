package com.example.springdemo.practise;

import com.example.springdemo.Coach;
import com.example.springdemo.FortuneService;

public class DanceCoach implements Coach {

	private FortuneService fortuneService;
	
	public DanceCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "practise floor movements daily";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
