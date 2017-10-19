package com.kesheng.QRMaker.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.kesheng.QRMaker.dao.*;
import com.kesheng.QRMaker.domain.Company;

public class CompanyDaoHibernate extends HibernateDaoSupport implements CompanyDao {
	public Company get(int autoid){
		return getHibernateTemplate().get(Company.class, autoid);
	}
	
	public int save(Company company){
		return (int) getHibernateTemplate().save(company);
	}
	
	public void update(Company company){
		getHibernateTemplate().update(company);
	}
	
	public void delete(Company company){
		getHibernateTemplate().delete(company);
	}
	
	public void delete(int autoid){
		getHibernateTemplate().delete(get(autoid));
	}
	
	@SuppressWarnings("unchecked")
	public List<Company> findAll(){
		return (List<Company>)getHibernateTemplate().find("from Company");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Company> findById(int id) {
		// TODO Auto-generated method stub
		return (List<Company>)getHibernateTemplate().find("from Company where id=?",id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> findByAdmin(String admin) {
		// TODO Auto-generated method stub
		return (List<Company>)getHibernateTemplate().find("from Company where admin=?",admin);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> findMaxId() {
		// TODO Auto-generated method stub
		return (List<Company>)getHibernateTemplate().find("from Company where id=(select max(id) from Company)");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> findByResnum(String resnum) {
		// TODO Auto-generated method stub
		return (List<Company>)getHibernateTemplate().find("from Company where resnum=?",resnum);
	}

}
