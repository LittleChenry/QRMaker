package com.kesheng.QRMaker.action;

import java.util.HashMap;
import java.util.Map;

import com.kesheng.QRMaker.domain.Company;
import com.kesheng.QRMaker.service.impl.UserImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class ShowUserinfoAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Company company = new Company();
	private UserImpl user;
	private String result;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public UserImpl getUser() {
		return user;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public String getResult() {
		return result;
	}
	public void setUser(UserImpl user) {
		this.user = user;
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
		map.put("id", String.valueOf(company.getId()));
		map.put("name", company.getName());
		map.put("code", company.getResnum());
		map.put("admin", company.getAdmin());
		map.put("email", company.getEmail());
		
		JSONObject obj = JSONObject.fromObject(map);
		result = obj.toString();
		return SUCCESS;
	}

}
