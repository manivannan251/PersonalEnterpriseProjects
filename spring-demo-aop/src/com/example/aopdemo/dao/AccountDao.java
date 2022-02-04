package com.example.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.example.aopdemo.Account;

@Component
public class AccountDao {
	
	public void addAccount(Account account,boolean isVip,String name) {
		
		System.out.println(getClass()+" : Doing db work: Adding Account");
	}
	
	
	public void doSomeWork() {
		System.out.println(getClass()+" : Calculating account balance");
	}

}
