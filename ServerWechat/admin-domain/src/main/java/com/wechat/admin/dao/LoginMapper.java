package com.wechat.admin.dao;

import com.wechat.admin.model.Login;

public interface LoginMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(Login record);

    int insertSelective(Login record);

    Login selectByPrimaryKey(Long userId);

    Login selectByPhoneNum(String phoneNum);

    Login selectByIdNum(String idNum);

    int updateByPrimaryKeySelective(Login record);

    int updateByPrimaryKey(Login record);
}