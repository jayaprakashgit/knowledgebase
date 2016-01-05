package com.interlan.test.problem;

public class DataTypeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x =10;
		String str = "20";
		System.out.println(x+str);
		System.out.println(x+Integer.parseInt(str));
		StringBuffer sb= new StringBuffer("abc");
		
		int i = Integer.parseInt("000000081");
		System.out.println("i: " + i);
		i = Integer.valueOf("00091");
		System.out.println("value of if : "+i);
		
		String replaceSample = "String replace Example with String regular expression";
		String newString = replaceSample.replaceAll("^S","R");
		System.out.println(newString);

		Integer a = new Integer(2);
		Integer b = new Integer(2);
		if (a == b) { // Should be a.equals(b)
		    System.out.println("a and b are equal");// This never gets executed.
		}
		else{
			System.out.println("a and b are not equal");
		}
		
		Integer c = Integer.valueOf(2);
		Integer d = Integer.valueOf(2);
		if (c == d) { // Should be a.equals(b), but happens to work with these particular values!
		    // This will get executed
			System.out.println("c and d are equal");
		}
		else{
			System.out.println("c and d are not equal");
		}
		
		Integer e = 1000;
		Integer f = 1000;
		if (e == f) { // Should be a.equals(b)
		    // Whether this gets executed depends on which compiler you use!
			System.out.println("e and f are equal");
		}
		else{
			System.out.println("e and f are not equal");
		}
	}

}
