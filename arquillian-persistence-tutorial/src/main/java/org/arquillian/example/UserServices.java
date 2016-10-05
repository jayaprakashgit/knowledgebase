package org.arquillian.example;

import javax.ejb.Stateless;


/**
 * @author Jayaprakash
 *
 */
@Stateless
public class UserServices {

	public String sayHello(){
		System.out.println("sayHello called");
		return "hello";
	}

}
