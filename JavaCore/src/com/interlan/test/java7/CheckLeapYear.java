package com.interlan.test.java7;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CheckLeapYear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int year=2004;
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		int days = cal.getMaximum(Calendar.DAY_OF_YEAR);
		System.out.println((days == 365));
		
		
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(gc.isLeapYear(year));
		
		
		System.out.println(findLeapYear(year));
	}
	
	
	public static boolean findLeapYear(int year){
		return ( (year % 400 == 0) || ( (year%4==0) && (year%100 !=0) ) ) ? true : false;
	}

}
