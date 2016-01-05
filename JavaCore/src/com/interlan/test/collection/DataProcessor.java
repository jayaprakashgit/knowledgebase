package com.interlan.test.collection;

import java.util.Map;

public class DataProcessor implements Runnable{

	private Map<String, Integer> dataHolder;
	
	public DataProcessor(Map<String, Integer> collectionObject){
		this.dataHolder = collectionObject;
	}
	
	public void run(){
		for (int i = 0; i<500000;i++){
			dataHolder.put(String.valueOf(i), i);
			dataHolder.get(i);
		}
	}
}
