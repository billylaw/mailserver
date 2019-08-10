package com.wxluo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wxluo.mybatis.entity.Cmail;
import com.wxluo.protocol.ResponseData;
import com.wxluo.service.MailService;
import com.wxluo.utils.LogTool;


/**
 * @author wxluo
 *
 */
@RestController
@RequestMapping(value="mail")
public class MailController {
	
	@Autowired
	private MailService mailService;
	
	
	/**
	 * 新增邮件
	 * @param mail
	 * @return
	 */
	@PostMapping("/add")
	public ResponseData addMail(Cmail mail){
		ResponseData responseData = new ResponseData();
		try {
			if(mailService.addMail(mail)){
				responseData.setResponseCode(0);
			}else{
				responseData.setResponseCode(1);
				responseData.setResponseStr("新增邮件信息失败!");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			responseData.setResponseCode(2);
			responseData.setResponseStr("新增邮件信息出现异常");
			LogTool.logError("新增邮件信息出现异常；" + e.toString());
		}
		return responseData;
	}
	
	
	/**
	 * 修改邮件
	 * @param mail
	 * @return
	 */
	@PostMapping("/update")
	public ResponseData updateMail(Cmail mail){
		ResponseData responseData = new ResponseData();
		try {
			if(mailService.updateMail(mail)){
				responseData.setResponseCode(0);
			}else{
				responseData.setResponseCode(1);
				responseData.setResponseStr("修改邮件信息失败!");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			responseData.setResponseCode(2);
			responseData.setResponseStr("修改邮件信息出现异常");
			LogTool.logError("修改邮件信息出现异常；" + e.toString());
		}
		return responseData;
	}
	
	
	/**
	 * 获得所有邮件信息
	 * @return
	 */
	@PostMapping("/getall")
	public ResponseData getAllMails(){
		ResponseData responseData = new ResponseData();
		try {
			responseData.setResponseCode(0);
			responseData.setData(mailService.getMails());
			
		} catch (Exception e) {
			// TODO: handle exception
			responseData.setResponseCode(2);
			responseData.setResponseStr("获得所有邮件信息异常！");
			LogTool.logError("获得邮件信息出现异常；" + e.toString());
		}
		return responseData;
	}
	
}
