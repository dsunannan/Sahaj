package com.sk.ruleengine;

public class Passenger {
	public long l_passengerid;
	public String str_route;
	public int totalfare;

	

	@Override
	public String toString() {
		return "Passenger [l_passengerid=" + l_passengerid + ", str_route=" + str_route + ", totalfare=" + totalfare
				+ "]";
	}

	public int getTotalfare() {
		return totalfare;
	}

	public void setTotalfare(int totalfare) {
		this.totalfare = totalfare;
	}

	public long getL_passengerid() {
		return l_passengerid;
	}

	public void setL_passengerid(long l_passengerid) {
		this.l_passengerid = l_passengerid;
	}

	public String getStr_route() {
		return str_route;
	}

	public void setStr_route(String str_route) {
		this.str_route = str_route;
	}

}
