package com.zrs.controller;

import com.zrs.pojo.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;


@Controller
@RequestMapping("/accounttest")
public class AccountController {


    /**
     * 测试访问 testServletAPI
     * @return
     */
    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
        System.out.println(session.getServletContext());
        return "success";
    }


    /**
     * 删除账户
     * @param date
     * @return
     */
    @RequestMapping("/deleteAccount")
    public String deleteAccount(Date date){
        System.out.println("删除日期是:"+date);
        return "success";
    }

    /**
     * 保存账户
     * @param account
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account) {
        System.out.println("保存了账户。。。。"+account);
        return "success";
    }


    /**
     * 查询账户
     * @param accountId
     * @return
     */
    @RequestMapping("/findAccount")
    public String findAccount(Integer accountId,String accountName) {
        System.out.println("查询了账户。。。。"+accountId);
        System.out.println("查询账户名。。。。"+accountName);
        return "success";
    }



}
