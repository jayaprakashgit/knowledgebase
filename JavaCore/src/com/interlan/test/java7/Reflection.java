package com.interlan.test.java7;

public class Reflection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String message = "";
		Object obj = new Testing();
		Class[] patype = new Class[1];
		Class.forName("Testing").getDe
	}

}


class Testing{
	public String getMessage(String name){
		return "Hello "+name;
	}
}