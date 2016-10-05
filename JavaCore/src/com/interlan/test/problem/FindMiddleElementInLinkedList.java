package com.interlan.test.problem;

import java.util.LinkedList;
import java.util.List;

public class FindMiddleElementInLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		
		int singlePtr = 0;
		int doublePtr = 0;
		
				
		for(int i=1; i<list.size(); i++){
			singlePtr++;
			if( i%2 == 0 )
				doublePtr++;
		}
		
		System.out.println(list.get(doublePtr));
		
	}

}
