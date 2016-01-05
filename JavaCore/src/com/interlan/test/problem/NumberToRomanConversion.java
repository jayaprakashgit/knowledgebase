package com.interlan.test.problem;

import java.util.TreeMap;

public class NumberToRomanConversion {

	static final TreeMap<Integer, String> romanMap = new TreeMap<>();
	
	static {
		romanMap.put(1000, "M");
		romanMap.put(500, "D");
		romanMap.put(100, "C");
		romanMap.put(50, "L");
		romanMap.put(10, "X");
		romanMap.put(5, "V");
		romanMap.put(1, "I");
	}
	
	public static void main(String []args){
		System.out.println(getRomanNumber(555));
	}
	
	public static String getRomanNumber(int number){
		int lowestRomanNumber = romanMap.floorKey(number);
		if(lowestRomanNumber == number)
			return romanMap.get(number);
		
		return romanMap.get(lowestRomanNumber) + getRomanNumber(number - lowestRomanNumber);
	}
}
