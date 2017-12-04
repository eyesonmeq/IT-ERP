/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.jwt;

/**
 * ADD FUNCTION
 *
 * @date: 2017年12月4日 上午11:24:20
 * @author li_ming 
 */
public class AccessToken {
	private String accessToken;
	private String tokenType;
	private long expiresIn;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(long expiresIn) {
		this.expiresIn = expiresIn;
	}
}
