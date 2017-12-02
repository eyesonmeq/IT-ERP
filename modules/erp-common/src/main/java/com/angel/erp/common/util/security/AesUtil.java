/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.util.security;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 用来进行AES的加密和解密的工具类
 *
 * @date: 2017年12月2日 下午3:55:14
 * @author li_ming 
 */
public class AesUtil {
	// 加密算法
	private static final String CIPHER_ALGORITHM = "AES";

	/**
	 * 加密
	 *
	 * @param date 明文
	 * @param keyStr 密钥
	 * @return 密文
	 * @throws SecurityException 
	 */
	public static String encrypt(String date, String keyStr) throws SecurityException {
		try {
			Key key = new SecretKeySpec(keyStr.getBytes(), CIPHER_ALGORITHM);
			Cipher c = Cipher.getInstance(CIPHER_ALGORITHM);
			c.init(Cipher.ENCRYPT_MODE, key);
			byte[] encVal = c.doFinal(date.getBytes());
			return new BASE64Encoder().encode(encVal);
		} catch (Exception e) {
			throw new SecurityException(e.getMessage(), e);
		}
	}

	/**
	 * 解密
	 *
	 * @param encryptedData 密文
	 * @param keyStr 密钥
	 * @return 明文
	 * @throws SecurityException
	 */
	public static String decrypt(String encryptedData, String keyStr) throws SecurityException {
		try {
			Key key = new SecretKeySpec(keyStr.getBytes(), CIPHER_ALGORITHM);
			Cipher c = Cipher.getInstance(CIPHER_ALGORITHM);
			c.init(Cipher.DECRYPT_MODE, key);
			byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
			return new String(c.doFinal(decordedValue));
		} catch (Exception e) {
			throw new SecurityException(e.getMessage(), e);
		}
	}
}
