package com.example.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MemberShipDao {

		public boolean addMember() {
			System.out.println(getClass()+" : Doing db work: Adding Membership");
			return true;
		}
		
		
		public void doSleep() {
			System.out.println(getClass()+" : Do Nothing");
		}
}
