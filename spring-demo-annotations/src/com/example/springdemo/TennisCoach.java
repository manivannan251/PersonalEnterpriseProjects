package com.example.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TennisCoach implements Coach {
	
	@Autowired
	//@Qualifier("happyFortuneService")
	//@Qualifier("randomFortuneService")
	@Qualifier("restFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println(">>TennisCoach: Inside default constructor");
	}
	
	//@Autowired
	/*
	 * public TennisCoach(FortuneService fortuneService) { this.fortuneService =
	 * fortuneService;
	 * 
	 * }
	 */
	
	
	/*
	 * @Autowired public void setFortuneService(FortuneService fortuneService) {
	 * System.out.println(">>TennisCoach: Inside set method"); this.fortuneService =
	 * fortuneService; }
	 */
	
	/*
	 * @Autowired public void doSomeCrazyStuff(FortuneService fortuneService) {
	 * System.out.println(">>TennisCoach: Inside doSomeCrazyStuff method");
	 * this.fortuneService = fortuneService; }
	 */
	
	@Override
	public String getDailyWorkout() {
		
		return "Practise back hand volley";
	}
	
	
	@PostConstruct
	private void doStartUpStuff() {
		System.out.println(">>>TennisCoach Inside the doStartUpStuff");
	}
	
	@PreDestroy
	private void doCleanUpStuff() {
		System.out.println(">>>TennisCoach Inside the doCleanUpStuff");
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
