package com.sk.util;



public class DayTrip {
     // Some constant value can be rest, If more was required via setters.
	public int i_nooftrips = 20;
	public Trip[] daytrips = new Trip[i_nooftrips];
	
	
	public int getNooftrips() {
		return i_nooftrips;
	}

	public void setNooftrips(int i_nooftrips) {
		this.i_nooftrips = i_nooftrips;
	}

	public Trip[] getDaytrips() {
		return daytrips;
	}

	public void setDaytrips(Trip[] daytrips) {
		this.daytrips = daytrips;
	}
}
