package com.interlan.test.problem;

import java.util.TreeMap;

public class RomanToNumberToRomanConversion {

	final static TreeMap<Integer, String> romanMap = new TreeMap<>();
	static {
		romanMap.put(1000, "M");
		romanMap.put(500, "D");
		romanMap.put(100, "C");
		romanMap.put(50, "L");
		romanMap.put(10, "X");
		romanMap.put(5, "V");
		romanMap.put(1, "I");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(RomanToNumberToRomanConversion.romantoNumberConversion("CLX"));
		System.out.println(RomanToNumberToRomanConversion.numberToRomanConversion(160));
	}
	
	
	public static int romantoNumberConversion(String romanString){
		romanString = romanString.toUpperCase();
		int decimal = 0;
		int lastNumber = 0;
		for (int x = romanString.length()-1; x>=0; x--) {
			char romanChar = romanString.charAt(x);
			switch(romanChar){
				case 'M' :
					decimal = converRomanCharToNumber(1000, lastNumber, decimal);
					lastNumber = 1000;
					break;
				case 'D' :
					decimal = converRomanCharToNumber(500, lastNumber, decimal);
					lastNumber = 500;
					break;
				case 'C' :
					decimal = converRomanCharToNumber(100, lastNumber, decimal);
					lastNumber = 100;
					break;
				case 'L' :
					decimal = converRomanCharToNumber(50, lastNumber, decimal);
					lastNumber = 50;
					break;
				case 'X' :
					decimal = converRomanCharToNumber(10, lastNumber, decimal);
					lastNumber = 10;
					break;
				case 'V' :
					decimal = converRomanCharToNumber(5, lastNumber, decimal);
					lastNumber = 5;
					break;
				case 'I' :
					decimal = converRomanCharToNumber(1, lastNumber, decimal);
					lastNumber = 1;
					break;
			}
		}
		return decimal;
	}
	
	public static int converRomanCharToNumber(int totalRomanNumber, int lastNumber, int lastDecimal){
		if(lastNumber > totalRomanNumber)
			return  lastDecimal - totalRomanNumber;
		else
			return lastDecimal + totalRomanNumber;
	}
	
	
	public static String numberToRomanConversion(int number){
		int lowestNumber = romanMap.floorKey(number);
		if(lowestNumber == number)
			return romanMap.get(number);
		
		return romanMap.get(lowestNumber) + numberToRomanConversion(number - lowestNumber);
	}

}
