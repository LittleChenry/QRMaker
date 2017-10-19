package com.kesheng.QRMaker.service.impl;

import com.kesheng.QRMaker.dao.*;
import com.kesheng.QRMaker.service.*;

public class UserImpl implements User{
	//private static Company company;
	private BoxDao boxDao;
	private PesticideDao pesticideDao;
	private SpecificationDao specificationDao;
	private CompanyDao companyDao;
	private ProductDao productDao;
	private ProductTypeDao producttypeDao;
	private PlanDao planDao;
	private FixedInfoDao fixedinfoDao;

	public BoxDao getBoxDao() {
		return boxDao;
	}

	public PesticideDao getPesticideDao() {
		return pesticideDao;
	}

	public SpecificationDao getSpecificationDao() {
		return specificationDao;
	}

	public CompanyDao getCompanyDao() {
		return companyDao;
	}

	public ProductDao getProductDao() {
		return productDao;
	}

	public ProductTypeDao getProducttypeDao() {
		return producttypeDao;
	}

	public PlanDao getPlanDao() {
		return planDao;
	}

	public void setBoxDao(BoxDao boxDao) {
		this.boxDao = boxDao;
	}

	public void setPesticideDao(PesticideDao pesticideDao) {
		this.pesticideDao = pesticideDao;
	}

	public void setSpecificationDao(SpecificationDao specificationDao) {
		this.specificationDao = specificationDao;
	}

	public void setCompanyDao(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public void setProducttypeDao(ProductTypeDao producttypeDao) {
		this.producttypeDao = producttypeDao;
	}

	public void setPlanDao(PlanDao planDao) {
		this.planDao = planDao;
	}

	public FixedInfoDao getFixedinfoDao() {
		return fixedinfoDao;
	}

	public void setFixedinfoDao(FixedInfoDao fixedinfoDao) {
		this.fixedinfoDao = fixedinfoDao;
	}

}
