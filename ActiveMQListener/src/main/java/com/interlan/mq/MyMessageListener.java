package com.interlan.mq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MyMessageListener implements MessageListener{
	
	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		if(message instanceof TextMessage){
			TextMessage textMessage = (TextMessage) message;
			try {
				System.out.println("MessageReceived : "+textMessage.getText());
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				System.out.println("Error retriving message....");
				System.exit(1);
			}
		}
	}

}
