package com.interlan.test.java7;

import java.util.HashMap;
import java.util.Map;

public class FlowControlDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, Integer> countMap = new HashMap<>();
		Integer key = 5;
		Integer value = key;
		countMap.put(key++, value);
		countMap.put(300, 300);
		int count = 0;
		for (Integer i : countMap.keySet()) {
			for(Integer j : countMap.values()){
				count++;
				if(i == countMap.get(i)){
					break;
				}
				else
					continue;
			}
		}
		System.out.println("Count : "+count);
	}

}
