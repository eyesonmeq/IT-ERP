/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.util;

import com.alibaba.fastjson.JSON;

/**
 * Json工具类
 *
 * @date: 2017年12月4日 上午11:02:06
 * @author li_ming 
 */
public class JsonUtil {

	/**
	 * 将对象转换成字符串
	 *
	 * @param obj
	 * @return 
	 */
	public static String toJson(Object obj) {
		return JSON.toJSONString(obj);
	}

	/**
	 * 将对象转换成字符串
	 *
	 * @param json
	 * @return 
	 */
	public static Object parse(String json) {
		return JSON.parse(json);
	}
}
