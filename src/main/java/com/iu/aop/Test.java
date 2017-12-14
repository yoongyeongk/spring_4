package com.iu.aop;

public class Test {

	public void t(){
		Transport t = new Transport();
		CardCheck c = new CardCheck();
		
		//이렇게 쓰면 공통된 코드가 생기므로 OOP 관점에서 벗어나게 됨
		/*c.check();
		t.subway();
		c.check();
		
		c.check();
		t.bus();
		c.check();*/
		
		t.subway();
		
		t.bus();
		
		t.walk(30);
	}
}
