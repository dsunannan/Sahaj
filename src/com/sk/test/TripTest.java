package com.sk.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sk.util.*;
import com.sk.ruleengine.*;
import com.sk.constants.IRuleExplanationConstants;

class TripTest {
	Trip trip;
	DayTrip daytrip;
	RuleEngineImpl ruleengine;
	FareTableImpl ifare;
	TimeRuleImpl trule;
	Passenger psg;

	@BeforeEach
	void setUp() throws Exception {
		trip = new Trip();
		daytrip = new DayTrip();
		ruleengine = new RuleEngineImpl();
		psg = new Passenger();
		ifare = new FareTableImpl();
		trule = new TimeRuleImpl();
		ifare.intiZone();
		trule.initDayandTime();
		ruleengine.initializeRule(trule, ifare);
	}

	@Test
	void offPeakSingleTriptest() {
		trip.setS_day(IRuleExplanationConstants.MONDAY);
		trip.setS_from_zone(IRuleExplanationConstants.ONE);
		trip.setS_to_zone(IRuleExplanationConstants.TWO);
		trip.setS_time("10:31");
		psg.setL_passengerid(100L);
		psg.setStr_route(trip.getS_from_zone() + "-" + trip.getS_to_zone());
		trip.setPsg(psg);
		logger(trip, psg);
		assertEquals(30, psg.getTotalfare());
	}

	@Test
	void peakSingleTriptest() {
		trip.setS_day(IRuleExplanationConstants.MONDAY);
		trip.setS_from_zone(IRuleExplanationConstants.ONE);
		trip.setS_to_zone(IRuleExplanationConstants.TWO);
		trip.setS_time("10:30");
		psg.setL_passengerid(100L);
		psg.setStr_route(trip.getS_from_zone() + "-" + trip.getS_to_zone());
		logger(trip, psg);
		assertEquals(35, psg.getTotalfare());

	}

	@Test
	void offPeakSingleSundayTriptest() {
		trip.setS_day(IRuleExplanationConstants.SUNDAY);
		trip.setS_from_zone(IRuleExplanationConstants.ONE);
		trip.setS_to_zone("2");
		trip.setS_time("11:31");
		psg.setL_passengerid(100L);
		psg.setStr_route(trip.getS_from_zone() + "-" + trip.getS_to_zone());
		logger(trip, psg);
		assertEquals(30, psg.getTotalfare());
	}

	@Test
	void peakSingleSundayTriptest() {
		trip.setS_day(IRuleExplanationConstants.SUNDAY);
		trip.setS_from_zone(IRuleExplanationConstants.ONE);
		trip.setS_to_zone(IRuleExplanationConstants.TWO);
		trip.setS_time("18:31");
		psg.setL_passengerid(100L);
		psg.setStr_route(trip.getS_from_zone() + "-" + trip.getS_to_zone());
		logger(trip, psg);

		assertEquals(35, psg.getTotalfare());
	}
   @Test
   void dayTripTest() {
	   daytrip.setNooftrips(5);
	   Trip[] tripdetails= new Trip[daytrip.getNooftrips()];
	   Passenger psg = new Passenger();
	   psg.setL_passengerid(100L);
	  
	   for (int i=0;i<daytrip.getNooftrips();i++) {
		   tripdetails[i] = new Trip();
		   if(i==0) {
		   tripdetails[i].setS_day(IRuleExplanationConstants.MONDAY);
		   tripdetails[i].setS_from_zone(IRuleExplanationConstants.TWO);
		   tripdetails[i].setS_to_zone(IRuleExplanationConstants.ONE);
		   tripdetails[i].setS_time("10:20");
		   psg.setStr_route(tripdetails[i].getS_from_zone() + "-" + tripdetails[i].getS_to_zone());
		   tripdetails[i].setPsg(psg);
		   }
		   if(i==1) {
			   tripdetails[i].setS_day(IRuleExplanationConstants.MONDAY);
			   tripdetails[i].setS_from_zone(IRuleExplanationConstants.ONE);
			   tripdetails[i].setS_to_zone(IRuleExplanationConstants.ONE);
			   tripdetails[i].setS_time("10:45");
			   psg.setStr_route(tripdetails[i].getS_from_zone() + "-" + tripdetails[i].getS_to_zone());
			   tripdetails[i].setPsg(psg);
			   }
		   if(i==2) {
			   tripdetails[i].setS_day(IRuleExplanationConstants.MONDAY);
			   tripdetails[i].setS_from_zone(IRuleExplanationConstants.ONE);
			   tripdetails[i].setS_to_zone(IRuleExplanationConstants.ONE);
			   tripdetails[i].setS_time("16:15");
			   psg.setStr_route(tripdetails[i].getS_from_zone() + "-" + tripdetails[i].getS_to_zone());
			   tripdetails[i].setPsg(psg);
			   }
		   if(i==3) {
			   tripdetails[i].setS_day(IRuleExplanationConstants.MONDAY);
			   tripdetails[i].setS_from_zone(IRuleExplanationConstants.ONE);
			   tripdetails[i].setS_to_zone(IRuleExplanationConstants.ONE);
			   tripdetails[i].setS_time("18:15");
			   psg.setStr_route(tripdetails[i].getS_from_zone() + "-" + tripdetails[i].getS_to_zone());
			   tripdetails[i].setPsg(psg);
			   }
		   if(i==4) {
			   tripdetails[i].setS_day(IRuleExplanationConstants.MONDAY);
			   tripdetails[i].setS_from_zone(IRuleExplanationConstants.ONE);
			   tripdetails[i].setS_to_zone(IRuleExplanationConstants.TWO);
			   tripdetails[i].setS_time("19:00");
			   psg.setStr_route(tripdetails[i].getS_from_zone() + "-" + tripdetails[i].getS_to_zone());
			   tripdetails[i].setPsg(psg);
			   }
		  
		  
	   }
	   
	   daytrip.setDaytrips(tripdetails);
	   ruleengine.getTravelFare(psg, daytrip);
		logger(daytrip);
   }
	private void logger(Trip trip, Passenger psg) {
		System.out.println("---- Fare calculation per trip " + trip.getS_day());
		System.out.println("---- Calculated Total Fare: " + ruleengine.getTravelFare(psg, trip));
		System.out.println("---- Passenger" + psg.toString());
		System.out.println("---- Trip Details: " + trip.toString());
	}
	
	private void logger(DayTrip daytrip) {
		Trip[] trip = daytrip.getDaytrips();
		int total_fare=0;
		for(int i=0;i<trip.length;i++) {
		System.out.println("---- Fare calcualtion day trip " + trip[i].getS_day());			
		System.out.println("---- Trip Details with Fare: " + trip[i].toString());
		total_fare=total_fare+trip[i].getI_calcualted_fare();
		
		}
		System.out.println("---- Total Fare: " + total_fare);
	}

}
