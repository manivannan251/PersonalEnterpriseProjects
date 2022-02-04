package com.example.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.aopdemo.dao.AccountDao;
import com.example.aopdemo.dao.MemberShipDao;

public class AopMainDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		AccountDao accountDao = context.getBean("accountDao",AccountDao.class);
		
		Account account = new Account();
		
		accountDao.addAccount(account,true,"Goku");
		
		accountDao.doSomeWork();
		
		MemberShipDao memberShipDao = context.getBean("memberShipDao",MemberShipDao.class);
		
		memberShipDao.addMember();
		
		memberShipDao.doSleep();
		
		context.close();
	}

}
