package com.iu.aop;

import org.springframework.stereotype.Component;

@Component
public class Transport {

	public void subway(){
		System.out.println("자리 뺏기");
		System.out.println("핸드폰 보기");
		System.out.println("---------------");
	}
	
	public void bus(){
		System.out.println("노래 듣기");
		System.out.println("책 읽기");
		System.out.println("Bus------------");
	}
	
	public void walk(int age){
		System.out.println("침뱉기");
		System.out.println("---------------");
	}
	//subway, bus는 실행 전 후에 카드 체크를 해야함
}
