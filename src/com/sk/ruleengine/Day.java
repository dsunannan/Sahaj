package com.sk.ruleengine;

import java.time.LocalTime;
import java.time.LocalDate;


public class Day {
	
	public LocalDate lt_date;
	public LocalTime lt_start1_time;
	public LocalTime lt_end1_time;
	public LocalTime lt_start2_time;
	public LocalTime lt_end2_time;
	public String s_day;
	
	
	public Day(LocalDate lt_date, LocalTime lt_start1_time, LocalTime lt_end1_time, LocalTime lt_start2_time,
			LocalTime lt_end2_time, String s_day) {
		super();
		this.lt_date = lt_date;
		this.lt_start1_time = lt_start1_time;
		this.lt_end1_time = lt_end1_time;
		this.lt_start2_time = lt_start2_time;
		this.lt_end2_time = lt_end2_time;
		this.s_day = s_day;
	}
	
	public Day(LocalDate lt_date, LocalTime lt_travel_time,String s_day) {
		this.lt_date = lt_date;
		this.lt_start1_time = lt_travel_time;
		this.s_day = s_day;
	}
	@Override
	public String toString() {
		return "Day [lt_date=" + lt_date + ", lt_start1_time=" + lt_start1_time + ", lt_end1_time=" + lt_end1_time
				+ ", lt_start2_time=" + lt_start2_time + ", lt_end2_time=" + lt_end2_time + ", s_day=" + s_day + "]";
	}

	public LocalDate getLt_date() {
		return lt_date;
	}
	public void setLt_date(LocalDate lt_date) {
		this.lt_date = lt_date;
	}
	public LocalTime getLt_start1_time() {
		return lt_start1_time;
	}
	public void setLt_start1_time(LocalTime lt_start1_time) {
		this.lt_start1_time = lt_start1_time;
	}
	public LocalTime getLt_end1_time() {
		return lt_end1_time;
	}
	public void setLt_end1_time(LocalTime lt_end1_time) {
		this.lt_end1_time = lt_end1_time;
	}
	public LocalTime getLt_start2_time() {
		return lt_start2_time;
	}
	public void setLt_start2_time(LocalTime lt_start2_time) {
		this.lt_start2_time = lt_start2_time;
	}
	public LocalTime getLt_end2_time() {
		return lt_end2_time;
	}
	public void setLt_end2_time(LocalTime lt_end2_time) {
		this.lt_end2_time = lt_end2_time;
	}
	public String getS_day() {
		return s_day;
	}
	public void setS_day(String s_day) {
		this.s_day = s_day;
	}
	
	
	
	
	
}
