package com.zrs.controller;

import com.zrs.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
@RequestMapping("/springmvc")
public class AccountController3 {

    @RequestMapping("/updateUser")
    public String updateUser(@ModelAttribute("u") User user){
        System.out.println("---------->要更新的对象是："+user);
        return "success";
    }

    /**
     * 被 ModelAttribute 修饰的方法
     */
    @ModelAttribute
    public void showModel(Integer id,Map<String,User> map) {
        System.out.println("执行了showModel 方法,要更新的ID是:"+id);
        //根据username查询数据库的信息
        User user1 = findUserById(id);
        System.out.println("数据库中原始的数据信息:"+user1);
        map.put("u",user1);
    }

    /**
     * 模拟去数据库查询
     * @return
     */
    private User findUserById(Integer id) {
        User user = new User();
        user.setId(id);
        user.setUsername("张三");
        user.setAge(19);
        user.setPassword("123456");
        return user;
    }


    /**
     * 接收请求的方法
     * @param user
     * @return
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(User user){
        System.out.println("username="+user.getUsername());
        return "success";
    }

    /**
     * 模拟去数据库查询
     * @param username
     * @return
     */
    private User findUserByName(String username) {
        User user = new User();
        user.setUsername(username);
        user.setAge(19);
        user.setPassword("123456");
        return user;
    }

    /**
     * Cookie 注解注解
     * @return
     */
    @RequestMapping("/useCookieValue")
    public String useCookieValue(@CookieValue(value="JSESSIONID",required=false)
                                         String cookieValue){
        System.out.println(cookieValue);
        return "success";
    }

    /**
     * RequestHeader 注解
     * @return
     */
    @RequestMapping("/useRequestHeader")
    public String useRequestHeader(@RequestHeader(value="User-Agent", required=false)String requestHeader){
        System.out.println(requestHeader);
        return "success";
    }


    @RequestMapping(value = "/testRestPOST",method = RequestMethod.POST)
    public String testRestPOST(String username){
        System.out.println(username);
        return "success";
    }

    @RequestMapping(value = "/testRestDELETE/{id}",method = RequestMethod.DELETE)
    public String testRestDELETE(@PathVariable("id") Integer id){
        System.out.println("id="+id);
        return "success";
    }

    @RequestMapping(value = "/testRestGET/{id}",method = RequestMethod.GET)
    public String testRestGET(@PathVariable("id") Integer id){
        System.out.println("id="+id);
        return "success";
    }

    @RequestMapping(value = "/testRestPUT/{id}",method = RequestMethod.PUT)
    public String testRestPUT(@PathVariable("id") Integer id,String username){
        System.out.println("id="+id);
        System.out.println(username);
        return "success";
    }

}
