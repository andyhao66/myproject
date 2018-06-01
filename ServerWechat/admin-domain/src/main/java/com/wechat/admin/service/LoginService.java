package com.wechat.admin.service;

import java.util.Map;

/**
 * Created by hyf on 2018/2/8.
 */
public interface LoginService {

    Map loginByPassword(String phone, String password);

    Map registerUser(String phone, String code, String password,String realName,String idNum);

}
