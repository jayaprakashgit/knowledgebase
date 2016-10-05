package com.interlan.listener;

import javax.persistence.PrePersist;

import com.interlan.bo.Department;

public class PreInsertListener{
	@PrePersist
	public void prePersist(Department department) {
		System.out.println("***** >>> Before insert departmentEntity is :"+department);
	}
}