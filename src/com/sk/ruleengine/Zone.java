package com.sk.ruleengine;

public class Zone {
	public String str_route;
	public int i_fare;
	
	public String getStr_route() {
		return str_route;
	}

	public void setStr_route(String str_route) {
		this.str_route = str_route;
	}

	public int getI_fare() {
		return i_fare;
	}

	public void setI_fare(int i_fare) {
		this.i_fare = i_fare;
	}

	public Zone (String str_route,int i_fare){
		this.i_fare=i_fare;
		this.str_route=str_route;
	}
}
