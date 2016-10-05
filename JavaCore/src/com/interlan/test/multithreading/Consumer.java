package com.interlan.test.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Consumer {

	private final SharedPlace sharedPlace;
	private final int COUNT;
	private int workDone = 0;
	
	public Consumer(SharedPlace sharedObj, int count) {
		// TODO Auto-generated constructor stub
		this.sharedPlace = sharedObj;
		this.COUNT = count;
	}
	
	public void startConsume(){
		ExecutorService executorService = Executors.newFixedThreadPool(15);
		for (int i = 0; i < COUNT; i++) {
			executorService.execute(new Worker());
		}
		executorService.shutdown();
	}
	
	public class Worker implements Runnable{
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized (sharedPlace) {
				while(sharedPlace.isEmpty()){
					try{
						sharedPlace.wait();
						Thread.sleep(1000);
					}
					catch(InterruptedException ie){
						System.out.println("Exeption at consumer...");
						ie.printStackTrace();
					}
				}
				System.out.println("Cookie to eat : "+sharedPlace.getCookie());
				sharedPlace.remove();
				workDone++;
				System.out.println("WorkDone : "+workDone);
				sharedPlace.notifyAll();
			}
		}
	}
	
}
