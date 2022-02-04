package com.example.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class WrestlingCoach implements Coach,DisposableBean {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	@PostConstruct
	private void doMyStartUpStuff() {
		System.out.println("Do 20 minutes of stretching");
	}
	
	@Override
	public String getDailyWorkout() {
		return "100 backflips daily";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	@PreDestroy
	private void beforeLeaving() {
		System.out.println("Do 10 minutes of stertching and keep an ice pack");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Inside destroy method");
		System.out.println("Do 10 minutes of stertching and keep an ice pack");
		
	}

}
