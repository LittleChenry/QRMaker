package com.kesheng.QRMaker.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.kesheng.QRMaker.dao.FixedInfoDao;
import com.kesheng.QRMaker.domain.FixedInfo;

public class FixedInfoDaoHibernate extends HibernateDaoSupport implements FixedInfoDao {

	@Override
	public FixedInfo get(int autoid) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(FixedInfo.class, autoid);
	}

	@Override
	public int save(FixedInfo fixedinfo) {
		// TODO Auto-generated method stub
		return (int) getHibernateTemplate().save(fixedinfo);
	}

	@Override
	public void update(FixedInfo fixedinfo) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(fixedinfo);
	}

	@Override
	public void delete(FixedInfo fixedinfo) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(fixedinfo);
	}

	@Override
	public void delete(int autoid) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(autoid));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FixedInfo> findByCompany(int company_id) {
		// TODO Auto-generated method stub
		return (List<FixedInfo>)getHibernateTemplate().find("from FixedInfo where companyid=?",company_id);
	}
	
}
