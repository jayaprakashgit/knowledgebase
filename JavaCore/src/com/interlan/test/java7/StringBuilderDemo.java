package com.interlan.test.java7;

import java.util.Scanner;

public class StringBuilderDemo {

	public static void main(String[] argList) {
		// TODO Auto-generated method stub
		//Test null Test 1 2 3 test
		StringBuilder str = new StringBuilder();
		//argList = new String[]{"1", "2", "3"};
		for(String arg : argList){
			if(str.indexOf(arg)<1)
				str.append(arg+" ");
		}
		
		System.out.println(str.toString());
		Scanner sc = new Scanner(str.toString());
		while(sc.hasNext()){
			if(sc.hasNextInt())
				System.out.println(sc.nextInt()+" ");
			else
				sc.next();
		}
		
		System.out.println("--------------------");
		
		System.out.println(Math.nextAfter(10.22, 0.01));
		System.out.println(Math.nextUp(10.22));
		System.out.println(Math.random());
		System.out.println(Math.floor(10.99));
		System.out.println(Math.ceil(10.99));
		System.out.println(Math.round(10.55));
	}
	
	

}
