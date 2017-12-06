/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.exception;

/**
 * 服务（业务）异常
 *
 * @date: 2017年12月6日 下午11:15:04
 * @author li_ming 
 */
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = -4944426204113033415L;

	public ServiceException() {}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause.getMessage(), cause);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
