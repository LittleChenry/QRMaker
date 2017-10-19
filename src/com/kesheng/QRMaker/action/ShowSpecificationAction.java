package com.kesheng.QRMaker.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kesheng.QRMaker.domain.Specification;
import com.kesheng.QRMaker.service.impl.UserImpl;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;

public class ShowSpecificationAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
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

	public String execute() throws Exception{
		List<Specification> specifications = user.getSpecificationDao().findAll();
		int size = specifications.size();
		Map<String,String> map[] = new Map[size+1];
		
		for(int i=0;i<size;i++){
			Specification specification = specifications.get(i);
			map[i] = new HashMap();
			map[i].put("specification", specification.getSpecification());
			map[i].put("id", String.valueOf(specification.getId()));
		}
		map[size] = new HashMap();
		map[size].put("specification", "none");
		map[size].put("id", "none");
		
		JSONArray obj = JSONArray.fromObject(map);
		result = obj.toString();
		System.out.println(result);
		
		return SUCCESS;
	}
}
