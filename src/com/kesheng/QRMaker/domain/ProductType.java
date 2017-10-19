package com.kesheng.QRMaker.domain;

import java.io.Serializable;

public class ProductType implements Serializable {
	private static final long serialVersionUID = 1L;
	private int autoid;
	private int id;
	private String type;
	private String life;
	private Pesticide pesticide;
	private Company company;
	private Specification specification;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getAutoid() {
		return autoid;
	}

	public int getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getLife() {
		return life;
	}

	public Pesticide getPesticide() {
		return pesticide;
	}

	public Company getCompany() {
		return company;
	}

	public Specification getSpecification() {
		return specification;
	}

	public void setAutoid(int autoid) {
		this.autoid = autoid;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setLife(String life) {
		this.life = life;
	}

	public void setPesticide(Pesticide pesticide) {
		this.pesticide = pesticide;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public void setSpecification(Specification specification) {
		this.specification = specification;
	}

	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj != null && obj.getClass() == ProductType.class){
			ProductType protype = (ProductType)obj;
			return this.getId() == protype.getId();
		}
		return false;
	}
	
	public int hashcode(){
		return autoid;
	}
}
