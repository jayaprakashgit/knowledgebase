package com.interlan.test.multithreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ArrayBlockingQueueExample {

	public static BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(5);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executorServiceP = Executors.newFixedThreadPool(5);
		for(int i=0; i<10; i++){
			executorServiceP.submit(new Producer());
		}
		executorServiceP.shutdown();
		
		
		ExecutorService executorServiceC = Executors.newFixedThreadPool(5);
		for(int i=0; i<10; i++){
			executorServiceC.submit(new Consumer());
		}
		executorServiceC.shutdown();
	}
	
	public static class Producer implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				try {
					System.out.println("placing the cookie....");
					blockingQueue.put("cookie :"+ new Random().nextInt());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static class Consumer implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				try {
					Thread.sleep(1000);
					System.out.println(blockingQueue.take());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
