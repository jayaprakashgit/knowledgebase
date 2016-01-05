package com.interlan.test.multithreading;

/**
 * SharedPlace class is common shared place where Producer Thread Pool places its outputs
 * and Consumer Thread Pool fetch those outputs and consume them.
 *
 */

public class SharedPlace {

	private String cookie;

	public String getCookie() {
		return cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}
	
	public void remove(){
		this.cookie = null;
	}
	
	public boolean  isEmpty(){
		return (this.cookie == null) ? true : false;
	}
}
