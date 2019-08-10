package com.wxluo.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.wxluo.cache.CompanyCacheManager;
import com.wxluo.cache.UserCacheManager;
import com.wxluo.mybatis.dao.CompanyMapper;
import com.wxluo.mybatis.dao.CuserMapper;
import com.wxluo.mybatis.entity.Company;
import com.wxluo.mybatis.entity.Cuser;


/**
 * 
 * @author wxluo
 *
 */
@Service
public class UserService {
	
	@Autowired
	private CuserMapper cuserMapper;
	
	@Autowired
	private CompanyMapper companyMapper;
	
	//注册
	public boolean register(Cuser user){
		if(user == null || user.getUserName() == null){
			return false;
		}	
		
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMddHHmmssfff");		
		long time = Long.parseLong(sdFormat.toString());
				
		if(user.getCompanyName()!= null && user.getCompanyName().trim() != ""){
			//不存在公司，新增公司
			if(CompanyCacheManager.getInstance().getCompanyMap(user.getCompanyName()) == null){
				Company company = new Company();
				company.setCompanyName(user.getCompanyName());
				company.setCreateTime(time);
				company.setUpdateTime(time);				
				companyMapper.insert(company);				
			}
		}
		
		if(user.getCreateTime() == null){
			user.setCreateTime(time);
			user.setUpdateTime(time);
			user.setStatus((byte)0);
		}
		int record = cuserMapper.insert(user);
		if(record> 0){
			return true;	
		}
		else {
			return false;
		}
	}
	
	//登录
	public boolean login(Cuser user){
		if(user == null || user.getUserName() == null){
			return false;
		}else{
			//为空，再从数据库中找
			if(UserCacheManager.getInstance().getSize() == 0){
				
			}
			Cuser userTemp = UserCacheManager.getInstance().getUserMap(user.getUserName());
			if(userTemp.getPassword().equals(user.getPassword())){
				return true;
			}else{
				return false;
			}			
		}
	}
	
	//获得所有用户
	public Collection<Cuser> getUsers(){
		return UserCacheManager.getInstance().getValues();
	}
	
	//更新用户信息
	public  boolean updateUserInfo(Cuser user){
		if(user == null || user.getUserName() == null){
			return false;
		}	
		
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMddHHmmssfff");		
		long time = Long.parseLong(sdFormat.toString());
				
		if(user.getCompanyName()!= null && user.getCompanyName().trim() != ""){
			//不存在公司，新增公司
			if(CompanyCacheManager.getInstance().getCompanyMap(user.getCompanyName()) == null){
				Company company = new Company();
				company.setCompanyName(user.getCompanyName());
				company.setCreateTime(time);
				company.setUpdateTime(time);				
				companyMapper.insert(company);				
			}
		}	
		if(user.getCreateTime() == null){
			user.setCreateTime(time);
			user.setUpdateTime(time);
			user.setStatus((byte)0);
		}
		int record = cuserMapper.updateByPrimaryKey(user);
		if(record> 0){
			return true;	
		}
		else {
			return false;
		}
	}
	
	
}
