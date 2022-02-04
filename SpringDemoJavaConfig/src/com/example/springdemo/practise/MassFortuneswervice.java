package com.example.springdemo.practise;

import com.example.springdemo.FortuneService;

public class MassFortuneswervice implements FortuneService {

	@Override
	public String getFortune() {
		return "today is your mass day";
	}

}
