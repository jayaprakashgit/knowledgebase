package com.interlan.test.java7;

import java.util.Calendar;

public class TimeTests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(String.format("Local time : %tH:%tM:%tS",  Calendar.getInstance(), Calendar.getInstance(), Calendar.getInstance()));
		System.out.println(String.format("Local time : %1$tB",  Calendar.getInstance()));
		System.out.println(String.format("Local time : %tT",  Calendar.getInstance()));
		//System.out.println(String.format("Local time : %tT",  Calendar.getInstance().toString()));
		//System.out.println(String.format("Local time : %l$",  Calendar.getInstance()));
	}

}
