package com.kesheng.QRMaker.action;

import java.util.HashMap;
import java.util.Map;

import com.kesheng.QRMaker.domain.Company;
import com.kesheng.QRMaker.domain.Plan;
import com.kesheng.QRMaker.service.impl.UserImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class DownloadedAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String planid;
	private Company company = new Company();
	private UserImpl user;
	private String result;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPlanid() {
		return planid;
	}

	public Company getCompany() {
		return company;
	}

	public UserImpl getUser() {
		return user;
	}

	public String getResult() {
		return result;
	}

	public void setPlanid(String planid) {
		this.planid = planid;
	}

	public void setCompany(Company company) {
		this.company = company;
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
		
		Plan plan = user.getPlanDao().findById(Integer.valueOf(planid).intValue()).get(0);
		plan.setStatus(2);
		user.getPlanDao().update(plan);
		
		Map<String,String> map = new HashMap();
		map.put("message", "0");
		
		JSONObject obj = JSONObject.fromObject(map);
		result = obj.toString();
		System.out.println(result);
		return SUCCESS;
	}
	
}
