package com.wechat.admin;

import com.wechat.admin.model.Login;
import com.wechat.admin.model.User;
import com.wechat.admin.service.LoginService;
import com.wechat.admin.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminDomainApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @Test
    public void contextLoads() {
        List<User> userList = userService.findAllUser(1, 3);

        for (User user : userList) {
            System.out.println(user.getUserId() + "," + user.getUserName());
        }
    }

    @Test
    public void testLoginService() {
        Map<String, Object> map = loginService.loginByPassword("15623663850", "1234561");

        for (String key : map.keySet()) {
            System.out.println(key + "," + map.get(key));
        }
    }

    @Test
    public void testRegisterUser(){
        Map<String, Object> map = loginService.registerUser("12312341234","1234","123456","测试1","123412341234123412");
        for (String key : map.keySet()) {
            System.out.println(key + "," + map.get(key));
        }
    }

    @Test
    public void testStr(){
        String code = "1234";
        System.out.println(code != null && code.length() != 4);
    }

}
