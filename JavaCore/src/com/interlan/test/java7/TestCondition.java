package com.interlan.test.java7;

public class TestCondition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 0, y = 4, z = 5;
		if(x>0)	
			if(y<3)
				System.out.println("one");
			else if(y<4)
				System.out.println("two");
			else if(z> 5)
				System.out.println("Four");
		else
			System.out.println("Four");
		
		System.out.println("------------------....");
		
		int i = 2; int j = 3; String k ="";
		System.out.println(k+i+j);
		int xa =5;
		System.out.println(xa--);
		System.out.println(xa);
		
		System.out.println("-------------");
		int  abc = 5;
		int answer = abc--; 
		System.out.println(answer);
		
		
		int [][]a = new int[5][];
		int a1[][] = {{1},{1, 2}};
		
	}

}
