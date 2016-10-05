package com.interlan.test.java7;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ResourceBundleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Integer before = new Integer(25);
			Integer after = ++before == 26?5: new Integer(10);
			System.out.println(after.intValue() - before.intValue());
			
			
			Locale locale = new Locale("th", "TH");
			ResourceBundle labels = ResourceBundle.getBundle("com.interlan.test.java7.TestBundle", locale);
			System.out.println(labels.getString("sayHello"));
		} catch (MissingResourceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		getValue();
		
	}
	
	public static void getValue(){
		//Locale locale = new Locale("en", "US");
		Locale locale = new Locale("fr", "CA");
		ResourceBundle labels = ResourceBundle.getBundle("com.interlan.test.java7.MyBundle", locale);

		System.out.println(labels.getString("label1"));
	}

}
