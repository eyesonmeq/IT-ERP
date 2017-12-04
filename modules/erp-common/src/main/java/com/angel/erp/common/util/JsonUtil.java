/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.util;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * ADD FUNCTION
 *
 * @date: 2017年12月4日 上午11:02:06
 * @author li_ming 
 */
public class JsonUtil {
	public JsonUtil() {}

	public static String toJson(Object obj) {
		return JSON.toJSONString(obj);
	}

	public static Object parse(String json) {
		return JSON.parse(json);
	}

	public static String toJsonSuccess(String msg, Object obj) {
		Map<String, Object> mp = new HashMap<String, Object>();
		mp.put("status", 1);
		mp.put("state", "success");
		mp.put("msg", msg);
		mp.put("result", obj);
		return toJson(mp);
	}

	public static String toJsonError(String msg, Object obj) {
		Map<String, Object> mp = new HashMap<String, Object>();
		mp.put("status", 0);
		mp.put("state", "error");
		mp.put("msg", msg);
		mp.put("result", obj);
		return toJson(mp);
	}
}
