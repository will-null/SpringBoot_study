package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class AllContoller {

    @RequestMapping("/signIn")
    /* @RequestParam 要与网页form中的name一致*/
    public String signIn(@RequestParam("name") String name, @RequestParam("passWord") String pwd, Model model, HttpSession httpSession) {
        if (name == "1" && pwd == "1") {
            // return "index";
            httpSession.setAttribute("loginUser",name);
            return "redirect:main.html";
        }else{
            model.addAttribute("msg","都输入1");
            return "signIn";
        }
    }


}
