package com.interlan.test.java7;

public class TestInterface implements I1, I2{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(I1.name);
		System.out.println(I2.name);
		System.out.println(I2.sex);
		I1.myStaticMethod();
		I2.myStaticMethod();
	}

	@Override
	public void myNonStaticMethod() {
		// TODO Auto-generated method stub
		System.out.println("TestInterface myNonStaticMethod Implementation ....");
	}

}
