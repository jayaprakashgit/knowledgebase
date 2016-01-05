package com.interlan.test.java7;

public class StringFormaterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inputData = "123";
		System.out.printf("%-12s%-12s%s\n","Column 1","Column 2","Column3");
		System.out.printf("%-12s%12s", inputData, inputData);
		System.out.println("\n");
		System.out.printf("%-12.5f%.20f", 12.23429837482,9.10212023134);

	}

}
