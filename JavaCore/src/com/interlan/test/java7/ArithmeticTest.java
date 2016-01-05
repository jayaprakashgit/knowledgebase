package com.interlan.test.java7;

public class ArithmeticTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number1 = Integer.parseInt(args[0]);
		int number2 = Integer.parseInt(args[1]);
		//Integer number2 = null;
		
		try {
			System.out.println(number1 / number2);
		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getClass());
			System.out.println("first catch");
		}
		catch(NullPointerException e){
			System.out.println(e.getClass());
			System.out.println("second catch");
		}
		catch(Exception e){
			System.out.println(e.getClass());
			System.out.println("third catch");
		}
	}

}
