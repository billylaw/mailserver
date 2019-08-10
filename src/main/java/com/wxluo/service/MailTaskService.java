package com.wxluo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxluo.mybatis.dao.MailtaskMapper;
import com.wxluo.mybatis.entity.Mailtask;

@Service
public class MailTaskService {
	
	@Autowired
	private MailtaskMapper mailtaskMapper;
	
	
	/**
	 * 处理邮件任务
	 * @return
	 */
	public boolean doMailTask(Mailtask task){
		
		//获得收信箱
		List<String> acceptMail;
		
		String mailString = task.getSendMails();
		if(mailString != null && mailString.trim() != "") {
			String[] mails = mailString.split(";");
			
			//入库操作
			if(mailtaskMapper.insert(task) > 0) {
				//根据发信箱配置  发信箱如果有多个，是同时发 还是挨个发，需要做成多线程发送吗？
				for (String mail : mails) {
					
					
				}
			}
			
			//根据传入的发送邮件地址分配 指定的邮箱
			
			//获取邮箱组
			
		}

	}
	
}
