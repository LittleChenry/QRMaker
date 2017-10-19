package com.kesheng.QRMaker.action;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.opensymphony.xwork2.*;

import net.sf.json.JSONObject;



public class PathAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private String result;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String execute() throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		map.put("message", "OK!");
		System.out.println(1);
		//ActionContext ctx = ActionContext.getContext();       
		//HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		File file=new File("");
		
		String path = file.getAbsolutePath();
		//String home = path.replace("Path.action", "");
		System.out.println(path);
		
		JSONObject obj = JSONObject.fromObject(map);
		result = obj.toString();
		return SUCCESS;
	}
}
