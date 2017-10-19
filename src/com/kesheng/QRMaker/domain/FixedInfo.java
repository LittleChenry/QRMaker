package com.kesheng.QRMaker.domain;

import java.io.Serializable;

public class FixedInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int autoid;
	private String fixedtext;
	private String pagepath;
	private int companyid;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getAutoid() {
		return autoid;
	}

	public String getFixedtext() {
		return fixedtext;
	}

	public String getPagepath() {
		return pagepath;
	}

	public void setAutoid(int autoid) {
		this.autoid = autoid;
	}

	public void setFixedtext(String fixedtext) {
		this.fixedtext = fixedtext;
	}

	public void setPagepath(String pagepath) {
		this.pagepath = pagepath;
	}

	public int getCompanyid() {
		return companyid;
	}

	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}

	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj != null && obj.getClass() == FixedInfo.class){
			FixedInfo saveinfo = (FixedInfo)obj;
			return this.getAutoid() == saveinfo.getAutoid();
		}
		return false;
	}
	
	public int hashcode(){
		return autoid;
	}
}
