package com.kesheng.QRMaker.domain;

import java.io.Serializable;

public class Box implements Serializable {
	private static final long serialVersionUID = 1L;
	private long autoid;
	private long id;
	private String capacity;
	private int planid;
	private int companyid;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getAutoid() {
		return autoid;
	}

	public long getId() {
		return id;
	}

	public String getCapacity() {
		return capacity;
	}

	public int getPlanid() {
		return planid;
	}

	public int getCompanyid() {
		return companyid;
	}

	public void setAutoid(long autoid) {
		this.autoid = autoid;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public void setPlanid(int planid) {
		this.planid = planid;
	}

	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}

	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj != null && obj.getClass() == Box.class){
			Box box = (Box)obj;
			return this.getId() == box.getId();
		}
		return false;
	}

	public int hashcode(){
		return (int)autoid;
	}
	
}
