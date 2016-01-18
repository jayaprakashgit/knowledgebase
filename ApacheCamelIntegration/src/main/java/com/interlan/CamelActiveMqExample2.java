package com.interlan;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CamelActiveMqExample2 {

	public static void main(String[] args) throws Exception{
		ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext2.xml");
		CamelContext camelContext = SpringCamelContext.springCamelContext(appContext,false); //true - will make spring to start the camel context
		try{
			camelContext.start();
			ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
			for(int i=0; i<5; i++){
				producerTemplate.sendBody("activemq:queue:test.queue","body"+i);
			}
			Thread.sleep(1000);
		}
		finally{
			camelContext.stop();
			
		}
	}

}
