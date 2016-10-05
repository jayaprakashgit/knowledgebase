package com.interlan.test.multithreading;

public class ThreadPool {
	public static void main(String[] args) {
		SharedPlace sharedObj = new SharedPlace();
		Producer producer = new Producer(sharedObj, 100);
		Consumer consumer = new Consumer(sharedObj, 100);
		producer.startProduce();
		consumer.startConsume();
				
	}
}
