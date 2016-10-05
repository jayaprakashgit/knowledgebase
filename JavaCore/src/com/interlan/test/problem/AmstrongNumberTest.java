package com.interlan.test.problem;

public class AmstrongNumberTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<1000; i++){
			if(AmstrongNumberTest.isAmstrongNumber(String.valueOf(i)))
				System.out.println(i);
		}
	}
	
	public static boolean isAmstrongNumber(String number){
		char[] numberCharArray = number.toCharArray();
		double result = 0;
		for(int i=0; i<numberCharArray.length; i++){
			double d = Double.valueOf(String.valueOf(numberCharArray[i]));
			result = result + Math.pow(d, 3);
		}
		
		return (result == Double.valueOf(number))?true:false;
	}

}
