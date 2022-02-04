package com.example.springdemo;

import org.springframework.stereotype.Component;

@Component("restFortuneService")
public class RESTFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Example of first two char being caps";
	}

}
