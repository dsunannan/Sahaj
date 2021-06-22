package com.sk.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sk.ruleengine.TimeRuleImpl;

class TimeRuleTest {

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void test() {
		TimeRuleImpl tr = new TimeRuleImpl();
		
		tr.initDayandTime();
		
		System.out.print(tr.toString());
		assertTrue(true);
	}

}
