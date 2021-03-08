package com.zrs.controller;

import com.zrs.pojo.Account;
import com.zrs.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
public class JsonController {

    @RequestMapping("/testResponseJson")
    @ResponseBody
    public Account testResponseJson(@RequestBody Account account){
        System.out.println(account);
        return account;
    }


    @RequestMapping("/test1")
    @ResponseBody
    public User test1(){
        User user=new User();
        user.setId(1);
        user.setUsername("zrs");
        user.setPassword("2312312312");
        return user;
    }

    @RequestMapping("/test2")
    public @ResponseBody List<User> test2(){
        User user1=new User();
        user1.setId(1);
        user1.setUsername("zrs");
        user1.setPassword("2312312312");
        User user2=new User();
        user2.setId(2);
        user2.setUsername("Mary");
        user2.setPassword("2312312312");
        List<User> users=new ArrayList<>();
        users.add(user1);
        users.add(user2);
        return users;
    }
}
