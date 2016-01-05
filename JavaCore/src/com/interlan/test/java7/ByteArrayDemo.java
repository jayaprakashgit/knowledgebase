package com.interlan.test.java7;

import java.io.ByteArrayOutputStream;

public class ByteArrayDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		byte  c1[] = {10, 20, 30, 40, 50};
		byte  c2[] = {60, 70, 80, 90};
		
		ByteArrayOutputStream b1 = new ByteArrayOutputStream();
		ByteArrayOutputStream b2 = new ByteArrayOutputStream(10);
		
		b2.write(100);
		System.out.println("Out 1 : "+b2.size());
		b2.write(c1, 0, c2.length);
		System.out.println("Out 2 : "+b2.size());
	}

}
