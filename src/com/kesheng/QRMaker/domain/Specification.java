package com.kesheng.QRMaker.domain;

import java.io.Serializable;

public class Specification implements Serializable {
	private static final long serialVersionUID = 1L;
	private int autoid;
	private int id;
	private String specification;
	private String material;
	private int materialno;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getAutoid() {
		return autoid;
	}

	public int getId() {
		return id;
	}

	public String getSpecification() {
		return specification;
	}

	public String getMaterial() {
		return material;
	}

	public int getMaterialno() {
		return materialno;
	}

	public void setAutoid(int autoid) {
		this.autoid = autoid;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public void setMaterialno(int materialno) {
		this.materialno = materialno;
	}

	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj != null && obj.getClass() == Specification.class){
			Specification specification = (Specification)obj;
			return this.getId() == specification.getId();
		}
		return false;
	}
	
	public int hashcode(){
		return autoid;
	}
}
