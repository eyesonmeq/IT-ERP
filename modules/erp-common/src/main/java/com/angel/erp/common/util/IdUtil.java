/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.util;

import java.nio.ByteBuffer;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.RandomStringGenerator;

/**
 * ID工具类
 *
 * @date: 2017年12月2日 下午4:57:55
 * @author li_ming 
 */
public class IdUtil {

	/**
	 * 生产UUID
	 *
	 * @return 
	 */
	public static String uuid() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "").toLowerCase();
	}

	/**
	 * 生产64位UUID
	 *
	 * @return 
	 */
	public static String uuid64() {
		UUID uuid = UUID.randomUUID();
		ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
		bb.putLong(uuid.getMostSignificantBits());
		bb.putLong(uuid.getLeastSignificantBits());
		return Base64.encodeBase64URLSafeString(bb.array());
	}

	/**
	 * 生成随机数字
	 *
	 * @param length
	 * @return 
	 */
	public static String randomNumeric(int length) {
		RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('0', '9').build();
		return generator.generate(length);
	}

	/**
	 * 生成随机字母
	 *
	 * @param length
	 * @return 
	 */
	public static String randomAlphabetic(int length) {
		RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('a', 'z').build();
		return generator.generate(length);
	}

	/**
	 * 生成随机字符串
	 *
	 * @param length
	 * @return 
	 */
	public static String randomAlphanumeric(int length) {
		RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('0', 'z').build();
		return generator.generate(length);
	}

}
