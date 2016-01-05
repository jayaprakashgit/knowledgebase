package com.interlan.test.java7;

public class Inheritace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class abc{
	protected int getLocalCode(String a, boolean b){
		return 1;
	}
}

class bbc extends abc{
	@Override
	protected int getLocalCode(String a, boolean b){
		return 1;
	}
}

