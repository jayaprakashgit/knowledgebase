package com.interlan.test.problem;

public class SwapTwoValues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int b = 20;
		int c = 0;
		
		a = a^b;
		b = a^b;
		a = a^b;
		
		System.out.println(a+", "+b);
	}

}
