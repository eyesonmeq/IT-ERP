/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.util;

import org.slf4j.Logger;

/**
 * 日志工具类
 *
 * @date: 2017年12月14日 下午11:13:18
 * @author li_ming 
 */
public class LogUtil {
	/**
	 * 记录INFO级别日志
	 *
	 * @param logger
	 * @param msg 
	 */
	public static void info(Logger logger, String msg) {
		if (logger.isInfoEnabled()) {
			logger.info(msg);
		}
	}

	/**
	 * 记录DEBUG级别日志
	 *
	 * @param logger
	 * @param msg 
	 */
	public static void debug(Logger logger, String msg) {
		if (logger.isDebugEnabled()) {
			logger.debug(msg);
		}
	}

	/**
	 * 记录WARNING级别日志
	 *
	 * @param logger
	 * @param msg 
	 */
	public static void warn(Logger logger, String msg) {
		if (logger.isWarnEnabled()) {
			logger.warn(msg);
		}
	}

	/**
	 * 记录ERROR级别日志
	 *
	 * @param logger
	 * @param msg 
	 */
	public static void error(Logger logger, String msg) {
		logger.error(msg);
	}

	/**
	 * 记录ERROR级别日志
	 *
	 * @param logger
	 * @param t 
	 */
	public static void error(Logger logger, Throwable t) {
		logger.error(t.getMessage(), t);
	}

	/**
	 * 记录ERROR级别日志
	 *
	 * @param logger
	 * @param msg
	 * @param t 
	 */
	public static void error(Logger logger, String msg, Throwable t) {
		logger.error(msg, t);
	}
}
