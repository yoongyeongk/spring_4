package com.iu.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MoneyChange {
	
	@Around("excution( * com.iu.aop..Trip.*(..))")
	public Object exchange(ProceedingJoinPoint join){
		System.out.println("-------------");
		System.out.println("원화를 루블로 교환");
		
		Object obj = null;
		try {
			obj = join.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("루블을 원화로 교환");
		
		return obj;
	}
}
