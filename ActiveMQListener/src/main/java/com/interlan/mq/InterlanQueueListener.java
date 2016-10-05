package com.interlan.mq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class InterlanQueueListener {

	private String brokerUrl;
	private String userName;
	private String password;
	private String appName;


	public InterlanQueueListener(String brokerUrl, String userName, String password, String appName) {
		super();
		this.brokerUrl = brokerUrl;
		this.userName = userName;
		this.password = password;
		this.appName = appName;
	}
	
	public void startReceving(final String queueName)throws Exception{
		
		Connection connection = null;
		Session session = null;
		try {
			//get the connection factory
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(this.userName, this.password, this.brokerUrl);
			
			//create a connection
			connection = connectionFactory.createConnection();
			
			//start
			connection.start();
			
			//create a session
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			//create a queue
			Destination queue = session.createQueue(queueName);
			
			//create a consumer
			MessageConsumer consumer = session.createConsumer(queue);
			final MyMessageListener myMessageListener = new MyMessageListener();
			consumer.setMessageListener(myMessageListener);
			
			while(true){
				System.out.println("["+Thread.currentThread()+"-"+this.appName+"]Listening message from queue : "+queueName);
				Thread.sleep(22500);
			}
			
		} catch (Exception e) {
			System.out.println("Exception while seinding the message to the queue...");
			throw e;
		}
		finally {
			if(connection != null){
				connection.close();
				if(session != null)
					session.close();
			}
		}
		
		
	}
}
