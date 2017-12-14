package com.iu.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CardCheck {

	@Before("execution(* com.iu.aop..Transport.*())")
	public void check(){
		System.out.println("카드 체크");
	}
}
