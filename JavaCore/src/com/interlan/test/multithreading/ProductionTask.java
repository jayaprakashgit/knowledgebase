package com.interlan.test.multithreading;

public class ProductionTask implements Runnable{

	private final SharedPlace sharedPlace;
	private final int taskId;
	
	public ProductionTask(SharedPlace sharedPlace, int taskId) {
		// TODO Auto-generated constructor stub
		this.sharedPlace = sharedPlace;
		this.taskId = taskId;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
	
		synchronized (sharedPlace) {
			while(!sharedPlace.isEmpty()){
				try{
					sharedPlace.wait();
				}
				catch(InterruptedException ie){
					System.out.println("Execption on production...");
					ie.printStackTrace();
				}
			}
			sharedPlace.setCookie("Cookie made by "+this.taskId);
			sharedPlace.notifyAll();
		}
	}
	
}
