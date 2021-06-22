package com.sk.util;

public class MonthlyTrip {
public WeeklyTrip[] weekly_trip = new WeeklyTrip[4];

public WeeklyTrip[] getWeekly_trip() {
	return weekly_trip;
}

public void setWeekly_trip(WeeklyTrip[] weekly_trip) {
	this.weekly_trip = weekly_trip;
}
}
