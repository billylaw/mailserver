package com.wxluo.mybatis.dao;

import com.wxluo.mybatis.entity.Crawlertask;
import java.util.List;

public interface CrawlertaskMapper {
    int deleteByPrimaryKey(Integer crawlerID);

    int insert(Crawlertask record);

    Crawlertask selectByPrimaryKey(Integer crawlerID);

    List<Crawlertask> selectAll();

    int updateByPrimaryKey(Crawlertask record);
}