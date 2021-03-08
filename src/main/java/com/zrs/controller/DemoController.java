package com.zrs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class DemoController {

    /**
     * 返回 ModeAndView
     * @return
     */
    @RequestMapping("/testReturnModelAndView")
    public ModelAndView testReturnModelAndView() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("username", "张三");
        mv.setViewName("success"); //  /WEB-INF/jsp/success.jsp
        return mv;
    }


    //指定逻辑视图名，经过视图解析器解析为 jsp 物理路径：/WEB-INF/pages/success.jsp
    @RequestMapping("/testReturnString")
    public String testReturnString(Model model) {
        System.out.println("AccountController的testReturnString 方法执行了。。。。");
        model.addAttribute("message","测试转发");
        //return "success"; 默认转发
        return "forward:/WEB-INF/jsp/success.jsp"; // /WEB-INF/jsp/success.jsp
    }

    @RequestMapping("/testReturnVoid")
    public String testReturnVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("返回值是void");
        //request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request,response);
        //response.sendRedirect("testReturnString");

        //response.setCharacterEncoding("utf-8");
        //response.setContentType("application/json;charset=utf-8");
        //response.getWriter().write("{\"message\":\"hello!\"}");

        return "redirect:testReturnModelAndView"; //重定向

    }
}
