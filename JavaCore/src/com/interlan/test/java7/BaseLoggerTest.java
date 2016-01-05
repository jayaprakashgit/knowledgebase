package com.interlan.test.java7;

public class BaseLoggerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseLogger baseLogger = BaseLogger.getInstance();
		baseLogger.addLog("welcome");
		baseLogger.addLog("to");
		baseLogger.addLog("India");
		baseLogger.printLog();
	}

}
