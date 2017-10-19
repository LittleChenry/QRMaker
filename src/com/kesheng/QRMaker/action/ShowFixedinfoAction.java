package com.kesheng.QRMaker.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kesheng.QRMaker.domain.Company;
import com.kesheng.QRMaker.domain.FixedInfo;
import com.kesheng.QRMaker.service.impl.UserImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class ShowFixedinfoAction extends ActionSupport {
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

	public String getResult() {
		return result;
	}

	public void setUser(UserImpl user) {
		this.user = user;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String execute() throws Exception{
		Map<String,Object> sessions = ActionContext.getContext().getSession();
		for(Map.Entry<String, Object>entry : sessions.entrySet()){
			company = (Company)entry.getValue();
			break;
		}
		List<FixedInfo> fixedInfo = user.getFixedinfoDao().findByCompany(company.getId());
		Map<String,String> map = new HashMap();
		if(fixedInfo.size()>0){
			map.put("fixedtext", fixedInfo.get(0).getFixedtext());
			map.put("pagepath", fixedInfo.get(0).getPagepath());
		}else{
			map.put("fixedtext", "");
			map.put("pagepath", "");
		}
		
		JSONObject obj = JSONObject.fromObject(map);
		result = obj.toString();
		System.out.println(result);
		
		return SUCCESS;
	}
}
