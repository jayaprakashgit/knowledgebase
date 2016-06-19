package com.interlan.mq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class InterlanQueueSender {

	private String brokerUrl;
	private String userName;
	private String password;
	
	public InterlanQueueSender(String brokerUrl, String userName, String password) {
		super();
		this.brokerUrl = brokerUrl;
		this.userName = userName;
		this.password = password;
	}
	
	public void sendMessage(final String message)throws Exception{
		
		Connection connection = null;
		Session session = null;
		String queueName = "test.queue";
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
			
			//create a producer
			MessageProducer producer = session.createProducer(queue);
			//producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);//This will allow message to store in the file/db even if the mq server down, so that later once up the message will be delivered
			
			TextMessage textMessage = session.createTextMessage(message);
			
			producer.send(textMessage);
			
			System.out.println("Message sent to queue successfully....");
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
