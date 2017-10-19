package com.kesheng.QRMaker.action;

import java.util.HashMap;
import java.util.Map;

import com.kesheng.QRMaker.domain.Company;
import com.kesheng.QRMaker.service.impl.UserImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class ChangePasswordAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String oldpassword;
	private String newpassword;
	private String newpassword2;
	private Company company = new Company();
	private UserImpl user;
	private String result;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getOldpassword() {
		return oldpassword;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public String getNewpassword2() {
		return newpassword2;
	}
	public void setNewpassword2(String newpassword2) {
		this.newpassword2 = newpassword2;
	}
	public UserImpl getUser() {
		return user;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public Company getCompany() {
		return company;
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
		
		if(company.getPassword().equals(oldpassword)){
			map.put("message", "1");
			Company updatecom = user.getCompanyDao().findById(company.getId()).get(0);
			updatecom.setPassword(newpassword);
			user.getCompanyDao().update(updatecom);

			ActionContext.getContext().getSession().clear();
			ActionContext.getContext().getSession().put("company", updatecom);
		}
		else{
			map.put("message", "0");
		}
		
		JSONObject obj = JSONObject.fromObject(map);
		result = obj.toString();
		return SUCCESS;
	}
	
}
