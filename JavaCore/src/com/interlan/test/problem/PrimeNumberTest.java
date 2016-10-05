package com.interlan.test.problem;

public class PrimeNumberTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i<100; i++)
			if(isPrime(i))
				System.out.println(i);
	}

	public static boolean isPrime(int number){
		if(number <= 2)
			return false;
		for(int i=2; i<number; i++){
			if (number % i == 0)
				return false;
		}
		return true;
	}
}
