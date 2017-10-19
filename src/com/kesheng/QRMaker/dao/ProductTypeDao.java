package com.kesheng.QRMaker.dao;

import java.util.List;

import com.kesheng.QRMaker.domain.Plan;
import com.kesheng.QRMaker.domain.ProductType;

public interface ProductTypeDao {
	ProductType get(int autoid);
	
	int save(ProductType producttype);
	
	void update(ProductType producttype);
	
	void delete(ProductType producttype);
	
	void delete(int autoid);
	
	List<ProductType> findAll();
	
	List<ProductType> findById(int id);
	
	List<ProductType> findMaxId();
	
	List<ProductType> findByCompany(int company_id);
	
	List<ProductType> findByPesticideAndCompany(int pesticide_id,int company_id);
}
