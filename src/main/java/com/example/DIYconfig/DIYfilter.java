/*
package com.example.DIYconfig;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

自定义的拦截器

public class DIYfilter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object o = request.getSession().getAttribute("loginUser");
        if (o == null) {
            request.setAttribute("msg", "请先登录");
            request.getRequestDispatcher("/signIn.html").forward(request, response);
            return false;
        } else {
            return true;
        }
    }


}
*/
