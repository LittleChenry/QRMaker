package com.kesheng.QRMaker.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtil {

	private String configPath = null;

	private Properties props = null;

	private static PropertiesUtil p = null;

	private PropertiesUtil() throws IOException {
		InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream("../config/filepath.properties");
		props = new Properties();
		props.load(in);
		// 关闭资源
		in.close();
	}

	public static PropertiesUtil getPropertiesUtil() throws IOException {
		if (p == null) {
			return new PropertiesUtil();
		} else {
			return p;
		}

	}

	public String readValue(String key) throws IOException {
		return props.getProperty(key);
	}

	public Map<String, String> readAllProperties() throws FileNotFoundException, IOException {
		// 保存所有的键值
		Map<String, String> map = new HashMap<String, String>();
		Enumeration en = props.propertyNames();
		while (en.hasMoreElements()) {
			String key = (String) en.nextElement();
			String Property = props.getProperty(key);
			map.put(key, Property);
		}
		return map;
	}


	public void setValue(String key, String value) throws IOException {
		Properties prop = new Properties();
		InputStream fis = new FileInputStream(this.configPath);
		prop.load(fis);
		OutputStream fos = new FileOutputStream(this.configPath);
		prop.setProperty(key, value);
		prop.store(fos, "last update");
		// 关闭文件
		fis.close();
		fos.close();
	}

	public static void main(String[] args) {
		PropertiesUtil p;
		try {
			p = new PropertiesUtil();
			System.out.println(p.readValue("appid"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
