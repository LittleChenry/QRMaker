package com.kesheng.QRMaker.dao;

import java.util.List;

import com.kesheng.QRMaker.domain.*;

public interface ProductDao {
	Product get(long autoid);
	
	long save(Product product);
	
	void update(Product product);
	
	void delete(Product product);
	
	void delete(long autoid);
	
	List<Product> findAll();
	
	List<Product> findMaxId();
	
	List<Product> findByProType(ProductType producttype);
}
