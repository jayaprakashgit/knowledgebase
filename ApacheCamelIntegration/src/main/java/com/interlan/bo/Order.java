package com.interlan.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
@Entity
@javax.persistence.Table(name="order")
public class Order {
	public Order(){
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oID")
	private int oID ;
	
	@Column(name = "oName")
	private String oName;

	public int getoID() {
		return oID;
	}

	public void setoID(int oID) {
		this.oID = oID;
	}

	public String getoName() {
		return oName;
	}

	public void setoName(String oName) {
		this.oName = oName;
	}
		
 
	
}
