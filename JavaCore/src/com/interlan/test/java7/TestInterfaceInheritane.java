package com.interlan.test.java7;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

public class TestInterfaceInheritane implements I2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(I2.name+",");
		System.out.println(I2.s1+",");
		System.out.println(((I1)new TestInterfaceInheritane()).name);
		
		
		String[] a = {"A", "D", "B", "E", "C"};
		List<String> l = Arrays.asList(a);

		Collection<String> c = (Collection<String>) getCollection(l);
		for(String s : c)
			System.out.println(s);
	}
	
	
	static public <E extends CharSequence> Collection<? extends CharSequence> getCollection(Collection<E> c){
		Collection<E> t = new TreeSet<>();
		for(E e : c)
			t.add(e);
		return t;
	}

}
