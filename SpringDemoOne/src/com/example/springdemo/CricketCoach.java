package com.example.springdemo;

public class CricketCoach implements Coach {
	
	private FourtuneService fourtuneService;
	
	public CricketCoach() {
		System.out.println("Inside no args constructor");
	}
	
	public void setFourtuneService(FourtuneService fourtuneService) {
		System.out.println("Inside the set Fourtune Service Method");
		this.fourtuneService = fourtuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "get 2hrs of batting practise";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fourtuneService.getFortune();
	}

}
