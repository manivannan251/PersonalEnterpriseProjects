package com.example.springdemo.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springdemo.Coach;
import com.example.springdemo.FortuneService;

@Component
public class SingCoach implements Coach {
	
	@Autowired
	private FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		return "Practise daily vocal chord practise";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
