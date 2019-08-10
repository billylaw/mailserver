package com.wxluo.cache;

import java.util.Collection;
import java.util.Set;

import com.wxluo.mybatis.entity.Cmail;
import com.wxluo.mybatis.entity.Company;

public class MailCacheManager {
	private static MailCacheManager instanceManager =  new MailCacheManager();	
	private static SyncMap<String, Cmail> mailMap = new SyncMap<String, Cmail>();
	
	
	/**
	 * 单例模式
	 * @return
	 */
	public synchronized static MailCacheManager getInstance(){
		if(instanceManager == null)
			return new MailCacheManager();
		return instanceManager;
	}
	
	public void setCompanyMap(Cmail mail){
		mailMap.put(mail.getEmail(), mail);
	}
	
	public Cmail getCompanyMap(String mail){
		return mailMap.get(mail);
	}
	
	public Set<String> getKeys(){
		if( mailMap.keySet() == null || mailMap.size() == 0)
			return null ;
		return (Set<String>) mailMap.keySet();
	}
	
	public Collection<Cmail> getValues(){
		if(mailMap.values() == null || mailMap.size() == 0){
			return null;
		}
		else {
			return mailMap.values();
		}
	}
	
	public int getSize(){
		return mailMap.size();
	}
}
