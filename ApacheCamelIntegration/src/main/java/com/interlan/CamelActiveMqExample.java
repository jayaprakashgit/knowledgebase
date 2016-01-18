package com.interlan;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.util.jndi.JndiContext;

public class CamelActiveMqExample {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		JndiContext jndiContext = new JndiContext();
		jndiContext.bind("testApp", new TestApp());
		
		CamelContext camelContext = new DefaultCamelContext(jndiContext);
		
		ActiveMQComponent activeMQComponent = new ActiveMQComponent();
		activeMQComponent.setBrokerURL("tcp://localhost:61616");
		activeMQComponent.setUserName("admin");
		activeMQComponent.setPassword("admin");
		
		camelContext.addComponent("activemq", activeMQComponent);
		try{
			camelContext.addRoutes(new RouteBuilder() {
				
				//test.queue is the queue name
				@Override
				public void configure() throws Exception {
					// TODO Auto-generated method stub
					from("activemq:queue:test.queue")
					.to("bean:testApp?method=hello")
					.to("stream:out");
				}
			});
			
			ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
			while(true){
				camelContext.start();
				Thread.sleep(1000);
			}
			
			//This will post the messge to the queue name called test.queue
			/*for(int i=0; i<5; i++){
				producerTemplate.sendBody("activemq:queue:test.queue","body"+i);
			}*/
			//Thread.sleep(1000);
		}
		finally{
			camelContext.stop();
		}
		
	}

}
