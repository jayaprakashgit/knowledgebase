package com.interlan.test.problem;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class AnagramTest {

	public static void main(String[] args) {
		startAnagramTest();
	}
	
	public static void startAnagramTest(){

		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter two string with space with eachother...");
		while(scanner.hasNext()){
			String inputData = scanner.nextLine();
			switch(inputData){
				default :
					String[] data = inputData.split(" ");
					System.out.println(isAnagram(data[0], data[1]));
					startAnagramTest();
				case "END" :
					break;
			}
		}
			
	
	}
	
	public static boolean isAnagram(String s1, String s2){
		
		if(s1.length() != s2.length())
			return false;
		
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		char[] firstChar = s1.toCharArray();
		char[] secondChar = s2.toCharArray();
				
		Arrays.sort(firstChar);
		Arrays.sort(secondChar);
		
		return (Arrays.toString(firstChar).equals(Arrays.toString(secondChar))?true:false);
	}

}
