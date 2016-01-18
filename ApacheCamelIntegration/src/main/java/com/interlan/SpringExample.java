package com.interlan;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TestApp testApp = (TestApp)context.getBean("testApp");
		testApp.hello("JP");
		
	}

}
