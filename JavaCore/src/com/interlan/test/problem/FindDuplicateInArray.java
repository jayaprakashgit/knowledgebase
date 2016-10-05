package com.interlan.test.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDuplicateInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inputData = new int[] {1, 2, 3, 4, 5, 3};
		int previous = 0;
		List<Integer> result = new ArrayList<Integer>();
		Arrays.sort(inputData);
		previous = inputData[0];
		result.add(previous);
		for(int i=1; i<inputData.length; i++){
			if(previous != inputData[i]){
				result.add(inputData[i]);
			}
			previous = inputData[i];
		}
		
		for (Object data : result) {
			System.out.println(data);
		}
	}

}
