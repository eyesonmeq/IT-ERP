/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * 密码生成工具类
 *
 * @date: 2017年12月4日 上午11:03:35
 * @author li_ming 
 */
public class PasswordUtil {
	public static String createAdminPwd(String password, String salt) {
		return new SimpleHash("md5", password, ByteSource.Util.bytes(salt), 2).toHex();
	}

	public static String createCustomPwd(String password, String salt) {
		return new SimpleHash("md5", password, ByteSource.Util.bytes(salt), 1).toHex();
	}
}
