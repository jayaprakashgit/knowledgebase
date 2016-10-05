package com.interlan.test.problem;

import java.util.ArrayList;
import java.util.Collections;

public class ComparatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee employee1 = new Employee("jp", "accounts", 30);
		Employee employee2 = new Employee("jaya", "mgmt", 23);
		Employee employee3 = new Employee("prakash", "accounts", 45);
		Employee employee4 = new Employee("jayaprakash", "accounts", 23);
		Employee employee5 = new Employee("ram", "accounts", 25);
		
		ArrayList<Employee> arrayList = new ArrayList<>();
		arrayList.add(employee1);
		arrayList.add(employee2);
		arrayList.add(employee3);
		arrayList.add(employee4);
		arrayList.add(employee5);
		
		System.out.println(arrayList);
		
		Collections.sort(arrayList, new EmployeeAgeComparator());
		
		System.out.println(arrayList);
		
		Collections.reverse(arrayList);
		
		System.out.println(arrayList);
		
	}

}
