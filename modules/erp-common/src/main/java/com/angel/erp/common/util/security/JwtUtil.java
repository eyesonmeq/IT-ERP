/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.util.security;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;

import com.angel.erp.common.constant.JWTConstant;
import com.angel.erp.common.dto.AuthenticationTokenDTO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 构造及解析jwt的工具类
 *
 * @date: 2017年12月10日 下午8:29:46
 * @author li_ming 
 */
public class JwtUtil {

	/**
	 * 解析token
	 *
	 * @param jsonWebToken
	 * @return 
	 */
	public static AuthenticationTokenDTO parseJWT(String jsonWebToken) {
		String base64Security = JWTConstant.JWT_BASE64_SECRET;
		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
				.parseClaimsJws(jsonWebToken).getBody();
		AuthenticationTokenDTO authenticationToken = new AuthenticationTokenDTO();
		authenticationToken.setToken(jsonWebToken);
		authenticationToken.setUserName(String.valueOf(claims.get(JWTConstant.USER_ACCOUNT)));
		authenticationToken.setAuth(String.valueOf(claims.get(JWTConstant.USER_PASSWORD)));
		return authenticationToken;
	}

	/**
	 * 生成token 
	 *
	 * @param name
	 * @param password
	 * @return 
	 */
	public static String createJWT(String name, String password) {
		long TTLMillis = JWTConstant.JWT_EXPIRES_SECOND;
		String base64Security = JWTConstant.JWT_BASE64_SECRET;
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		//生成签名密钥  
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Security);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
		//添加构成JWT的参数  
		JwtBuilder builder = Jwts.builder().setHeaderParam(JWTConstant.TYPE, JWTConstant.TOKENHEAD)
				.claim(JWTConstant.USER_PASSWORD, password).claim(JWTConstant.USER_ACCOUNT, name)
				.setIssuer(JWTConstant.JWT_NAME).setAudience(JWTConstant.JWT_CLIENT_ID)
				.signWith(signatureAlgorithm, signingKey);
		//添加Token过期时间  
		if (TTLMillis >= 0) {
			long expMillis = nowMillis + TTLMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp).setNotBefore(now);
		}
		//生成JWT  
		return builder.compact();
	}

	/**
	 * 获取登录用户
	 *
	 * @return 
	 */
	public static AuthenticationTokenDTO getLoginUser() {
		Subject currentUser = SecurityUtils.getSubject();
		AuthenticationTokenDTO user = parseJWT(currentUser.getPrincipal().toString());
		return user == null ? null : user;
	}

	/**
	 * 生成密码
	 *
	 * @param password
	 * @param salt
	 * @return 
	 */
	public static String createPwd(String password, String salt) {
		return new SimpleHash("md5", password, ByteSource.Util.bytes(salt), 2).toHex();
	}
	
}
