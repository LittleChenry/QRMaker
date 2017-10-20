package com.kesheng.QRMaker.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.kesheng.QRMaker.dao.BoxDao;
import com.kesheng.QRMaker.domain.Box;

public class BoxDaoHibernate extends HibernateDaoSupport implements BoxDao {

	@Override
	public Box get(long autoid) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Box.class, autoid);
	}

	@Override
	public long save(Box box) {
		// TODO Auto-generated method stub
		return (Integer)getHibernateTemplate().save(box);
	}

	@Override
	public void update(Box box) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(box);
	}

	@Override
	public void delete(Box box) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(box);
	}

	@Override
	public void delete(long autoid) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(autoid));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Box> findAll() {
		// TODO Auto-generated method stub
		return (List<Box>)getHibernateTemplate().find("from Box");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Box> findMaxId() {
		// TODO Auto-generated method stub
		return (List<Box>)getHibernateTemplate().find("from Box where id=(select max(id) from Box)");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Box> findById(long id) {
		// TODO Auto-generated method stub
		return (List<Box>)getHibernateTemplate().find("from Box where id=?",id);
	}

}
