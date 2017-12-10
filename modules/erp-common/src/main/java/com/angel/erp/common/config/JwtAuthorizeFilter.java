/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.angel.erp.common.util.security.JwtUtil;

/**
 * 用于JWT认证的过滤器 
 *
 * @date: 2017年12月10日 下午9:56:08
 * @author li_ming 
 */
public class JwtAuthorizeFilter implements Filter {
	// 注入配置文件类 
	@Autowired
	private JwtInfo jwtInfo;

	/* 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/* 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//		ResultMsg<Object> resultMsg;
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String auth = httpRequest.getHeader("Authorization");
		if ((auth != null) && (auth.length() > 7)) {
			String HeadStr = auth.substring(0, 6).toLowerCase();
			if (HeadStr.compareTo("bearer") == 0) {

				auth = auth.substring(7, auth.length());
				if (JwtUtil.parseJWT(auth, jwtInfo.getBase64Secret()) != null) {
					chain.doFilter(request, response);
					return;
				}
			}
		}

		//验证不通过  
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		httpResponse.setCharacterEncoding("UTF-8");
		httpResponse.setContentType("application/json; charset=utf-8");
		httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

		//将验证不通过的错误返回  
		//		ObjectMapper mapper = new ObjectMapper();
		//
		//		resultMsg = new ResultMsg<Object>(true, ResultStatusCode.INVALID_TOKEN.getErrorCode(),
		//				ResultStatusCode.INVALID_TOKEN.getErrorMsg(), null);
		//		httpResponse.getWriter().write(mapper.writeValueAsString(resultMsg));
		return;
	}

	/* 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, filterConfig.getServletContext());
	}

}
