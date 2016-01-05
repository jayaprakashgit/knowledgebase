package com.interlan.test.collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentMapTest {
	
	public  static final int THREAD_POOL_SIZE = 5;

	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		testRunWithMultiThread(new Hashtable<>());
		testRunWithMultiThread(new HashMap<>());
		testRunWithMultiThread(new ConcurrentHashMap<>());
		
//		testRunWithSingleThread(new Hashtable<>());
//		testRunWithSingleThread(new HashMap<>());
//		testRunWithSingleThread(new ConcurrentHashMap<>());

	}

	public static void testRunWithMultiThread(Map<String, Integer> collectionObject) throws Exception{
		
		System.out.println("MultiThread Test Started for : "+collectionObject.getClass());
		long startTime = System.nanoTime();
		
		for(int i=0; i<15; i++){
			for(int j=0; j<15; j++){
				ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
				executorService.submit(new DataProcessor(collectionObject));
				executorService.shutdown();
				executorService.awaitTermination(1, TimeUnit.DAYS);
			}
		}
		
		long endTime = System.nanoTime();
		long totalTime = (endTime - startTime) / 1000000L;
		//System.out.println("TimeTaken to Add and Remove  : "+(endTime - startTime));
		System.out.println("totalTime "+totalTime);
	}
	
	public static void testRunWithSingleThread(Map<String, Integer> collectionObject) throws Exception{
		
		System.out.println("SingleThread Test Started for : "+collectionObject.getClass());
		long startTime = System.nanoTime();
		
		for(int i=0; i<15; i++){
			for(int j=0; j<15; j++){
				new DataProcessor(collectionObject).run();
			}
		}
		
		long endTime = System.nanoTime();
		long totalTime = (endTime - startTime) / 1000000L;
		//System.out.println("TimeTaken to Add and Remove  : "+(endTime - startTime));
		System.out.println("totalTime "+totalTime);
	}
	
}
