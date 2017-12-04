/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ADD FUNCTION
 *
 * @date: 2017年12月4日 上午11:24:49
 * @author li_ming 
 */
@Component
public class JwtConfig {
	@Value("${jwt.header}")
	private String jwtHeader;
	@Value("${jwt.expiration}")
	private Long expiration;
	@Value("${jwt.token.head}")
	private String tokenHead;
	@Value("${jwt.secret}")
	private String secret;

	public String getJwtHeader() {
		return jwtHeader;
	}

	public void setJwtHeader(String jwtHeader) {
		this.jwtHeader = jwtHeader;
	}

	public Long getExpiration() {
		return expiration * 1000;
	}

	public void setExpiration(Long expiration) {
		this.expiration = expiration;
	}

	public String getTokenHead() {
		return tokenHead;
	}

	public void setTokenHead(String tokenHead) {
		this.tokenHead = tokenHead;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}
}
