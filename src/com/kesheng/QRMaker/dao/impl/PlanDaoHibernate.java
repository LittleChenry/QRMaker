package com.kesheng.QRMaker.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.kesheng.QRMaker.dao.*;
import com.kesheng.QRMaker.domain.*;

public class PlanDaoHibernate extends HibernateDaoSupport implements PlanDao {
	public Plan get(int autoid) {
		return getHibernateTemplate().get(Plan.class, autoid);
	}
	
	public int save(Plan plan) {
		return (Integer)getHibernateTemplate().save(plan);
	}
	
	public void update(Plan plan) {
		getHibernateTemplate().update(plan);
	}
	
	public void delete(Plan plan) {
		getHibernateTemplate().delete(plan);
	}
	
	public void delete(int id) {
		getHibernateTemplate().delete(get(id));
	}
	
	@SuppressWarnings("unchecked")
	public List<Plan> findAll() {
		return (List<Plan>)getHibernateTemplate().find("from Plan");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Plan> findById(int id) {
		// TODO Auto-generated method stub
		return (List<Plan>)getHibernateTemplate().find("from Plan where id=?",id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Plan> findByMaxId() {
		// TODO Auto-generated method stub
		return (List<Plan>)getHibernateTemplate().find("from Plan where id=(select max(id) from Plan)");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Plan> findByCompany(int company_id) {
		// TODO Auto-generated method stub
		return (List<Plan>)getHibernateTemplate().find("from Plan where company.id=?",company_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Plan> findByProductTypeAndCompany(int producttype_id, int company_id) {
		// TODO Auto-generated method stub
		return (List<Plan>)getHibernateTemplate().find("from Plan where producttype.id=? and company.id=?",producttype_id,company_id);
	}

}
