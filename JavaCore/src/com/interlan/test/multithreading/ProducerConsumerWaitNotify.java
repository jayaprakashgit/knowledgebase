package com.interlan.test.multithreading;

import java.util.LinkedList;
import java.util.Random;

public class ProducerConsumerWaitNotify {

	public LinkedList<String> list = new LinkedList<>();
	private static final int LIMIT = 5;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ProducerConsumerWaitNotify producerConsumerWaitNotify = new ProducerConsumerWaitNotify();
			Thread t1 = new Thread(new Runnable(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						producerConsumerWaitNotify.produce();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			
			Thread t2 = new Thread(new Runnable(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						producerConsumerWaitNotify.consume();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			
			t1.start(); t2.start(); t1.join(); t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void produce() throws InterruptedException{
		while(true){
			synchronized (this) {
				while(list.size() == LIMIT){
					System.out.println("waiting to place the element as no room to place now");
					wait();
				}
				list.add("hai-"+new Random().nextInt());
				notify();
			}
		}
	}
	
	public void consume() throws InterruptedException{
		while(true){
			synchronized (this) {
				while(list.size() == 0){
					System.out.println("waiting consume as no element found");
					wait();
				}
				System.out.println("removing  element :"+list.removeFirst());
				notify();
			}
		}
	}

}
