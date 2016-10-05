package com.interlan.mq;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class QueueReceiverApp2 
{
    public static void main( String[] args )
    {
    	String queueName = "test.queue";
    	
        try {
			InterlanQueueListener interlanQueueListener = new InterlanQueueListener("tcp://localhost:61616","admin","admin","App2");
			interlanQueueListener.startReceving(queueName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
