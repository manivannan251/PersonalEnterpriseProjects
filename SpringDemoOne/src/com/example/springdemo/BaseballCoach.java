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
	
	public void myInitmethod() {
		System.out.println("Inside Baseball Coach init method");
	}
	
	public void myDestroyMethod() {
		System.out.println("Inside Baseball Coach destroy method");
	}
}
