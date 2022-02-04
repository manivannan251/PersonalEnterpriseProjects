package com.example.springdemo.practise;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.springdemo.Coach;
import com.example.springdemo.FortuneService;

@Configuration
public class DanceConfig {
	
	@Bean
	public FortuneService getFortuneService() {
		return new MassFortuneswervice();
	}
	
	
	@Bean
	public Coach getDanceCoach() {
		return new DanceCoach(getFortuneService());
	}

}
