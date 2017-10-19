package com.kesheng.QRMaker.dao;

import java.util.List;

import com.kesheng.QRMaker.domain.*;

public interface CompanyDao {
	Company get(int autoid);
	
	int save(Company company);
	
	void update(Company company);
	
	/*void update(String password);*/
	
	void delete(Company company);
	
	void delete(int autoid);
	
	List<Company> findAll();
	
	List<Company> findById(int id);
	
	List<Company> findByAdmin(String admin);
	
	List<Company> findMaxId();
	
	List<Company> findByResnum(String resnum);
}
