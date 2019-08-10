package com.wxluo.service;

import java.text.SimpleDateFormat;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxluo.cache.MailCacheManager;
import com.wxluo.mybatis.dao.CmailMapper;
import com.wxluo.mybatis.entity.Cmail;

/**
 * @author wxluo
 *
 */
@Service
public class MailService {

	@Autowired
	private CmailMapper maillMapper;
	
	
	/**
	 * 添加邮件信息
	 * @return
	 */
	public boolean addMail(Cmail mail){
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMddHHmmssfff");		
		long time = Long.parseLong(sdFormat.toString());
		
		mail.setCreateTime(time);
		mail.setUpdateTime(time);
		mail.setStatus((byte)0);
		
		if(maillMapper.insert(mail) > 0){
			return true;
		}else {
			return false;
		}	
	}
	
	/**
	 * 修改邮件信息
	 * @param mail
	 * @return
	 */
	public boolean updateMail(Cmail mail){
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMddHHmmssfff");		
		long time = Long.parseLong(sdFormat.toString());
		mail.setUpdateTime(time);
		mail.setStatus((byte)0);
		if(maillMapper.updateByPrimaryKey(mail) > 0){
			return true;
		}else {
			return false;
		}
	}
	
	
	/**
	 * 删除邮件信息
	 * @param mail
	 * @return
	 */
	public boolean  deleteMail(Cmail mail){
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMddHHmmssfff");		
		long time = Long.parseLong(sdFormat.toString());
		mail.setUpdateTime(time);
		mail.setStatus((byte)1);
		if(maillMapper.updateByPrimaryKey(mail) > 0){
			return true;
		}else {
			return false;
		}
	}
	
	
	/**
	 * 所有邮件
	 * @return
	 */
	public Collection<Cmail> getMails(){
		if(MailCacheManager.getInstance().getSize() ==0){
			return null;
		}
		return MailCacheManager.getInstance().getValues();
	}
	
	
	
}
