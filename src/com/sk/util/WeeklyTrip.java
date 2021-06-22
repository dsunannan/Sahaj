package com.sk.util;

public class WeeklyTrip {
public DayTrip[] day_trips = new DayTrip[7];

public DayTrip[] getDay_trips() {
	return day_trips;
}

public void setDay_trips(DayTrip[] day_trips) {
	this.day_trips = day_trips;
}
}
