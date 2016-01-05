package com.interlan.test.problem;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestNumeralToRoman {

	final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();
	
	 static {
	
	        map.put(1000, "M");
	        map.put(900, "CM");
	        map.put(500, "D");
	        map.put(400, "CD");
	        map.put(100, "C");
	        map.put(90, "XC");
	        map.put(50, "L");
	        map.put(40, "XL");
	        map.put(10, "X");
	        map.put(9, "IX");
	        map.put(5, "V");
	        map.put(4, "IV");
	        map.put(1, "I");
	
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(toRoman(234));
		///System.out.println(RomanNumerals(25));
	}
	
	 public final static String toRoman(int number) {
        int l =  map.floorKey(number);
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number-l);
	 }

	 
	 public static String RomanNumerals(int Int) {
		    LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap<String, Integer>();
		    roman_numerals.put("M", 1000);
		    roman_numerals.put("CM", 900);
		    roman_numerals.put("D", 500);
		    roman_numerals.put("CD", 400);
		    roman_numerals.put("C", 100);
		    roman_numerals.put("XC", 90);
		    roman_numerals.put("L", 50);
		    roman_numerals.put("XL", 40);
		    roman_numerals.put("X", 10);
		    roman_numerals.put("IX", 9);
		    roman_numerals.put("V", 5);
		    roman_numerals.put("IV", 4);
		    roman_numerals.put("I", 1);
		    String res = "";
		    for(Map.Entry<String, Integer> entry : roman_numerals.entrySet()){
		      int matches = Int/entry.getValue();
		      res += repeat(entry.getKey(), matches);
		      Int = Int % entry.getValue();
		    }
		    return res;
		  }
		  public static String repeat(String s, int n) {
		    if(s == null) {
		        return null;
		    }
		    final StringBuilder sb = new StringBuilder();
		    for(int i = 0; i < n; i++) {
		        sb.append(s);
		    }
		    return sb.toString();
		  }
}

