package com.interlan.test.collection;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//to proper uniqueness, should implement both hashcode and equals
		Map<Machine, Machine> myMap = new HashMap<>();
		myMap.put(new Machine(1, "Robo1"), new Machine(1, "Robo1"));
		myMap.put(new Machine(1, "Robo1"), new Machine(1, "Robo1"));
		
		System.out.println(myMap);
	}

}
