package com.kesheng.QRMaker.action;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.kesheng.QRMaker.domain.Company;
import com.kesheng.QRMaker.service.impl.UserImpl;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class RegisterAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Company company = new Company();
	private UserImpl user;
	private String id;
	private String name;
	private String admin;
	private String code;
	private String password;
	private String email;
	private String result;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Company getCompany() {
		return company;
	}

	public UserImpl getUser() {
		return user;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAdmin() {
		return admin;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public void setUser(UserImpl user) {
		this.user = user;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String execute() throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		System.out.println("1");
		if(user.getCompanyDao().findByResnum(id).size() > 0){
			map.put("situation", "1");
		}else if(user.getCompanyDao().findByAdmin(admin).size() > 0){
			map.put("situation", "2");
		}else{
			map.put("situation", "0");
			
			company.setAdmin(admin);
			company.setName(name);
			company.setId(Integer.valueOf(id).intValue());
			company.setResnum(code);
			company.setPassword(password);
			company.setEmail(email);
			company.setStatus("0");
			company.setRestime(Calendar.getInstance());
			
			user.getCompanyDao().save(company);
		}

		JSONObject obj = JSONObject.fromObject(map);
		result = obj.toString();
		return SUCCESS;
	}
}
