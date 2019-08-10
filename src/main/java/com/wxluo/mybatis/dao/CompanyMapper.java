package com.wxluo.mybatis.dao;

import com.wxluo.mybatis.entity.Company;
import java.util.List;

public interface CompanyMapper {
    int deleteByPrimaryKey(Integer companyID);

    int insert(Company record);

    Company selectByPrimaryKey(Integer companyID);

    List<Company> selectAll();

    int updateByPrimaryKey(Company record);
}