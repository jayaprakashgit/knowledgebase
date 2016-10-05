package com.interlan.test.java7;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PreciseRethrow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			precise();
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
		catch(ParseException ex){
			ex.printStackTrace();
		}
		
/*		
		try{
			precise2();
		}
		catch(IOException ex){
			ex.printStackTrace();
		}*/
	}

	//java 7: precise rethrow.
	//no longer "throws Exception"
	public static void precise() throws ParseException, IOException{
	    try {
	        new SimpleDateFormat("yyyyMMdd").parse("foo");
	        new FileReader("file.txt").read();
	    } catch (Exception e) {
	        System.out.println("Caught exception: " + e.getMessage());
	        throw e;
	    }
	}
	 
	//this example handles ParseException
	public static void precise2() throws IOException{
	    try {
	        new SimpleDateFormat("yyyyMMdd").parse("foo");
	        new FileReader("file.txt").read();
	    } catch(ParseException e){
	        System.out.println("Parse Exception");
	    }catch (Exception e) {
	        System.out.println("Caught exception: " + e.getMessage());
	        throw e;
	    }
	}
}
