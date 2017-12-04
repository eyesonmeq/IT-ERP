/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.HashMap;
import java.util.Map;

/**
 * ADD FUNCTION
 *
 * @date: 2017年12月4日 下午2:08:18
 * @author li_ming 
 */
public class CustomHttpServletRequest extends HttpServletRequestWrapper {
	private Map<String, String> customHeaders;

	/**
	 * Constructs a request object wrapping the given request.
	 *
	 * @param request The request to wrap
	 * @throws IllegalArgumentException if the request is null
	 */
	public CustomHttpServletRequest(HttpServletRequest request) {
		super(request);
		this.customHeaders = new HashMap<String, String>();
	}

	public void putHeader(String name, String value) {
		this.customHeaders.put(name, value);
	}

	public String getHeader(String name) {
		String headerValue = customHeaders.get(name);
		if (headerValue != null) {
			return headerValue;
		}
		return ((HttpServletRequest) getRequest()).getHeader(name);
	}
}
