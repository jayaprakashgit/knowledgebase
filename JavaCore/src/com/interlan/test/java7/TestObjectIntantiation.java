package com.interlan.test.java7;

public class TestObjectIntantiation {
	
	String objectId;
	
	TestObjectIntantiation containedInstance;
	
	public TestObjectIntantiation(String idValue) {
		// TODO Auto-generated constructor stub
		objectId = idValue;
	}
	
	public TestObjectIntantiation(String idValue, TestObjectIntantiation instanceValue) {
		// TODO Auto-generated constructor stub
		objectId = idValue;
		containedInstance = instanceValue;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestObjectIntantiation c1 = new TestObjectIntantiation("one");
		TestObjectIntantiation c2 = new TestObjectIntantiation("two", c1);
		TestObjectIntantiation c3 = new TestObjectIntantiation("three", c2);
		TestObjectIntantiation c4 = new TestObjectIntantiation("four", c2);
		c1= null;
		c2 =null;
		c3= null;
		c4= null;
	}

}
