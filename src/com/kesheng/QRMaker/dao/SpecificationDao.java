package com.kesheng.QRMaker.dao;

import java.util.List;

import com.kesheng.QRMaker.domain.ProductType;
import com.kesheng.QRMaker.domain.Specification;

public interface SpecificationDao {
	Specification get(int autoid);
	
	int save(Specification specification);
	
	void update(Specification specification);
	
	void delete(Specification specification);
	
	void delete(int autoid);
	
	List<Specification> findAll();
	
	List<Specification> findById(int id);
	
	List<Specification> findMaxId();
	
	List<Specification> findByProType(ProductType producttype);
}
