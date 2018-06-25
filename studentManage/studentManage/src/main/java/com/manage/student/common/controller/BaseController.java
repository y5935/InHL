package com.manage.student.common.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author jqbai
 */
public class BaseController {

	 /**
     * 根据key获取session 值
     */
	protected Object getFromSession(String key){
		return RequestContextHolder.getRequestAttributes().getAttribute(key, RequestAttributes.SCOPE_SESSION);
	}
	
	/**
	 * 信息添加到session
	 */
	protected void setFromSession(String key,Object value){
		RequestContextHolder.getRequestAttributes().setAttribute(key, value, RequestAttributes.SCOPE_SESSION);
	}
	
	/**
	 * 移除session中的缓存信息
	 */
	protected void removeFromSession(String key){
		RequestContextHolder.getRequestAttributes().removeAttribute(key, RequestAttributes.SCOPE_SESSION);
	}
	
	/**
	 * 设置cookie
	 */
	protected void setCookie(String key, String value, String domain){
	    Cookie cookie = new Cookie(key,value);
	    if(domain != null){
	        cookie.setDomain(domain);
	    }
	    ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse().addCookie(cookie);
	}
	
	/**
	 * 重定向
	 */
	protected void redirect(HttpServletRequest request,HttpServletResponse response, String path){
		try {
				response.sendRedirect(request.getContextPath() + path);
		}catch (java.io.IOException e) {
               e.printStackTrace();
		}
   }
	
}
