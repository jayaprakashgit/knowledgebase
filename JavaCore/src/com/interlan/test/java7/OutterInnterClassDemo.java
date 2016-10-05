package com.interlan.test.java7;

public class OutterInnterClassDemo {

	private String outerPrivateVariable = "outerPrivateVariable";
	public String outerPublicVariable = "outerPublicVariable";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OutterInnterClassDemo outterInnterClassDemo = new OutterInnterClassDemo();
		outterInnterClassDemo.outterMethod();
		
		OutterInnterClassDemo.InnerClass innerObject = outterInnterClassDemo.new InnerClass();
		System.out.println(innerObject.innerPrivateVariable);
		System.out.println(innerObject.innerPublicVariable);
		innerObject.innerMethod();
		
		System.out.println(innerPrivateVariable);
		System.out.println(innerPublicVariable);

	}
	
	public void outterMethod(){
		/*System.out.println(innerPrivateVariable);
		System.out.println(innerPublicVariable);*/
	}
	
	class InnerClass{
		private String innerPrivateVariable = "innerPrivateVariable";
		public String innerPublicVariable = "innerPublicVariable";
		
		public void innerMethod(){
			System.out.println(outerPrivateVariable);
			System.out.println(outerPublicVariable);
		}
	}

}
