package com.iu.test;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.aop.Transport;
import com.iu.s4.AbstractTest;

public class TransportTest extends AbstractTest {

	@Inject
	private Transport transport;
	
	@Test
	public void test() {
		transport.bus();
		transport.subway();
		transport.walk(30);
	}

}
