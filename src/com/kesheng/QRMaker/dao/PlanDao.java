package com.kesheng.QRMaker.dao;

import java.util.List;

import com.kesheng.QRMaker.domain.*;

public interface PlanDao {
	Plan get(int autoid);
	
	int save(Plan plan);
	
	void update(Plan plan);
	
	void delete(Plan plan);
	
	void delete(int autoid);
	
	List<Plan> findAll();
	
	List<Plan> findById(int id);
	
	List<Plan> findByMaxId();
	
	List<Plan> findByCompany(int company_id);
	
	List<Plan> findByProductTypeAndCompany(int producttype_id,int company_id);
	
}
