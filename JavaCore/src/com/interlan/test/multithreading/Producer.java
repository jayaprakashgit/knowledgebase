package com.interlan.test.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Producer {

	private final SharedPlace sharedPlace;
	private final int COUNT;
	
	public Producer(SharedPlace sharedObj, int count) {
		// TODO Auto-generated constructor stub
		this.sharedPlace = sharedObj;
		this.COUNT = count;
	}
	
	public void  startProduce(){
		
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for(int i=0; i<COUNT; i++){
			executorService.submit(new ProductionTask(sharedPlace, i));
		}
		executorService.shutdown();
	}
	
	public class Task implements Runnable{
		private final int taskId;
		
		public Task(int taskId) {
			// TODO Auto-generated constructor stub
			this.taskId = taskId;
		}
		
		@Override
		public void run() {
			
			String str = "Task - "+taskId;
			// TODO Auto-generated method stub
			synchronized (sharedPlace) {
				while(!sharedPlace.isEmpty()){
					try{
						sharedPlace.wait();
						Thread.sleep(1000);
					}
					catch(InterruptedException ie){
						System.out.println("exeception at production");
						ie.printStackTrace();
					}
				}
				sharedPlace.setCookie("Cookie added by "+str);
				sharedPlace.notifyAll();
			}
		}
		
		
	}
}
