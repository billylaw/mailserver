package com.wxluo.service;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import com.wxluo.cache.CompanyCacheManager;
import com.wxluo.mybatis.dao.CompanyMapper;
import com.wxluo.mybatis.entity.Company;

/**
 * @author wxluo
 *
 */
@Service
public class CompanyService {
	
	@Autowired
	private CompanyMapper companyMapper;
		
	/**
	 * 新增公司
	 * @param company
	 * @return
	 */
	public boolean addCompany(Company company){
		
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMddHHmmssfff");		
		long time = Long.parseLong(sdFormat.toString());
		
		company.setCreateTime(time);
		company.setUpdateTime(time);
		company.setStatus((byte)0);
		
		if(companyMapper.insert(company) > 0){
			return true;
		}else {
			return false;
		}
	}
	
	
	/**
	 * 更新公司
	 * @param company
	 * @return
	 */
	public boolean updateCompany(Company company){
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMddHHmmssfff");		
		long time = Long.parseLong(sdFormat.toString());
		
		company.setCreateTime(time);
		company.setUpdateTime(time);
		company.setStatus((byte)0);			
		if(companyMapper.updateByPrimaryKey(company) > 0){
			return true;
		}else{
			return false;
		}		
	}
	
	/**
	 * 获得某个公司名字
	 * @param companyName
	 * @return
	 */
	public Company getCompany(String companyName){
		if(companyName == null || companyName == ""){
			return null;
		}
		//为空，重新加载一遍数据库
		if(CompanyCacheManager.getInstance().getSize() == 0){
			
		}		
		return CompanyCacheManager.getInstance().getCompanyMap(companyName);
	}
	
	
	/**
	 * 所有公司
	 * @return
	 */
	public Collection<Company> getCompanies(){
		return CompanyCacheManager.getInstance().getValues();
	}
			
}
