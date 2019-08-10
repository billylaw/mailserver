package com.wxluo.cache;

import java.util.Collection;
import java.util.Set;

import com.wxluo.mybatis.entity.Company;
import com.wxluo.mybatis.entity.Cuser;


/**
 * 公司缓存
 * @author wxluo
 *
 */
public class CompanyCacheManager {
	
	private static CompanyCacheManager instanceManager =  new CompanyCacheManager();	
	private static SyncMap<String, Company> companyMap = new SyncMap<String, Company>();
	
	
	/**
	 * 单例模式
	 * @return
	 */
	public synchronized static CompanyCacheManager getInstance(){
		if(instanceManager == null)
			return new CompanyCacheManager();
		return instanceManager;
	}
	
	public void setCompanyMap(Company company){
		companyMap.put(company.getCompanyName(), company);
	}
	
	public Company getCompanyMap(String companyName){
		return companyMap.get(companyName);
	}
	
	public Set<String> getKeys(){
		if( companyMap.keySet() == null || companyMap.size() == 0)
			return null ;
		return (Set<String>) companyMap.keySet();
	}
	
	public Collection<Company> getValues(){
		if(companyMap.values() == null || companyMap.size() == 0){
			return null;
		}
		else {
			return companyMap.values();
		}
	}
	
	public int getSize(){
		return companyMap.size();
	}
}
