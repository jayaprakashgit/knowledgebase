package com.interlan.test.java7;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Company.HeadBranch company = new Company().new HeadBranch();
		System.out.println(company.getEmployeeCount());
	}

}

class Company{
	private int employeeCount = 10;
	class HeadBranch{
		public int getEmployeeCount(){
			//return Company.this.employeeCount;//this allso fine
			return employeeCount;
		}
	}
}