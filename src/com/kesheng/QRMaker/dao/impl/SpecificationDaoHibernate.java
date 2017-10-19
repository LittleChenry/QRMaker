package com.kesheng.QRMaker.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.kesheng.QRMaker.dao.SpecificationDao;
import com.kesheng.QRMaker.domain.ProductType;
import com.kesheng.QRMaker.domain.Specification;

public class SpecificationDaoHibernate extends HibernateDaoSupport implements SpecificationDao {

	@Override
	public Specification get(int autoid) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Specification.class, autoid);
	}

	@Override
	public int save(Specification specification) {
		// TODO Auto-generated method stub
		return (int)getHibernateTemplate().save(specification);
	}

	@Override
	public void update(Specification specification) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(specification);
	}

	@Override
	public void delete(Specification specification) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(specification);
	}

	@Override
	public void delete(int autoid) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(autoid));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Specification> findAll() {
		// TODO Auto-generated method stub
		return (List<Specification>)getHibernateTemplate().find("from Specification");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Specification> findById(int id) {
		// TODO Auto-generated method stub
		return (List<Specification>)getHibernateTemplate().find("from Specification where id=?",id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Specification> findMaxId() {
		// TODO Auto-generated method stub
		return (List<Specification>)getHibernateTemplate().find("from Specification where id=(select max(id) from Specification)");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Specification> findByProType(ProductType producttype) {
		// TODO Auto-generated method stub
		return (List<Specification>)getHibernateTemplate().find("from Specification where id=?",producttype.getSpecification().getId());
	}

}
