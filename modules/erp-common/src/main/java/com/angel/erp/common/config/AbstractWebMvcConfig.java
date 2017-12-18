/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.config;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.angel.erp.common.dto.ResultDTO;
import com.angel.erp.common.exception.ServiceException;

/**
 * Spring MVC 配置
 *
 * @date: 2017年12月4日 上午11:22:58
 * @author li_ming 
 */
public abstract class AbstractWebMvcConfig extends WebMvcConfigurerAdapter {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		//使用阿里 FastJson 作为JSON MessageConverter
		FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
		FastJsonConfig config = new FastJsonConfig();
		config.setSerializerFeatures(SerializerFeature.WriteMapNullValue, //保留空的字段
				SerializerFeature.WriteNullStringAsEmpty, //String null -> ""
				SerializerFeature.WriteNullNumberAsZero);//Number null -> 0
		converter.setFastJsonConfig(config);
		converter.setDefaultCharset(Charset.forName("UTF-8"));
		converters.add(converter);
	}

	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		//统一异常处理
		exceptionResolvers.add(new HandlerExceptionResolver() {
			@SuppressWarnings("rawtypes")
			public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
					Object handler, Exception e) {
				ResultDTO result = new ResultDTO();
				if (e instanceof ServiceException) {//业务失败的异常，如“账号或密码错误”
					result.setCode(ResultDTO.ResultCode.FAIL.code).setMessage(e.getMessage());
				} else if (e instanceof NoHandlerFoundException) {
					result.setCode(ResultDTO.ResultCode.NOT_FOUND.code)
							.setMessage("接口 [" + request.getRequestURI() + "] 不存在");
				} else if (e instanceof ServletException) {
					result.setCode(ResultDTO.ResultCode.FAIL.code).setMessage(e.getMessage());
				} else {
					result.setCode(ResultDTO.ResultCode.INTERNAL_SERVER_ERROR.code)
							.setMessage("接口 [" + request.getRequestURI() + "] 内部错误，请联系管理员");
				}
				logger.error(e.getMessage(), e);
				responseResult(response, result);
				return new ModelAndView();
			}

		});
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		//解决跨域问题
		registry.addMapping("/**");
	}

//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new HandlerInterceptorAdapter() {
//			@Override
//			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//					throws Exception {
//				// 可以自定义拦截器
//				return true;
//			}
//		});
//	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	}

	/**
	 * 组装响应内容
	 *
	 * @param response
	 * @param result 
	 */
	@SuppressWarnings("rawtypes")
	private void responseResult(HttpServletResponse response, ResultDTO result) {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "application/json;charset=UTF-8");
		response.setStatus(200);
		try {
			response.getWriter().write(JSON.toJSONString(result));
		} catch (IOException ex) {
			logger.error(ex.getMessage(), ex);
		}
	}

}
