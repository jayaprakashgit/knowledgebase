package com.interlan.test.problem;

import java.util.LinkedHashMap;

public class LRUCache<K, V> extends LinkedHashMap<K, V>{
	
	private int cacheSize;
	
	public LRUCache(int cacheSize) {
		// TODO Auto-generated constructor stub
		super(5, 0.75f, false);
		this.cacheSize = cacheSize;
	}
	
	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		// TODO Auto-generated method stub
		return size() > cacheSize;
	}
	
	
	public static void main(String args[]){
		LRUCache<String, String> lruCache = new LRUCache<>(3);
		lruCache.put("1", "one");
		lruCache.put("2", "two");
		lruCache.put("3", "three");
		lruCache.put("4", "four");
		lruCache.get("3");
		lruCache.put("5", "five");
		
		System.out.println(lruCache);
		
	}

}
