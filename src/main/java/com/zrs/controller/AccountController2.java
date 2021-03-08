package com.zrs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/account")
public class AccountController2 {

    /**
     * PathVariable 注解
     * @return
     */
    @RequestMapping("/usePathVariable/{id}")
    public String usePathVariable(@PathVariable("id") Integer id){
        System.out.println("id="+id);
        return "success";
    }

    /**
     * request body 注解
     * @return
     */
    @RequestMapping("/useRequestBody")
    public String useRequestBody(@RequestBody(required = false) String message){
        System.out.println(message);
        return "success";
    }

    /**
     * requestParams 注解的使用
     * @param name
     * @return
     */
    @RequestMapping("/useRequestParam")
    public String showName(@RequestParam(value = "username",required = true,defaultValue = "哈哈") String name,@RequestParam(value = "age",required = true,defaultValue = "18") Integer age){
        System.out.println("接收到的参数是:"+name);
        System.out.println("接收到的参数是:"+age);
        return "success";
    }

    /**
     * 删除账户
     * @return
     */
    @RequestMapping(value="/removeAccount",params={"accountName","money!=100"})
    public String removeAccount() {
        System.out.println("删除了账户");
        return "success";
    }

    /**
     * 查询账户
     * @return
     */
    @RequestMapping("/findAccount")
    public String findAccount() {
        System.out.println("查询了账户。。。。");
        return "success";
    }

    /**
     * 保存账户
     * @return
     */
    @RequestMapping(value="/saveAccount",method= RequestMethod.POST)
    public String saveAccount() {
        System.out.println("保存了账户");
        return "success";
    }

}
