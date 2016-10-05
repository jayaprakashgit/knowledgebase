package com.interlan.test.exception;

public class TestMultiCatchException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		calculate(new int[]{1, 2, 3}, 2, 0);
	}
	
	public static int calculate(int[] arr, int x, int y){
		try{
			System.out.println(arr[x]/y);
		}
		catch(ArithmeticException | ArrayIndexOutOfBoundsException ex){
			throw ex;
		}
		catch(Exception e){
			throw e;
		}
		
		return 0;
	}

}
