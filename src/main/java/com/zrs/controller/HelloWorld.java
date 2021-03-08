package com.zrs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//声明Bean对象，为一个控制器组件
@Controller
public class HelloWorld {

    /**
     * 映射请求的名称：用于客户端请求
     * 1. 使用 @RequestMapping 注解来映射请求的 URL
     * 2. 返回值会通过视图解析器解析为实际的物理视图, 对于 InternalResourceViewResolver 视图解析器,
     * 会做如下的解析:
     *                 通过 prefix + returnVal + suffix 这样的方式得到实际的物理视图, 然后做转发操作.
     *                 /WEB-INF/jsp/success.jsp
     */
    @RequestMapping("/helloworld")
    public String hellworld() {
        System.out.println("helloworld");
        return "success";  //默认是转发：  结果如何跳转呢？需要配置映射解析器   /WEB-INF/jsp/success.jsp
    }
}
