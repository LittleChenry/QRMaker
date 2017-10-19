package com.kesheng.QRMaker.action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.*;

import net.sf.json.JSONObject;



public class TestAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String content;
	private String username;
	private String result;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getContent() {
		return content;
	}

	public String getUsername() {
		return username;
	}

	public String getResult() {
		return result;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String execute() throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("newusername", "new"+username);
		map.put("newcontent", "new"+content);

		JSONObject obj = JSONObject.fromObject(map);
		result = obj.toString();
		return SUCCESS;
	}
}
