package com.example.springdemo;

public class CricketCoach implements Coach {
	
	private FourtuneService fourtuneService;
	
	private String team;
	
	private String emailAddress;
	
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

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("Inside the set Team Method");
		this.team = team;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("Inside the set email Address Method");
		this.emailAddress = emailAddress;
	}
	
	

}
