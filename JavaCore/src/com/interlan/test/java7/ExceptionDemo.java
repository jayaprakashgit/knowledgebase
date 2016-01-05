package com.interlan.test.java7;

public class ExceptionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x=5, y=0;
		try{
			try{
				System.out.println(x);
				System.out.println(x/y);
				System.out.println(y);
			}
			catch(ArithmeticException ex){
				System.out.println("Inner Catch1");
				throw ex;
			}
			catch(RuntimeException ex){
				System.out.println("Inner catch2");
			}
			finally {
				System.out.println("Inner fna..");
			}
		}
		catch(Exception ex){
			System.out.println("outer catch");
		}
		
	}

}
