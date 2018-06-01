package com.wechat.admin.service.impl;

import com.wechat.admin.dao.LoginMapper;
import com.wechat.admin.model.Login;
import com.wechat.admin.service.LoginService;
import com.wechat.admin.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service(value = "loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Map<String, Object> registerUser(String phone, String code, String password,
                                            String realName, String idNum) {
        Map<String, Object> map = new HashMap<>();

        Login login = new Login();
        login.setPhoneNum(phone);
        login.setPassword(password);
        login.setRealName(realName);
        login.setIdNum(idNum);
        login.setInputDate(new Date());

        Login login1 = loginMapper.selectByIdNum(idNum);
        if(null != login1){
            map.put("success",false);
            map.put("message","身份证号已存在");
            return map;
        }
        Login login2 = loginMapper.selectByPhoneNum(phone);
        if(null != login2){
            map.put("success",false);
            map.put("message","手机号已存在");
            return map;
        }

        int flag = loginMapper.insertSelective(login);
        if (flag > 0) {
            map.put("success",true);
            map.put("message","注册成功");
        }else{
            map.put("success",false);
            map.put("message","增加用户出错");
        }
        return map;
    }

    @Override
    public Map<String, Object> loginByPassword(String phoneNum, String password) {
        Map<String, Object> map = new HashMap<>();
        Login login = loginMapper.selectByPhoneNum(phoneNum);
        if (null == login) {
            map.put("success", false);
            map.put("message", "用户不存在,请先注册.");
        } else if (null == login.getPassword()) {
            map.put("success", false);
            map.put("message", "密码为空,请先设置密码.");
        } else if (login.getPassword().equals(password)) {
            map.put("success", true);
            map.put("message", "登录成功.");
        } else {
            map.put("success", false);
            map.put("message", "密码错误.");
        }
        return map;
    }


}
