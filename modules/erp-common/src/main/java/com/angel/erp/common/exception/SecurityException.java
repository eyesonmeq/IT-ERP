/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.exception;

/**
 * 安全处理过程中产生的异常
 *
 * @date: 2017年12月2日 下午4:04:57
 * @author li_ming 
 */
public class SecurityException extends RuntimeException {

	private static final long serialVersionUID = 3452341605040319264L;

	public SecurityException() {}

	public SecurityException(String message) {
		super(message);
	}

	public SecurityException(Throwable cause) {
		super(cause.getMessage(), cause);
	}

	public SecurityException(String message, Throwable cause) {
		super(message, cause);
	}
}
