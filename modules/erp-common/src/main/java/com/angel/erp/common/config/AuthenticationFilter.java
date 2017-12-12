/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.angel.erp.common.constant.JWTConstant;
import com.angel.erp.common.dto.AuthenticationTokenDTO;
import com.angel.erp.common.dto.ResultDTO;
import com.angel.erp.common.util.JsonUtil;
import com.angel.erp.common.util.security.JwtUtil;

/**
 * 用于JWT认证的过滤器 
 *
 * @date: 2017年12月10日 下午9:56:08
 * @author li_ming 
 */
public class AuthenticationFilter extends BasicHttpAuthenticationFilter {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		// 获取Authorization字段
		String authorization = httpServletRequest.getHeader(JWTConstant.AUTHORIZATION);
		if ((authorization != null) && (authorization.length() > 7)) {
			try {
				String headStr = authorization.substring(0, 6);
				if (headStr.compareTo(JWTConstant.TOKENHEAD) == 0) {
					authorization = authorization.substring(7, authorization.length());
					AuthenticationTokenDTO token = JwtUtil.parseJWT(authorization);
					// 提交给realm进行登入，如果错误他会抛出异常并被捕获
					getSubject(request, response).login(token);
					return true;
				} else {
					return failure(response);
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				return failure(response);
			}
		} else {
			return failure(response);
		}
	}

	/**
	 * 返回失败的响应数据
	 *
	 * @param response
	 */
	private boolean failure(ServletResponse response) {
		ResultDTO<Object> result = new ResultDTO<Object>();
		result.setCode(ResultDTO.ResultCode.UNAUTHORIZED.code);
		result.setMessage("token auth fail");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.append(JsonUtil.toJson(result));
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		} finally {
			if (out != null) {
				out.close();
			}
		}
		return false;
	}

}
