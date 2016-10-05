package com.interlan.test.java7;

public class MethodTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		a.m1();
		a.m2();
		a.m3();
		a.m4();
	}

}

class A{
	public void m1(){
		System.out.println("m1");
	}
	
	protected void m2(){
		System.out.println("m2");
	}

	private void m3(){
		System.out.println("m3");
	}

	void m4(){
		System.out.println("m4");
	}

}