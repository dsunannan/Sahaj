package com.sk.ruleengine;

import com.sk.util.*;
public interface IRuleEngine {
	
void initializeRule(TimeRuleImpl trule, FareTableImpl ifare);

int getTravelFare(Passenger psg,Trip trip );
Passenger getTravelFare(Passenger psg,DayTrip daytrip );
Passenger getTravelFare(Passenger psg,WeeklyTrip weeklytrip );
Passenger getTravelFare(Passenger psg,MonthlyTrip monthlytrip );
}
