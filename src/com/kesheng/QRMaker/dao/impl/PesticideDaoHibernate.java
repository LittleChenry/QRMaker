package com.kesheng.QRMaker.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.kesheng.QRMaker.dao.PesticideDao;
import com.kesheng.QRMaker.domain.Pesticide;

public class PesticideDaoHibernate extends HibernateDaoSupport implements PesticideDao {

	@Override
	public Pesticide get(int autoid) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Pesticide.class, autoid);
	}

	@Override
	public int save(Pesticide pesticide) {
		// TODO Auto-generated method stub
		return (int)getHibernateTemplate().save(pesticide);
	}

	@Override
	public void update(Pesticide pesticide) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(pesticide);
	}

	@Override
	public void delete(Pesticide pesticide) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(pesticide);
	}

	@Override
	public void delete(int autoid) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(autoid));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pesticide> findAll() {
		// TODO Auto-generated method stub
		return (List<Pesticide>)getHibernateTemplate().find("from Pesticide");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pesticide> findById(int id) {
		// TODO Auto-generated method stub
		return (List<Pesticide>)getHibernateTemplate().find("from Pesticide where ID=?",id);
	}

}
