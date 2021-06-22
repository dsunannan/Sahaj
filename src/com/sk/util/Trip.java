package com.sk.util;

import java.time.LocalDate;
import com.sk.ruleengine.Passenger;

public class Trip {
	
    public LocalDate ld_date;
	
	public String s_day;
	public String s_time;
	public String s_from_zone;
	public String s_to_zone;
	public int i_calcualted_fare;
	public String s_explanation;
	
	public Passenger psg;
	
	public int i_prev_trip_fare_total;
	
	public int getI_prev_trip_fare_total() {
		return i_prev_trip_fare_total;
	}

	public void setI_prev_trip_fare_total(int i_prev_trip_fare_total) {
		this.i_prev_trip_fare_total = i_prev_trip_fare_total;
	}

	public Passenger getPsg() {
		return psg;
	}

	public void setPsg(Passenger psg) {
		this.psg = psg;
	}
	
	public LocalDate getLd_date() {
		return ld_date;
	}
	public void setLd_date(LocalDate ld_date) {
		this.ld_date = ld_date;
	}
	
	public String getS_day() {
		return s_day;
	}
	public void setS_day(String s_day) {
		this.s_day = s_day;
	}
	public String getS_time() {
		return s_time;
	}
	public void setS_time(String s_time) {
		this.s_time = s_time;
	}
	
	@Override
	public String toString() {
		return "Trip [ld_date=" + ld_date + ", s_day=" + s_day + ", s_time=" + s_time + ", s_from_zone=" + s_from_zone
				+ ", s_to_zone=" + s_to_zone + ", i_calcualted_fare=" + i_calcualted_fare + ", s_explanation="
				+ s_explanation + "]";
	}
	public String getS_from_zone() {
		return s_from_zone;
	}
	public void setS_from_zone(String s_from_zone) {
		this.s_from_zone = s_from_zone;
	}
	public String getS_to_zone() {
		return s_to_zone;
	}
	public void setS_to_zone(String s_to_zone) {
		this.s_to_zone = s_to_zone;
	}
	public int getI_calcualted_fare() {
		return i_calcualted_fare;
	}
	public void setI_calcualted_fare(int i_calcualted_fare) {
		this.i_calcualted_fare = i_calcualted_fare;
	}
	public String getS_explanation() {
		return s_explanation;
	}
	public void setS_explanation(String s_explanation) {
		this.s_explanation = s_explanation;
	}
	
}
