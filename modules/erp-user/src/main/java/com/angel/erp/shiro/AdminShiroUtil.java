/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * shiro工具类
 *
 * @date: 2017年12月4日 上午11:46:38
 * @author li_ming 
 */
public class AdminShiroUtil {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 获取授权主要对象
	 */
	public static Subject getSubject() {
		return SecurityUtils.getSubject();
	}

	public static Session getSession() {
		try {
			Session session = getSubject().getSession();
			if (session == null) {
				session = getSubject().getSession();
			}
			if (session != null) {
				return session;
			}
		} catch (InvalidSessionException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Admin getUserInfo() {
		try {
			if (getSession() != null) {
				Admin admin = (Admin) getSubject().getPrincipals().getPrimaryPrincipal();
				return admin;
			} else {
				return null;
			}
		} catch (Exception e) {

		}
		return null;
	}

	public static Object getCache(String key) {
		return getCache(key, null);
	}

	public static Object getCache(String key, Object defaultValue) {
		Object obj = getSession().getAttribute(key);
		return obj == null ? defaultValue : obj;
	}

	public static void putCache(String key, Object value) {
		getSession().setAttribute(key, value);
	}

	public static void removeCache(String key) {
		getSession().removeAttribute(key);
	}
}
