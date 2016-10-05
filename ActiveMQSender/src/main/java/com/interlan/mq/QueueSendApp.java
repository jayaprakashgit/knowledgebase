package com.interlan.mq;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class QueueSendApp 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try {
			InterlanQueueSender interlanQueueSender = new InterlanQueueSender("tcp://localhost:61616","admin","admin");
			interlanQueueSender.sendMessage("Hai, welcome to Active MQ at : "+new Date());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
