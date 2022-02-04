package com.example.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	private String[] getFortunes = {
			"Vaimayae vellum",
			"Routhiram palaghu",
			"Restvuyio ingardiukm"
	};
	
	private Random myRandom = new Random();
		
	@Override
	public String getFortune() {
		int index = myRandom.nextInt(getFortunes.length);
		return getFortunes[index];
		
	}

}
