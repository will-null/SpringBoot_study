package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

@Controller
@RequestMapping("/u")
public class IdbcControllor {

    private Logger logger = Logger.getLogger(IdbcControllor.class);


    @Autowired
    UserService userService;

    /*@GetMapping("/wo/{id}")
    public User findById(@PathVariable String id) {
        User user = userService.findById(id);
        return user;
    }*/
    @GetMapping("/wo")
    public void findById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = new User("sasa", "23");
        request.setAttribute("user", user);
        //转发(2种方式)
        request.getRequestDispatcher("/blog/archives").forward(request,response);
        //return "forword:/ceng/hello.html";
        //重定向(2种方式)
        response.sendRedirect(request.getContextPath() + "/blog/archives");
        //redirectAttributes.addAttribute("adminId",managerId);
        //return "redirect:/ceng/hello.html";
    }

    @GetMapping("/blog/archives")
    public String archives(HttpServletRequest request, ModelAndView modelAndView) {
        Object ss = request.getAttribute("user");
        request.setAttribute("ss", ss);
//        this.blogBaseData(request,contentCond);//获取公共分类标签等数据
        return "/signIn";
    }


}
