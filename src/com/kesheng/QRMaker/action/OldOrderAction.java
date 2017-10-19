package com.kesheng.QRMaker.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kesheng.QRMaker.domain.Company;
import com.kesheng.QRMaker.domain.Plan;
import com.kesheng.QRMaker.service.impl.UserImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;

public class OldOrderAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Company company = new Company();
	private String result;
	private UserImpl user;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Company getCompany() {
		return company;
	}

	public String getResult() {
		return result;
	}

	public UserImpl getUser() {
		return user;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setUser(UserImpl user) {
		this.user = user;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String execute() throws Exception{
		Map<String,Object> sessions = ActionContext.getContext().getSession();
		for(Map.Entry<String, Object>entry : sessions.entrySet()){
			company = (Company)entry.getValue();
			break;
		}
		List<Plan> plans = user.getPlanDao().findByCompany(company.getId());
		int size = plans.size();
		Map<String,String> map[] = new Map[size+1];
		for(int i=0;i<size;i++){
			Plan plan = plans.get(i);
			map[i] = new HashMap();
			map[i].put("companyid", String.valueOf(company.getId()));
			map[i].put("pesticideid", String.valueOf(plan.getProducttype().getPesticide().getId()));
			map[i].put("typeid", String.valueOf(plan.getProducttype().getId()));
			map[i].put("planid", String.valueOf(plan.getId()));
			map[i].put("status", String.valueOf(plan.getStatus()));
			map[i].put("name", plan.getProducttype().getPesticide().getName());
			map[i].put("type", plan.getProducttype().getType());
			map[i].put("specification", plan.getProducttype().getSpecification().getSpecification());
			map[i].put("remark", plan.getRemark());
			map[i].put("btnum", String.valueOf(plan.getYield()));
			map[i].put("bxnum", String.valueOf(plan.getCapacity()));
		}
		map[size] = new HashMap();
		map[size].put("companyid", "none");
		map[size].put("pesticideid", "none");
		map[size].put("typeid", "none");
		map[size].put("planid", "none");
		map[size].put("status", "none");
		map[size].put("name", "none");
		map[size].put("type", "none");
		map[size].put("specification", "none");
		map[size].put("remark", "none");
		map[size].put("btnum", "none");
		map[size].put("bxnum", "none");
		
		JSONArray obj = JSONArray.fromObject(map);
		result = obj.toString();
		System.out.println(result);
		return SUCCESS;
	}
}
