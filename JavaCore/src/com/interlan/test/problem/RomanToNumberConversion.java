package com.interlan.test.problem;

import java.util.Scanner;

public class RomanToNumberConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RomanToNumberConversion romanToNumberConversion = new RomanToNumberConversion();
		romanToNumberConversion.startConvertion();
	}
	
	public void startConvertion(){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String inputData = scanner.next();
			switch(inputData){
				default :
					checkRoman(inputData);
					break;
				case "END" :
					startConvertion();
			}
		}
	}
	
	public void checkRoman(String romanInput){
		romanInput = romanInput.toUpperCase();
		int decimal = 0;
		int lastNumber = 0;
		
		for(int x=romanInput.length()-1; x>=0; x--){
			char romanChar = romanInput.charAt(x);
			switch(romanChar){
				case 'M' :
					decimal = calculateNumberForRomanChar(1000, lastNumber, decimal);
					lastNumber = 1000;
					break;
				case 'D' :
					decimal = calculateNumberForRomanChar(500, lastNumber, decimal);
					lastNumber = 500;
					break;
				case 'C' :
					decimal = calculateNumberForRomanChar(100, lastNumber, decimal);
					lastNumber = 100;
					break;
				case 'L' :
					decimal = calculateNumberForRomanChar(50, lastNumber, decimal);
					lastNumber = 50;
					break;
				case 'X' :
					decimal = calculateNumberForRomanChar(10, lastNumber, decimal);
					lastNumber = 10;
					break;
				case 'V' :
					decimal = calculateNumberForRomanChar(5, lastNumber, decimal);
					lastNumber = 5;
					break;
				case 'I' :
					decimal = calculateNumberForRomanChar(1, lastNumber, decimal);
					lastNumber = 1;
					break;
			}
		}
		System.out.println("Roman Letter: "+romanInput+" equivalent number is : "+decimal);
	}
	
	
	public int calculateNumberForRomanChar(int totalRomanDecimal, int lastRomanNumber, int lastDecimal){
		if(lastRomanNumber > totalRomanDecimal)
			return lastDecimal - totalRomanDecimal;
		else
			return lastDecimal + totalRomanDecimal;
	}

}
