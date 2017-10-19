package com.kesheng.QRMaker.dao;

import java.util.List;

import com.kesheng.QRMaker.domain.Box;
import com.kesheng.QRMaker.domain.Product;

public interface BoxDao {
	Box get(long autoid);
	
	long save(Box box);
	
	void update(Box box);
	
	void delete(Box box);
	
	void delete(long autoid);
	
	List<Box> findAll();
	
	List<Box> findMaxId();
	
	List<Box> findById(long id);
}
