package com.interlan.test.problem;

import java.util.Arrays;

public class ReplaceCharFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String srcString = "JAyAprAkAsh";
		System.out.println(ReplaceCharFromString.replace(srcString, 'A', 'a'));
		
	}
	
	public static String replace(final String srcString, char fromChar, char replaceChar){
		String result = srcString;
		int replacementIndex = srcString.indexOf(fromChar);
		if(replacementIndex < 0){
			return result;
		}
		else{
			char[] charArray = srcString.toCharArray();
			charArray[replacementIndex]= replaceChar;
			result = replace(String.valueOf(charArray), fromChar, replaceChar);
		}
		return result;
	}

}
