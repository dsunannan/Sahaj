package com.sk.ruleengine;


import java.util.*;

public interface IFareTable {
	void intializeFareTable(Zone[] arr, Map<String, Integer> fare_map);

	int getFare(Zone zoneobj, Map<String, Integer> fare_map);
}
