/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.util;

import java.util.UUID;

/**
 * 主键生成工具类
 *
 * @date: 2017年12月2日 下午4:57:55
 * @author li_ming 
 */
public class IdentitiesUtil {

	/**
	 * 生成UUID
	 *
	 * @return UUID
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

}
