package com.interlan.test.java7;

import java.util.Set;

public class MyCollection<T> {
	private Set<T> set;
	public Set<T> getCollection(){
		return this.set;
	}
}

class MyTest{
	public void TestCollection(MyCollection<?> collection){
		Set<?> set = collection.getCollection();
		//Set set = collection.getCollection();
	}
}



