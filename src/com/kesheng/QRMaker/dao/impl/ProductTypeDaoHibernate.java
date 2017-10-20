package com.kesheng.QRMaker.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.kesheng.QRMaker.dao.ProductTypeDao;
import com.kesheng.QRMaker.domain.ProductType;

public class ProductTypeDaoHibernate extends HibernateDaoSupport implements ProductTypeDao {

	@Override
	public ProductType get(int autoid) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(ProductType.class, autoid);
	}

	@Override
	public int save(ProductType producttype) {
		// TODO Auto-generated method stub
		return (Integer) getHibernateTemplate().save(producttype);
	}

	@Override
	public void update(ProductType producttype) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(producttype);
	}

	@Override
	public void delete(ProductType producttype) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(producttype);
	}

	@Override
	public void delete(int autoid) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(autoid));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductType> findAll() {
		// TODO Auto-generated method stub
		return (List<ProductType>)getHibernateTemplate().find("from ProductType");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductType> findById(int id) {
		// TODO Auto-generated method stub
		return (List<ProductType>)getHibernateTemplate().find("from ProductType where id=?",id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductType> findMaxId() {
		// TODO Auto-generated method stub
		return (List<ProductType>)getHibernateTemplate().find("from ProductType where id=(select max(id) from ProductType)");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductType> findByCompany(int company_id) {
		// TODO Auto-generated method stub
		return (List<ProductType>)getHibernateTemplate().find("from ProductType where company.id=?",company_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductType> findByPesticideAndCompany(int pesticide_id,int company_id) {
		// TODO Auto-generated method stub
		return (List<ProductType>)getHibernateTemplate().find("from ProductType where pesticide.id=? and company.id=?",pesticide_id,company_id);
	}

}
