package com.wxluo.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxluo.mybatis.dao.CrawlertaskMapper;

import com.wxluo.mybatis.entity.Crawlertask;

@Service
public class ScrapyService {
	
	@Autowired
	private CrawlertaskMapper crawlertaskMapper;
	
	
	public boolean doCrawlerTask(Crawlertask task) throws Exception {
		
		//脚本路径
		String pyFilePath="D:\\start.py";
		//解释器路径
		String pyPath="D:\\programfile\\python";
		//传递给python的参数
		String argv = "";
		
		//操作插入数据
		if(crawlertaskMapper.insert(task) > 0) {
			//执行python脚本
			Process process = Runtime.getRuntime().exec(pyPath+ " " + pyFilePath + " " + argv);
			//需要等待吗？
			process.waitFor();
			
			return true; 
		}
		return false;
	}
}
