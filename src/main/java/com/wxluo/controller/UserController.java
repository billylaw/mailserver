package com.wxluo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wxluo.cache.UserCacheManager;
import com.wxluo.mybatis.entity.Cuser;
import com.wxluo.protocol.ResponseData;
import com.wxluo.service.UserService;
import com.wxluo.utils.LogTool;

/**
 * @author wxluo
 *
 */
@RestController
@RequestMapping(value="user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 注册
	 * @param User
	 * @return
	 */
	@PostMapping("/register")
	public ResponseData register(@RequestBody Cuser user){			
		ResponseData responseData = new ResponseData();
		try {
			if(userService.register(user)){
				responseData.setResponseCode(0);
			}else{
				responseData.setResponseCode(1);
				responseData.setResponseStr("注册失败!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			LogTool.logError("注册失败:" +e.toString());
			responseData.setResponseCode(2);
			responseData.setResponseStr("注册异常!");
		}
		return responseData;
	}
	
	
	//登录
	@PostMapping("/login")
	public ResponseData login(@RequestBody Cuser user){	
		ResponseData responseData = new ResponseData();
		try {
			if(userService.login(user)){
				responseData.setResponseCode(0);
			}else{
				responseData.setResponseCode(1);
				responseData.setResponseStr("登录名或密码错误!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			LogTool.logError("登录失败:" +e.toString());
			responseData.setResponseCode(2);
			responseData.setResponseStr("登录异常!");
		}
		return responseData;
	}
	
	//获取某个用户信息
	@PostMapping("/getone")
	public ResponseData getUserInfo(@RequestBody Cuser user){
		ResponseData responseData = new ResponseData();
		try {
			responseData.setResponseCode(0);
			responseData.setData(userService.getUsers()); 
		} catch (Exception e) {
			// TODO: handle exception
			responseData.setResponseCode(1);
			responseData.setResponseStr("获取失败!");
		}
		return responseData;
	}
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	@PostMapping("/update")
	public ResponseData updateUserInfo(@RequestBody Cuser user){
		ResponseData responseData = new ResponseData();
		try {
			if(userService.updateUserInfo(user)){
				responseData.setResponseCode(0);
			}else{
				responseData.setResponseCode(1);
				responseData.setResponseStr("更新用户信息失败!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			LogTool.logError("更新用户异常:" +e.toString());
			responseData.setResponseCode(2);
			responseData.setResponseStr("更新用户信息异常!");
		}
		return responseData;
	}
	
	
}
