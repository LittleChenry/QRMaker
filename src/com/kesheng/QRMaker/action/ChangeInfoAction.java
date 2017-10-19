package com.kesheng.QRMaker.action;

import java.util.HashMap;
import java.util.Map;

import com.kesheng.QRMaker.domain.Company;
import com.kesheng.QRMaker.service.impl.UserImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class ChangeInfoAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String admin;
	private String email;
	private Company company = new Company();
	private UserImpl user;
	private String result;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getAdmin() {
		return admin;
	}
	public String getEmail() {
		return email;
	}
	public Company getCompany() {
		return company;
	}
	public UserImpl getUser() {
		return user;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setCompany(Company company) {
		this.company = company;
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
	
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> sessions = ActionContext.getContext().getSession();
		for(Map.Entry<String, Object>entry : sessions.entrySet()){
			company = (Company)entry.getValue();
			break;
		}
		
		Map<String,String> map = new HashMap();
		if(!admin.equals(company.getAdmin())){
			if(user.getCompanyDao().findByAdmin(admin).size()!=0){
				map.put("message", "1");
				JSONObject obj = JSONObject.fromObject(map);
				result = obj.toString();
				return SUCCESS;
			}
		}
		map.put("message", "0");
		Company updatecom = user.getCompanyDao().findById(company.getId()).get(0);
		updatecom.setAdmin(admin);
		updatecom.setEmail(email);
		map.put("admin", admin);
		map.put("email", email);
		user.getCompanyDao().update(updatecom);
		ActionContext.getContext().getSession().clear();
		ActionContext.getContext().getSession().put("company", updatecom);
		
		JSONObject obj = JSONObject.fromObject(map);
		result = obj.toString();
		return SUCCESS;
	}
	
}
