package com.kesheng.QRMaker.domain;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	private long autoid;
	private long id;
	private Date pdcdate;
	private Date packdate;
	private int producttypeid;
	private long boxid;
	private int flag;
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

	public Date getPdcdate() {
		return pdcdate;
	}

	public Date getPackdate() {
		return packdate;
	}

	public int getProducttypeid() {
		return producttypeid;
	}

	public long getBoxid() {
		return boxid;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
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

	public void setPdcdate(Date pdcdate) {
		this.pdcdate = pdcdate;
	}

	public void setPackdate(Date packdate) {
		this.packdate = packdate;
	}

	public void setProducttypeid(int producttypeid) {
		this.producttypeid = producttypeid;
	}

	public void setBoxid(long boxid) {
		this.boxid = boxid;
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
		if(obj != null && obj.getClass() == Product.class){
			Product pro = (Product)obj;
			return this.getId() == pro.getId();
		}
		return false;
	}
	
	public int hashcode(){
		return (int)autoid;
	}
}
