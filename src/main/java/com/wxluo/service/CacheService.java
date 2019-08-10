package com.wxluo.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxluo.cache.UserCacheManager;
import com.wxluo.mybatis.dao.CompanyMapper;
import com.wxluo.mybatis.dao.CuserMapper;
import com.wxluo.mybatis.entity.Cuser;


/**
 * @author wxluo
 *
 */
@Service
public class CacheService {
	
	@Autowired
	private CuserMapper userMapper;
	
	@Autowired
	private CompanyMapper companyMapper;
	
		
	/**
	 * 加载用户数据缓存缓存
	 */
	@PostConstruct
	public void initUserCache(){
		List<Cuser> userlist = this.userMapper.selectAll();
		if(userlist != null && userlist.size() > 0){
			for(Cuser user : userlist){
				if(user.getUserName() != null && user.getUserName() != ""){
					UserCacheManager.getInstance().setUserMap(user);
				}
			}
		}
	}
}
