package com.anlu.core.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 拦截防止sql Xss注入
 * 
 * @author xwchai
 * 
 */
public class ScriptXssFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {

		ScriptXssFilterWarp xssRequest = new ScriptXssFilterWarp(
				(HttpServletRequest) request);
		filterChain.doFilter(xssRequest, response);
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
