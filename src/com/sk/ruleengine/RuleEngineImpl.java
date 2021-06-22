package com.sk.ruleengine;

import java.time.LocalTime;
import java.time.LocalDate;

import com.sk.util.DayTrip;
import com.sk.util.MonthlyTrip;
import com.sk.util.Trip;
import com.sk.util.WeeklyTrip;
import com.sk.constants.IRuleExplanationConstants;

public class RuleEngineImpl implements IRuleEngine {
	private TimeRuleImpl trule;
	private FareTableImpl ifare;

	@Override
	public void initializeRule(TimeRuleImpl trule, FareTableImpl ifare) {
		// TODO Auto-generated method stub
		this.trule = trule;
		this.ifare = ifare;
	}

	@Override
	public int getTravelFare(Passenger psg, Trip trip) {
		// TODO Auto-generated method stub
		/*
		 * Initializing route, time and fare..
		 */
		int fare;
		psg.setStr_route(trip.getS_from_zone() + "-" + trip.getS_to_zone());
		LocalTime time = LocalTime.parse(trip.getS_time());
		Day day = new Day(trip.getLd_date(), time, trip.getS_day());
		/*
		 * Checking time was in peak hours
		 */
		boolean flag = isBetweenPeakHrs(time, day, trule);
		Zone zoneobj = new Zone(psg.getStr_route(), psg.getTotalfare());
		if (flag) {
			/*
			 * Peak hour fare rule met.
			 */
			fare = ifare.getFare(zoneobj, ifare.map_peak_hrs_fare);
			trip.setS_explanation(IRuleExplanationConstants.PEAK_HR);

		} else {
			/*
			 * Off peak hours rule met.
			 */
			fare = ifare.getFare(zoneobj, ifare.map_offpeak_hrs_fare);
			trip.setS_explanation(IRuleExplanationConstants.OFFPEAK_HR);

		}
		// Setting travel Date
		setTripObjTravelDate(day, trule, trip);

		// Setting calculated fare to passenger and Trip

		psg.setTotalfare(fare);

		trip.setI_calcualted_fare(fare);
		trip.setPsg(psg);

		// total per single trip
		return psg.getTotalfare();
	}

	@Override
	public Passenger getTravelFare(Passenger psg, DayTrip daytrip) {
		// TODO Auto-generated method stub

		Trip[] trip = daytrip.getDaytrips();
		int i_highest_day_cap_fare = getDayCapFare(trip, ifare);
		int i_calculated_cappedfare = 0;
		for (int i = 0; i < daytrip.getNooftrips(); i++) {
			trip[i].setI_prev_trip_fare_total(i_calculated_cappedfare);
			i_calculated_cappedfare = i_calculated_cappedfare + getTravelFare(psg, trip[i]);

			applyCapOnFareTotal(i_highest_day_cap_fare, i_calculated_cappedfare, psg, trip[i]);
		}
		return psg;
	}

	@Override
	public Passenger getTravelFare(Passenger psg, WeeklyTrip weeklytrip) {
		// TODO Auto-generated method stub
		DayTrip[] daytrip = weeklytrip.getDay_trips();
		int i_highest_weekly_cap_fare = getWeekCapFare(daytrip, ifare);
		int i_calculated_cappedfare = 0;
		return new Passenger();
	}

	@Override
	public Passenger getTravelFare(Passenger psg, MonthlyTrip monthlytrip) {
		// TODO Auto-generated method stub
		return new Passenger();
	}

	public static boolean isBetweenPeakHrs(LocalTime candidate, Day day, TimeRuleImpl trule) {
		boolean flag_peak_hrs = false;
		Day time_rule_of_day = trule.map_day_time_lookup.get(day.getS_day());

		flag_peak_hrs = (!candidate.isBefore(time_rule_of_day.getLt_start1_time())
				&& !candidate.isAfter(time_rule_of_day.getLt_end1_time()))
				|| (!candidate.isBefore(time_rule_of_day.getLt_start2_time())
						&& !candidate.isAfter(time_rule_of_day.getLt_end2_time()));

		return flag_peak_hrs;
	}

	public static void setTripObjTravelDate(Day day, TimeRuleImpl trule, Trip trip) {
		Day time_rule_of_day = trule.map_day_time_lookup.get(day.getS_day());
		trip.setLd_date(time_rule_of_day.getLt_date());
	}

	public static int getDayCapFare(Trip[] trip, FareTableImpl ifare) {
		int i_highest_fare_cap = 0;

		for (int i = 0; i < trip.length; i++) {
			int i_daycap = ifare.map_daily_fare_cap.get(trip[i].getS_from_zone() + "-" + trip[i].getS_to_zone());
			if (i_daycap > i_highest_fare_cap) {
				i_highest_fare_cap = i_daycap;
			}
		}
		return i_highest_fare_cap;
	}
	
	public static int getWeekCapFare(DayTrip[] daytrip, FareTableImpl ifare) {
		int i_highest_weeklyfare_cap = 0;
		Trip[] trip = daytrip[0].getDaytrips();
		for (int i = 0; i < trip.length; i++) {
			int i_daycap = ifare.map_weekly_fare_cap.get(trip[i].getS_from_zone() + "-" + trip[i].getS_to_zone());
			if (i_daycap > i_highest_weeklyfare_cap) {
				i_highest_weeklyfare_cap = i_daycap;
			}
		}
		return i_highest_weeklyfare_cap;
	}

	public static void applyCapOnFareTotal(int daycapfare, int daytotal, Passenger psg, Trip trip) {
		int i_capped_fare = 0;
		int i_actual_fare=0;

		if (daytotal > daycapfare) {
			
			i_capped_fare = daycapfare - trip.getI_prev_trip_fare_total();
			psg.setTotalfare(i_capped_fare+trip.getI_prev_trip_fare_total());
			i_actual_fare = trip.getI_calcualted_fare();
			trip.setI_calcualted_fare(i_capped_fare);
			trip.setPsg(psg);
			String explanation = new String(IRuleExplanationConstants.CAP_REACHED);
			explanation=explanation.replace("{0}", Integer.toString(daycapfare));
			explanation=explanation.replace("{1}", psg.getStr_route());
			explanation=explanation.replace("{2}", Integer.toString(i_capped_fare));
			explanation=explanation.replace("{3}", Integer.toString(i_actual_fare));
			trip.setS_explanation(explanation);
		}

	}
}
