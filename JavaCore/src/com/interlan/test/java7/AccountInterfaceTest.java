package com.interlan.test.java7;

import java.math.BigDecimal;

public class AccountInterfaceTest implements Account {

	public AccountInterfaceTest(BigDecimal intiValue){
		balance = intiValue;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccountInterfaceTest accountInterfaceTest = new AccountInterfaceTest(new BigDecimal(50.00));
		System.out.println(accountInterfaceTest);
	}

}

interface Account{
	BigDecimal balance = new BigDecimal(0.00);
}
