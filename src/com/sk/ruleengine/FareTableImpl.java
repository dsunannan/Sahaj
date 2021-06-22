package com.sk.ruleengine;

import java.util.*;
public class FareTableImpl implements IFareTable{
	public Map<String,Integer> map_peak_hrs_fare = new HashMap<String,Integer>();
	public Map<String,Integer> map_offpeak_hrs_fare = new HashMap<String,Integer>();

	public Map<String,Integer> map_daily_fare_cap = new HashMap<String,Integer>();
	public Map<String,Integer> map_weekly_fare_cap = new HashMap<String,Integer>();

	public void intiZone() {
		Zone[] arr;
		arr= new Zone[4];
		arr[0]= new Zone("1-1",30);
		arr[1]= new Zone("1-2",35);
		arr[2]= new Zone("2-1",35);
		arr[3]= new Zone("2-2",25);

		intializeFareTable(arr,map_peak_hrs_fare);

		arr[0]= new Zone("1-1",25);
		arr[1]= new Zone("1-2",30);
		arr[2]= new Zone("2-1",30);
		arr[3]= new Zone("2-2",20);

		intializeFareTable(arr,map_offpeak_hrs_fare);
		
		arr[0]= new Zone("1-1",100);
		arr[1]= new Zone("1-2",120);
		arr[2]= new Zone("2-1",120);
		arr[3]= new Zone("2-2",80);
		
		intializeFareTable(arr,map_daily_fare_cap);
		
		arr[0]= new Zone("1-1",500);
		arr[1]= new Zone("1-2",600);
		arr[2]= new Zone("2-1",600);
		arr[3]= new Zone("2-2",400);
		
		intializeFareTable(arr,map_weekly_fare_cap);
	}
	@Override
	public void intializeFareTable(Zone[] arr,Map<String,Integer> fare_map) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++)
			fare_map.put(arr[i].str_route, arr[i].i_fare);
	}
	@Override
	public int getFare(Zone zoneobj, Map<String,Integer> fare_map) {
		// TODO Auto-generated method stub
		return fare_map.get(zoneobj.str_route).intValue();
	}


}
