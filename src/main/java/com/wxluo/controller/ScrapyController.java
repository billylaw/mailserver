package com.wxluo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wxluo.mybatis.entity.Crawlertask;
import com.wxluo.protocol.ResponseData;
import com.wxluo.service.ScrapyService;

@RestController
@RequestMapping(value="scrapy")
public class ScrapyController {

	@Autowired
	private ScrapyService scrapyService;
	
	@PostMapping("/dotask")
	public ResponseData doScrapyTask(Crawlertask task) {
		ResponseData responseData = new ResponseData();
		try {

			if(scrapyService.doCrawlerTask(task)) {
				responseData.setResponseCode(0);
			}else {
				responseData.setResponseCode(1);
				responseData.setResponseStr("执行爬虫失败！");
			}			
		} catch (Exception e) {
			// TODO: handle exception
			responseData.setResponseCode(2);
			responseData.setResponseStr("执行爬虫任务异常!");			
		}
		return responseData;
	}

}
