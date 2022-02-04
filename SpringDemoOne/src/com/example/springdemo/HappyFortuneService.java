package com.example.springdemo;

public class HappyFortuneService implements FourtuneService {

	@Override
	public String getFortune() {
		return "Today is your lucky day";
	}

}
