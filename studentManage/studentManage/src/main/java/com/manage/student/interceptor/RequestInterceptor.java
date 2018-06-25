package com.manage.student.interceptor;

import com.manage.student.common.controller.BaseController;
import com.manage.student.common.exception.ControllerException;
import com.manage.student.common.response.Response;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestInterceptor extends BaseController implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        if (null == getFromSession("userInfo")) {
            if(request.getRequestURL().toString().contains("exp")){
                response.getWriter().write("err");
            }
            throw new ControllerException(Response.Status.ERR_INVALID,"用户信息已失效！");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {

    }
}
