package com.kesheng.QRMaker.dao;

import java.util.List;

import com.kesheng.QRMaker.domain.Pesticide;

public interface PesticideDao {
	Pesticide get(int autoid);
	
	int save(Pesticide pesticide);
	
	void update(Pesticide pesticide);
	
	void delete(Pesticide pesticide);
	
	void delete(int autoid);
	
	List<Pesticide> findAll();
	
	List<Pesticide> findById(int id);
}
