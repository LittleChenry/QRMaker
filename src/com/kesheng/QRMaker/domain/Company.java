package com.kesheng.QRMaker.domain;

import java.io.Serializable;
import java.util.Calendar;

public class Company implements Serializable {
	private static final long serialVersionUID = 1L;
	private int autoid;
	private int id;
	private String name;
	private String admin;
	private String password;
	private String email;
	private String status;
	private Calendar restime;
	private Calendar statime;
	private String resnum;
	private long refusereason;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getAutoid() {
		return autoid;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAdmin() {
		return admin;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getStatus() {
		return status;
	}

	public Calendar getRestime() {
		return restime;
	}

	public Calendar getStatime() {
		return statime;
	}

	public String getResnum() {
		return resnum;
	}

	public long getRefusereason() {
		return refusereason;
	}

	public void setAutoid(int autoid) {
		this.autoid = autoid;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setRestime(Calendar restime) {
		this.restime = restime;
	}

	public void setStatime(Calendar statime) {
		this.statime = statime;
	}

	public void setResnum(String resnum) {
		this.resnum = resnum;
	}

	public void setRefusereason(long refusereason) {
		this.refusereason = refusereason;
	}

	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj != null && obj.getClass() == Company.class){
			Company com = (Company)obj;
			return this.getId() == com.getId();
		}
		return false;
	}
	
	public int hashcode(){
		return autoid;
	}
}
