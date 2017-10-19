package com.kesheng.QRMaker.action;

import java.util.HashMap;
import java.util.Map;

import com.kesheng.QRMaker.domain.Company;
import com.kesheng.QRMaker.service.impl.UserImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Company company = new Company();
	private String admin;
	private String password;
	private UserImpl user;
	private String result;


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Company getCompany() {
		return company;
	}
	public String getAdmin() {
		return admin;
	}
	public String getPassword() {
		return password;
	}
	public UserImpl getUser() {
		return user;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUser(UserImpl user) {
		this.user = user;
	}

	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String execute() throws Exception{
		int size = user.getCompanyDao().findByAdmin(admin).size();
		Map<String,String> map = new HashMap();
		System.out.println(1);
		if(size==0){
			map.put("message", "4");
		}else if(user.getCompanyDao().findByAdmin(admin).get(0).getPassword().equals(password)){
			String status = user.getCompanyDao().findByAdmin(admin).get(0).getStatus();
			if(status.equals("1")){
				company=user.getCompanyDao().findByAdmin(admin).get(0);
				ActionContext.getContext().getSession().put("company", company);
			}
			map.put("message", status);
		}else{
			map.put("message", "3");
		}
		
		JSONObject obj = JSONObject.fromObject(map);
		result = obj.toString();
		return SUCCESS;
	}
}
