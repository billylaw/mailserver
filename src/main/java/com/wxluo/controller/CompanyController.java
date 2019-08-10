package com.wxluo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wxluo.mybatis.entity.Company;
import com.wxluo.protocol.ResponseData;
import com.wxluo.service.CompanyService;
import com.wxluo.utils.LogTool;

@RestController
@RequestMapping(value="company")
public class CompanyController {
	
	
	@Autowired
	private CompanyService companyService;
	
	/**
	 * 新增公司
	 * @param company
	 * @return
	 */
	@PostMapping("/add")
	public ResponseData addCompany(@RequestBody Company company){
		ResponseData responseData = new ResponseData(); 
		try {
			if(companyService.addCompany(company)){
				responseData.setResponseCode(0); 
			}else{
				responseData.setResponseCode(1);
				responseData.setResponseStr("新增公司失败!");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			LogTool.logInfo("添加公司出错！"+ e.toString());
			responseData.setResponseCode(2);
			responseData.setResponseStr("新增公司异常！");
		}
		return responseData;		
	}
	
	@PostMapping("/update")
	public ResponseData upadateCompany(@RequestBody Company company){
		ResponseData responseData = new ResponseData(); 
		try {
			if(companyService.updateCompany(company)){
				responseData.setResponseCode(0); 
			}else{
				responseData.setResponseCode(1);
				responseData.setResponseStr("更新公司失败!");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			LogTool.logInfo("更新公司信息出错！"+ e.toString());
			responseData.setResponseCode(2);
			responseData.setResponseStr("更新公司信息异常！");
		}
		return responseData;		
	}
	
	
	/**
	 * 根据名字获得公司信息
	 * @param companyName
	 * @return
	 */
	@PostMapping("/getCompany")
	public ResponseData getCompany(@RequestBody String companyName){
		ResponseData responseData = new ResponseData(); 
		try {
			if(companyName == null|| companyName.trim() == ""){
				responseData.setResponseCode(1);
				responseData.setResponseStr("传参为空!");
			}else{
				responseData.setData(companyService.getCompany(companyName));
			}			
		} catch (Exception e) {
			// TODO: handle exception
			LogTool.logInfo("获取公司信息出错！"+ e.toString());
			responseData.setResponseCode(2);
			responseData.setResponseStr("获取公司信息异常！");
		}
		return responseData;			
	}
	
	
	
	
}
