package com.interlan.test.problem;

public class FindMissingNumberInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inputArray =  new int[]{1, 2, 3, 4, 5, 7, 8, 9, 10, 12, 6};
		int expectedSum = 0, sum = 0;
		for(int i=1; i<=inputArray.length+1; i++)
		{
			expectedSum = expectedSum + i;
		}
		
		for (int i : inputArray) {
			sum = sum +  i;
		}
		System.out.println("missing number is  :"+(expectedSum - sum));
	}
	
	

}
