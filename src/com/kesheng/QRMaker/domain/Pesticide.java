package com.kesheng.QRMaker.domain;

import java.io.Serializable;

public class Pesticide implements Serializable {
	private static final long serialVersionUID = 1L;
	private int autoid;
	private int id;
	private String name;
	private String num;
	private String described;
	private String solution;
	private String usage;
	private String toxic;
	private int environment;

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

	public String getNum() {
		return num;
	}

	public String getDescribed() {
		return described;
	}

	public String getSolution() {
		return solution;
	}

	public String getUsage() {
		return usage;
	}

	public String getToxic() {
		return toxic;
	}

	public int getEnvironment() {
		return environment;
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

	public void setNum(String num) {
		this.num = num;
	}

	public void setDescribed(String described) {
		this.described = described;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public void setToxic(String toxic) {
		this.toxic = toxic;
	}

	public void setEnvironment(int environment) {
		this.environment = environment;
	}

	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj != null && obj.getClass() == Pesticide.class){
			Pesticide pes = (Pesticide)obj;
			return this.getId() == pes.getId();
		}
		return false;
	}
	
	public int hashcode(){
		return autoid;
	}
}
