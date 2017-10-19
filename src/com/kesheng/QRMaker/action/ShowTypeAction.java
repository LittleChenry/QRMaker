package com.kesheng.QRMaker.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kesheng.QRMaker.domain.Company;
import com.kesheng.QRMaker.domain.Pesticide;
import com.kesheng.QRMaker.domain.ProductType;
import com.kesheng.QRMaker.domain.Specification;
import com.kesheng.QRMaker.service.impl.UserImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;

public class ShowTypeAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String id;
	private UserImpl user;
	private String result;
	private Company company = new Company();
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getId() {
		return id;
	}

	public UserImpl getUser() {
		return user;
	}

	public String getResult() {
		return result;
	}

	public void setId(String id) {
		this.id = id;
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

	public String execute() throws Exception {
		Map<String,Object> sessions = ActionContext.getContext().getSession();
		for(Map.Entry<String, Object>entry : sessions.entrySet()){
			company = (Company)entry.getValue();
			break;
		}
		System.out.println(id+" "+company.getId());
		List<ProductType> producttypes;
		if(id.equals("0")){
			producttypes = user.getProducttypeDao().findByCompany(company.getId());
		}else{
			producttypes = user.getProducttypeDao().findByPesticideAndCompany(Integer.valueOf(id).intValue(),company.getId());
			
		}
		int size = producttypes.size();
		Map<String,String> map[] = new Map[size+1];
		for(int i=0;i<size;i++){
			ProductType producttype = producttypes.get(i);
			map[i] = new HashMap();
			map[i].put("id", String.valueOf(producttype.getId()));
			map[i].put("type", producttype.getType());
			map[i].put("specificationid", String.valueOf(producttype.getSpecification().getId()));
			map[i].put("specification", producttype.getSpecification().getSpecification());
			map[i].put("life", producttype.getLife());
			map[i].put("pesticide", producttype.getPesticide().getName());
		}
		map[size] = new HashMap();
		map[size].put("id", "none");
		map[size].put("type", "none");
		map[size].put("specificationid", "none");
		map[size].put("specification", "none");
		map[size].put("life", "none");
		map[size].put("pesticide", "none");
		
		JSONArray obj = JSONArray.fromObject(map);
		result = obj.toString();
		System.out.println(result);
		return SUCCESS;
	}
	
	
}
