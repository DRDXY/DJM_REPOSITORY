package com.raze.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

/**
 * Copyright: Copyright (c) 2016 DJM
 * 
 * @ClassName: MyUserDetailService.java
 * @Description: 自定义过滤器
 *
 * @version: v1.0.0
 * @author: DJM
 * @date: 2016-09-18 下午15:25:17
 */
public class MyFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {
	
	@Autowired
	@Qualifier("mySecurityMetadataSource")
	private FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		FilterInvocation fi = new FilterInvocation( request, response, chain );  
		invoke(fi);  
	}

	@Override
	public Class<?> getSecureObjectClass() {
		return FilterInvocation.class;
	}

	public void invoke(FilterInvocation fi) throws IOException, ServletException {  
		InterceptorStatusToken  token = super.beforeInvocation(fi);  
	    try{  
	    	fi.getChain().doFilter(fi.getRequest(), fi.getResponse());  
	    }finally{  
	    	super.afterInvocation(token, null);  
	    }  
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return this.filterInvocationSecurityMetadataSource;
	}
	
}
