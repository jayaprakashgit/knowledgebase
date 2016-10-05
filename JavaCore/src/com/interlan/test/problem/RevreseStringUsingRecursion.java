package com.interlan.test.problem;

public class RevreseStringUsingRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(RevreseStringUsingRecursion.reverse("jaya"));
	}
	
	public static String reverse(String srcString){
		int length=srcString.length(); 
		if(length <= 0)
			return "";
		
		return srcString.charAt(length-1) + reverse(srcString.substring(0, length-1));
	}

}
