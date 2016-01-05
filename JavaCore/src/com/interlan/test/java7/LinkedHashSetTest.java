package com.interlan.test.java7;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set = new LinkedHashSet<>();
		set.add("3");
		set.add("1");
		set.add("3");
		set.add("2");
		set.add("3");
		set.add("1");
		
		for (String string : set) {
			System.out.print(string+"-");
		}
		
	}

}
