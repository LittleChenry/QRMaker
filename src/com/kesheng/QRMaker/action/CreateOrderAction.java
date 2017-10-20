package com.kesheng.QRMaker.action;

import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.zxing.EncodeHintType;
import com.kesheng.QRMaker.domain.*;
import com.kesheng.QRMaker.service.impl.UserImpl;
import com.kesheng.QRMaker.util.CreatePictures;
import com.kesheng.QRMaker.util.FileToZip;
import com.kesheng.QRMaker.util.PropertiesUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class CreateOrderAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String pesticideid;
	private String typeid;
	private String typetype;
	private String typelife;
	private String specification;
	private String specificationid;
	private String piciid;
	private String piciremark;
	private String picibtnum;
	private String picibxnum;
	private String queryurl;
	private String pagepath;
	private String result;
	private UserImpl user;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getPesticideid() {
		return pesticideid;
	}
	public String getTypeid() {
		return typeid;
	}
	public String getTypetype() {
		return typetype;
	}
	public String getTypelife() {
		return typelife;
	}
	public String getSpecification() {
		return specification;
	}
	public String getSpecificationid() {
		return specificationid;
	}
	public String getPiciid() {
		return piciid;
	}
	public String getPiciremark() {
		return piciremark;
	}
	public String getPicibtnum() {
		return picibtnum;
	}
	public String getPicibxnum() {
		return picibxnum;
	}
	public String getQueryurl() {
		return queryurl;
	}
	public String getPagepath() {
		return pagepath;
	}
	public String getResult() {
		return result;
	}
	public UserImpl getUser() {
		return user;
	}
	public void setPesticideid(String pesticideid) {
		this.pesticideid = pesticideid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	public void setTypetype(String typetype) {
		this.typetype = typetype;
	}
	public void setTypelife(String typelife) {
		this.typelife = typelife;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public void setSpecificationid(String specificationid) {
		this.specificationid = specificationid;
	}
	public void setPiciid(String piciid) {
		this.piciid = piciid;
	}
	public void setPiciremark(String piciremark) {
		this.piciremark = piciremark;
	}
	public void setPicibtnum(String picibtnum) {
		this.picibtnum = picibtnum;
	}
	public void setPicibxnum(String picibxnum) {
		this.picibxnum = picibxnum;
	}
	public void setQueryurl(String queryurl) {
		this.queryurl = queryurl;
	}
	public void setPagepath(String pagepath) {
		this.pagepath = pagepath;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public void setUser(UserImpl user) {
		this.user = user;
	}
	public String execute() throws Exception{
		Company company = new Company();
		Map<String,Object> sessions = ActionContext.getContext().getSession();
		for(Map.Entry<String, Object>entry : sessions.entrySet()){
			company = (Company)entry.getValue();
			break;
		}
		Date producedate = new Date();
		Pesticide pesticide = new Pesticide();
		Plan plan = new Plan();
		Specification spe = new Specification();
		ProductType producttype = new ProductType();
		FixedInfo fixedinfo = new FixedInfo();
		if(specificationid.equals("0")){
			spe.setId(user.getSpecificationDao().findMaxId().get(0).getId()+1);
			spe.setSpecification(specification);
			spe.setMaterial("暂无信息");
			spe.setMaterialno(0);
			user.getSpecificationDao().save(spe);
		}else{
			spe = user.getSpecificationDao().findById(Integer.valueOf(specificationid).intValue()).get(0);
		}
		System.out.println("typeid = "+typeid);
		if(typeid.equals("0")){
			producttype.setCompany(company);
			System.out.println(1);
			producttype.setPesticide(user.getPesticideDao().findById(Integer.valueOf(pesticideid).intValue()).get(0));
			System.out.println(2);
			producttype.setType(typetype);
			System.out.println(3);
			producttype.setLife(typelife);
			System.out.println(4);
			producttype.setSpecification(spe);
			System.out.println(5);
			producttype.setId(user.getProducttypeDao().findMaxId().get(0).getId()+1);
			System.out.println(6);
			user.getProducttypeDao().save(producttype);
		}else{
			producttype = user.getProducttypeDao().findById(Integer.valueOf(typeid).intValue()).get(0);
		}
		if(piciid.equals("0")){
			plan.setRemark(piciremark);
			plan.setCapacity(Integer.valueOf(picibxnum).intValue());
			plan.setYield(Integer.valueOf(picibtnum).intValue());
			plan.setId(user.getPlanDao().findByMaxId().get(0).getId()+1);
			plan.setProducttype(producttype);
			plan.setStatus(0);
			plan.setCompany(company);
			user.getPlanDao().save(plan);
		}else{
			plan = user.getPlanDao().findById(Integer.valueOf(piciid).intValue()).get(0);
		}
		pesticide = user.getPesticideDao().findById(Integer.valueOf(pesticideid).intValue()).get(0);
		
		if(user.getFixedinfoDao().findByCompany(company.getId()).size()>0){
			fixedinfo = user.getFixedinfoDao().findByCompany(company.getId()).get(0);
			System.out.println(fixedinfo.getAutoid());
			fixedinfo.setFixedtext(queryurl);
			fixedinfo.setPagepath(pagepath);
			user.getFixedinfoDao().update(fixedinfo);
		}else{
			fixedinfo.setFixedtext(queryurl);
			fixedinfo.setPagepath(pagepath);
			fixedinfo.setCompanyid(company.getId());
			user.getFixedinfoDao().save(fixedinfo);
		}
		
		int width = 500;
		int height = 500;
		int btnum = (int)Math.ceil(plan.getYield()*1.05);
		int bxnum = (int)Math.ceil(plan.getCapacity()*1.05);
		Font font = new Font("宋体",Font.BOLD,24);
		String idexample = "101010101010";
		String pre12id = String.valueOf(company.getId())+String.valueOf(pesticide.getId())+"10";
		String fixedtext = "请扫码或登录" + queryurl + "，输入农药编号了解具体信息";
		
		Rectangle2D idr = 
				font.getStringBounds(idexample, new FontRenderContext(AffineTransform.getScaleInstance(1, 1),false,false));
		int maxwidth = (int)Math.round(idr.getWidth());
		int numheight = (int)Math.round(idr.getHeight());

		String path = PropertiesUtil.getPropertiesUtil().readValue("savepath");
		System.out.println("path:" + path);
		
		String fileroot = path+"tempfiles"+File.separator +company.getId()+File.separator +pesticide.getId()
			+File.separator +producttype.getId()+File.separator +plan.getId();
		String filepictures = fileroot+File.separator +"qrpictures";
		String zipfileroot = fileroot+File.separator +"zipfile";
		String pdffileroot = fileroot+File.separator +"pdffile";
		String filename = company.getId()+" "+pesticide.getId() +" "+producttype.getId()+" "+plan.getId();
		long maxbx = user.getBoxDao().findMaxId().get(0).getId();

		long maxbt = user.getProductDao().findMaxId().get(0).getId();

		CreatePictures cp = new CreatePictures(maxbt, maxbx, width, height, fixedtext, pagepath, font,
				filepictures, btnum, bxnum,pre12id);
		BufferedImage fixedtextimg = cp.fixedtextImg(maxwidth, numheight);
		
		HashMap<EncodeHintType, String> hints = new HashMap<EncodeHintType, String>();
		
        cp.QRPicture(fixedtextimg, numheight,hints);
        File file = new File(pdffileroot);
    	if(!file.exists()){
    		file.mkdirs();
        }
        cp.ImgToPDF(filepictures+ File.separator +"product", pdffileroot+ File.separator +"product "+filename+".pdf");
        cp.ImgToPDF(filepictures+ File.separator +"box", pdffileroot+ File.separator +"box "+filename+".pdf");
        
        file = new File(zipfileroot+File.separator);
    	if(!file.exists()){
    		file.mkdirs();
        }
        FileToZip.createZip(filepictures, zipfileroot+File.separator+"pic"+".zip");
        FileToZip.createZip(pdffileroot, zipfileroot+File.separator+"pdf"+".zip");
        FileToZip.createZip(zipfileroot, fileroot+File.separator+"QRCODE_PDF&PIC"+".zip");
        
        plan.setStatus(1);
        user.getPlanDao().update(plan);
        
        for(int i = 1;i<=bxnum;i++){
        	System.out.println(maxbx+i);
        	Box box = new Box();
        	box.setCapacity(plan.getYield()/plan.getCapacity()+"瓶/箱");
        	box.setId(maxbx+i);
        	box.setPlanid(plan.getId());
        	box.setCompanyid(company.getId());
        	user.getBoxDao().save(box);
        }
        for(int i = 1;i<=btnum;i++){
        	Product product = new Product();
        	product.setId(maxbt+i);
        	product.setProducttypeid(producttype.getId());
        	product.setPdcdate(producedate);
        	product.setPlanid(plan.getId());
        	product.setCompanyid(company.getId());
        	product.setFlag(1);
        	System.out.println(maxbt+i);
        	user.getProductDao().save(product);
        }
        
        Map<String,String> map = new HashMap();
        map.put("info", "正在生成，请在历史订单中查询！");
        JSONObject obj = JSONObject.fromObject(map);
		result = obj.toString();
		
		return SUCCESS;
	}
}
