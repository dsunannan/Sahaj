package com.sk.ruleengine;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import com.sk.constants.IRuleExplanationConstants;

public class TimeRuleImpl implements ITimeRule {
	
	public Map<String,Day> map_day_time_lookup = new HashMap<String,Day>();

	

	@Override
	public String toString() {
		return "TimeRuleImpl [map_day_time_lookup=" + map_day_time_lookup + "]";
	}

	public void initDayandTime() {
		Day day[] = new Day[7];
		day[0]= new Day(LocalDate.now(),LocalTime.parse("07:00"),LocalTime.parse("10:30"),LocalTime.parse("17:00"),LocalTime.parse("20:00"),IRuleExplanationConstants.MONDAY);
		day[1]= new Day(LocalDate.now(),LocalTime.parse("07:00"),LocalTime.parse("10:30"),LocalTime.parse("17:00"),LocalTime.parse("20:00"),IRuleExplanationConstants.TEUSDAY);
		day[2]= new Day(LocalDate.now(),LocalTime.parse("07:00"),LocalTime.parse("10:30"),LocalTime.parse("17:00"),LocalTime.parse("20:00"),IRuleExplanationConstants.WEDNESDAY);
		day[3]= new Day(LocalDate.now(),LocalTime.parse("07:00"),LocalTime.parse("10:30"),LocalTime.parse("17:00"),LocalTime.parse("20:00"),IRuleExplanationConstants.THURSDAY);
		day[4]= new Day(LocalDate.now(),LocalTime.parse("07:00"),LocalTime.parse("10:30"),LocalTime.parse("17:00"),LocalTime.parse("20:00"),IRuleExplanationConstants.FRIDAY);
		day[5]= new Day(LocalDate.now(),LocalTime.parse("09:00"),LocalTime.parse("11:00"),LocalTime.parse("18:00"),LocalTime.parse("22:00"),IRuleExplanationConstants.SATURDAY);
		day[6]= new Day(LocalDate.now(),LocalTime.parse("09:00"),LocalTime.parse("11:00"),LocalTime.parse("18:00"),LocalTime.parse("22:00"),IRuleExplanationConstants.SUNDAY);
		intializePeakHours(day);
	}
	@Override
	public void intializePeakHours(Day day[]) {
		// TODO Auto-generated method stub
		for (int i = 0; i < day.length; i++)
		map_day_time_lookup.put(day[i].getS_day(), day[i]);
	}

	

}
