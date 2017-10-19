package com.kesheng.QRMaker.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kesheng.QRMaker.domain.Pesticide;
import com.kesheng.QRMaker.service.impl.UserImpl;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;

public class ShowInfoAction extends ActionSupport {
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
		List<Pesticide> pesticides = user.getPesticideDao().findAll();
		int size = pesticides.size();
		Map<String,String> map[] = new Map[size+1];
		
		for(int i=0;i<size;i++){
			Pesticide pesticide = pesticides.get(i);
			map[i] = new HashMap();
			map[i].put("name", pesticide.getName());
			map[i].put("id", String.valueOf(pesticide.getId()));
			map[i].put("num", pesticide.getNum());
			map[i].put("described", pesticide.getDescribed());
			map[i].put("solution", pesticide.getSolution());
			map[i].put("usage", pesticide.getUsage());
			map[i].put("toxic", pesticide.getToxic());
			map[i].put("environment", String.valueOf(pesticide.getEnvironment()));
		}
		map[size] = new HashMap();
		map[size].put("name", "none");
		map[size].put("id", "none");
		map[size].put("num", "none");
		map[size].put("described", "none");
		map[size].put("solution", "none");
		map[size].put("usage", "none");
		map[size].put("toxic", "none");
		map[size].put("environment", "none");
		
		JSONArray obj = JSONArray.fromObject(map);
		result = obj.toString();
		System.out.println(result);
		
		return SUCCESS;
	}
}
