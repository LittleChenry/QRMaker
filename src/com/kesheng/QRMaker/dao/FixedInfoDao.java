package com.kesheng.QRMaker.dao;

import java.util.List;

import com.kesheng.QRMaker.domain.*;

public interface FixedInfoDao {
	FixedInfo get(int autoid);
	
	int save(FixedInfo fixedinfo);
	
	void update(FixedInfo fixedinfo);
	
	void delete(FixedInfo fixedinfo);
	
	void delete(int autoid);
	
	List<FixedInfo> findByCompany(int company_id);
}
