package com.interlan.test.problem;

public class FibanocciSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++)
		System.out.println(FibanocciSequence.fibanocci(i));
	}
	
	public static int fibanocci(int n){
		if(n == 0)
			return 0;
		else if(n ==  1)
			return 1;
		
		return fibanocci(n-1)+fibanocci(n-2);
	}

}
