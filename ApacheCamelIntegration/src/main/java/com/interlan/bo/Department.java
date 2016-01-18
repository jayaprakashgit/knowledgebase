package com.interlan.bo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.interlan.listener.PreInsertListener;

@Table(name="department")
@Entity
@EntityListeners(PreInsertListener.class)
public class Department implements Serializable {
	public Department() {
	}
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "depId")
	private int depId;
	private String depName;
	@Transient private long syncTime;
	
	 
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn( name="depId")
	private List<Student> studentSet;
	 
	public int getDepId() {
		return depId;
	}
	public void setDepId(int depId) {
		this.depId = depId;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	 public List<Student> getStudentSet() {
		return studentSet;
	}
	public void setStudentSet(List<Student> studentSet) {
		this.studentSet = studentSet;
	} 
	 
}
