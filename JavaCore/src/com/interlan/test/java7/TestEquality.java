package com.interlan.test.java7;

public class TestEquality{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 0;
		System.out.println((a!=0)?"true":"false");
		
		Double d = null;
		System.out.println((d instanceof Double) ? "true" : "false");
		
		String e = "1";
		System.out.println(("1"!= e)?"true":"false");
		
		int c = 0;
		System.out.println((0 == c++)?"true":"false");
		
		boolean b = false;
		System.out.println((b=true)?"true":"false");
		
		if(c>0)
			System.out.println("zeeo");
			System.out.println("two");
		
		System.out.println("------------------");
			
		Long i = new Long(10);
		long j = 10;
		if(i.equals(j))
			System.out.println("Equal");
		else
			System.out.println("Not equal");
				
			
	}

}
