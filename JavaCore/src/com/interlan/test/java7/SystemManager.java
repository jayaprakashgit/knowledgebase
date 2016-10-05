package com.interlan.test.java7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;

public class SystemManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SystemManager systemManager = new SystemManager();
	}
	
	private static String initString;
	static{
		String curentString = null;
		try{
			BufferedReader reader = new BufferedReader(new FileReader("D:/Workspace/stsprojects/JavaCore/src/com/interlan/test/java7/ArithmeticTest.java"));
			while((curentString = reader.readLine())  != null){
				initString = curentString;
			}
		}
		catch(IOException ex){
			throw new NoSuchElementException("File intitconfig.txt");
		}
	}
	
	public SystemManager() {
		// TODO Auto-generated constructor stub
		if(initString.length() == 0){
			throw new IllegalArgumentException("length is zero");
		}
		System.out.println("It works");
	}

}
