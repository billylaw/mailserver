package com.wxluo.mybatis.dao;

import com.wxluo.mybatis.entity.Cuser;
import java.util.List;

public interface CuserMapper {
    int deleteByPrimaryKey(Integer userID);

    int insert(Cuser record);

    Cuser selectByPrimaryKey(Integer userID);

    List<Cuser> selectAll();

    int updateByPrimaryKey(Cuser record);
}