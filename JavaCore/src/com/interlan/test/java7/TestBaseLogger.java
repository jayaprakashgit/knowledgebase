package com.interlan.test.java7;

public class TestBaseLogger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseLogger.getInstance().addLog("test");
		BaseLogger.getInstance().printLog();
	}	

}
