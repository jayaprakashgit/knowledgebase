package com.interlan.test.collection;

import java.util.HashSet;
import java.util.Set;

public class TestSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//to proper uniqueness, should implement both hashcode and equals
		Set<Machine> mySet = new HashSet<>();
		mySet.add(new Machine(1, "Robo1"));
		mySet.add(new Machine(1, "Robo1"));
		
		System.out.println(mySet);
	}

}
