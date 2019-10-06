package com.example.springdemo;

public class BaseballCoach implements Coach {
	
	private FourtuneService fs;
	
	BaseballCoach(FourtuneService fsi) {
		fs = fsi;
	}
	
	public String getDailyWorkout() {
		return "get 30mins of batting practise";
	}

	@Override
	public String getDailyFortune() {
		return fs.getFortune();
	}
}
