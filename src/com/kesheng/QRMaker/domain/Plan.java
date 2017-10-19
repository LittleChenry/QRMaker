package com.kesheng.QRMaker.domain;

import java.io.Serializable;

public class Plan implements Serializable {
	private static final long serialVersionUID = 1L;
	private int autoid;
	private int id;
	private String remark;
	private int yield;
	private int capacity;
	private int status;
	private ProductType producttype;
	private Company company;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getAutoid() {
		return autoid;
	}

	public int getId() {
		return id;
	}

	public String getRemark() {
		return remark;
	}

	public int getYield() {
		return yield;
	}

	public int getCapacity() {
		return capacity;
	}

	public int getStatus() {
		return status;
	}

	public ProductType getProducttype() {
		return producttype;
	}

	public Company getCompany() {
		return company;
	}

	public void setAutoid(int autoid) {
		this.autoid = autoid;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setYield(int yield) {
		this.yield = yield;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setProducttype(ProductType producttype) {
		this.producttype = producttype;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj != null && obj.getClass() == Plan.class){
			Plan plan = (Plan)obj;
			return this.getId() == plan.getId();
		}
		return false;
	}

	public int hashcode(){
		return autoid;
	}

}
