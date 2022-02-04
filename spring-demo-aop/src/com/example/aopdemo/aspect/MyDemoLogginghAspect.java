package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogginghAspect {
	
	
	//@Before("execution(public void com.example.aopdemo.dao.AccountDao.addAccount())")
	//@Before("execution(public void addAccount())")
	//@Before("execution(public void add*())")
	//@Before("execution(* add*(com.example.aopdemo.Account,..))")
	@Before("execution(* com.example.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		System.out.println("=>------------Executing before advice ");
		
	}

}
