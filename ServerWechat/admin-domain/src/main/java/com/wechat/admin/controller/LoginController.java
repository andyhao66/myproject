package com.wechat.admin.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;

import com.wechat.admin.service.LoginService;
import com.wechat.admin.utils.CommonUtils;
import com.wechat.admin.web.WebSecurityConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @GetMapping("/")
    public String index(@SessionAttribute(WebSecurityConfig.SESSION_KEY) String username,
                        Model model) {
        logger.info("index,username:" + username);
        model.addAttribute("name", username);
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        logger.info("login,");
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        logger.info("register,");
        return "dtuser/register";
    }

    @PostMapping("/registerSendCode")
    public
    @ResponseBody
    Map<String, Object> sendCode(String phonenum) {
        logger.info("sendCode,phonenum:" + phonenum);
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "验证码已发送");
        return map;
    }

    @PostMapping("/registerPost")
    public
    @ResponseBody
    Map<String, Object> registerPost(String username,
                                     String code,
                                     String pwd,
                                     String pwd2,
                                     String realName,
                                     String idNum) {
        logger.info("registerPost,username:{},code:{},pwd:{},pwd2:{},realName:{},idNum:{}",
                username, code, pwd, pwd2,realName,idNum);
        Map<String, Object> map = new HashMap<>();

        if (username == null || username.length() != 11) {
            map.put("message", "手机号不正确");
            map.put("success", false);
        } else if (code == null || code.length() != 4) {
            map.put("message", "验证码不正确");
            map.put("success", false);
        } else if (pwd == null || pwd2 == null) {
            map.put("message", "密码不能为空");
            map.put("success", false);
        } else if (!pwd.equals(pwd2)) {
            map.put("message", "两次密码不匹配");
            map.put("success", false);
        } else if (realName == null) {
            map.put("message", "真实姓名不能为空");
            map.put("success", false);
        } else if (idNum == null) {
            map.put("message", "身份证号不能为空");
            map.put("success", false);
        } else {
            map = loginService.registerUser(username, code, pwd, realName, idNum);
        }
        return map;
    }

    @PostMapping("/loginPost")
    public
    @ResponseBody
    Map<String, Object> loginPost(String username,
                                  String password,
                                  HttpSession session) {
        logger.info("loginPost,username:" + username + ",password:" + password);
        Map<String, Object> map = new HashMap<>();

        if (CommonUtils.isBlank(username)) {
            map.put("success", false);
            map.put("message", "手机号不能为空");
        } else if (CommonUtils.isBlank(password)) {
            map.put("success", false);
            map.put("message", "密码不能为空");
        } else {
            map = loginService.loginByPassword(username, password);
            if ((boolean) map.get("success")) {
                // 设置session
                session.setAttribute(WebSecurityConfig.SESSION_KEY, username);
            }
        }
        return map;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "redirect:/login";
    }

}
