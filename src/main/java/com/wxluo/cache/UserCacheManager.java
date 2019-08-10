package com.wxluo.cache;

import java.util.Collection;
import java.util.Set;

import com.wxluo.mybatis.entity.Company;
import com.wxluo.mybatis.entity.Cuser;


public class UserCacheManager {
	
	private static UserCacheManager instanceManager =  new UserCacheManager();
	
	private static SyncMap<String, Cuser> userMap = new SyncMap<String, Cuser>();
	
	
	/**
	 * 单例模式
	 * @return
	 */
	public synchronized static UserCacheManager getInstance(){
		if(instanceManager == null)
			return new UserCacheManager();
		return instanceManager;
	}
	
	public void setUserMap(Cuser user){
		userMap.put(user.getUserName(), user);
	}
	
	public Cuser getUserMap(String userName){
		return userMap.get(userName);
	}
	
	public Set<String> getKeys(){
		if( userMap.keySet() == null || userMap.size() == 0)
			return null ;
		return (Set<String>) userMap.keySet();
	}
	
	public Collection<Cuser> getValues(){
		if(userMap.values() == null || userMap.size() == 0){
			return null;
		}
		else {
			return userMap.values();
		}
	}
	
	public int getSize(){
		return userMap.size();
	}
	
	
}
