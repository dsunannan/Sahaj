package com.sk.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sk.constants.IRuleExplanationConstants;
import com.sk.ruleengine.FareTableImpl;
import com.sk.ruleengine.Passenger;
import com.sk.ruleengine.RuleEngineImpl;
import com.sk.ruleengine.TimeRuleImpl;
import com.sk.util.WeeklyTrip;
import com.sk.util.DayTrip;
import com.sk.util.Trip;

class WeeklyTripTest {

	Trip trip;
	DayTrip daytrip;
	WeeklyTrip weeklytrip;
	RuleEngineImpl ruleengine;
	FareTableImpl ifare;
	TimeRuleImpl trule;
	Passenger psg;

	@BeforeEach
	void setUp() throws Exception {
		trip = new Trip();
		daytrip = new DayTrip();
		weeklytrip = new WeeklyTrip();
		ruleengine = new RuleEngineImpl();
		psg = new Passenger();
		ifare = new FareTableImpl();
		trule = new TimeRuleImpl();
		ifare.intiZone();
		trule.initDayandTime();
		ruleengine.initializeRule(trule, ifare);
	}

	@Test
	void test() {
		daytrip.setNooftrips(5);
	DayTrip[] daytrpArr = new DayTrip[daytrip.getNooftrips()];
	
	for (int j=0;j<weeklytrip.day_trips.length;j++) {
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
		   
		   daytrpArr[j].setDaytrips(tripdetails);
		   
	}
	weeklytrip.setDay_trips(daytrpArr);
	}

}
