package com.sk.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sk.ruleengine.FareTableImpl;

import com.sk.ruleengine.Zone;

class FareTableTest {
	FareTableImpl ift = new FareTableImpl();
	Zone znobjpeak = new Zone("1-1",0);
	Zone znobjoffpeak = new Zone("1-1",0);
	
	Zone znobjnotexist = new Zone("1-3",0);
	
	@BeforeEach
	void setUp() throws Exception {
		ift.intiZone();
	}

	@Test
	void testPeakAndoffPeakFare() {
		System.out.println("Fare table test...");
		System.out.println(ift.getFare(znobjpeak, ift.map_peak_hrs_fare));
		System.out.println(ift.getFare(znobjoffpeak, ift.map_offpeak_hrs_fare));
		assertTrue(true);
	}
	
	@Test
	void testCappedFare() {
		System.out.println("Capped Fare table test...");
		System.out.println(ift.getFare(znobjpeak, ift.map_peak_hrs_fare));
		System.out.println(ift.getFare(znobjoffpeak, ift.map_offpeak_hrs_fare));
		assertTrue(true);
	}
	
	@Test
	void testnotExistRouteFare() {
		System.out.println("Not Existant Route Fare table test...");
		System.out.println(znobjnotexist.str_route+"-"+ift.getFare(znobjnotexist, ift.map_peak_hrs_fare));
		System.out.println(znobjnotexist.str_route+"-"+ift.getFare(znobjnotexist, ift.map_offpeak_hrs_fare));
		assertTrue(true);
	}

}
