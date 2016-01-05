package com.interlan.test.java7;

public class StringInSwitch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testMethod("EQL");
		
	}
	
	/*
	 * Not only does this help us write more readable code, 
	 * but it also helps the compiler generate more efficient byte code as compared to the if-then-else 
	 * by actually switching on the hashcode() and then doing an equals() comparison
	 */
	public static void testMethod(String tradeType){
		switch(tradeType){
		default :
			System.out.println("Not listed asset class");

		case "EQ" :			
			System.out.println("Equities");
			break;
		case "FI" :
			System.out.println("Fixed Income");
			//break;
		}
	}

}
