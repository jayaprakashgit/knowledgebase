package com.interlan;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CamelActiveMqExample4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext springContext = new ClassPathXmlApplicationContext("applicationContext4.xml");
		CamelContext camelContext= null;
		
		try {
			camelContext = SpringCamelContext.springCamelContext(springContext, false);
			camelContext.start();
			while(true){
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				camelContext.stop();
				springContext.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
