/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.config;

import java.util.Objects;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.angel.erp.common.constant.JWTConstant;
import com.angel.erp.common.dto.AuthenticationTokenDTO;
import com.angel.erp.common.util.security.JwtUtil;

/**
 * 自定义Realm
 *
 * @date: 2017年12月12日 下午3:46:15
 * @author li_ming 
 */
public class MyRealm extends AuthorizingRealm {

	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisTemplate redisTemplate;

	@Override
	public boolean supports(AuthenticationToken token) {
		return token instanceof AuthenticationTokenDTO;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		AuthenticationTokenDTO token = JwtUtil.parseJWT(principals.toString());
		AuthenticationTokenDTO redisToken = (AuthenticationTokenDTO) redisTemplate.opsForValue()
				.get(JWTConstant.TOKENHEAD + token.getUserName());
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		if (Objects.equals(token.getToken(), redisToken.getToken())) {
			simpleAuthorizationInfo.addRoles(redisToken.getRoles());
			simpleAuthorizationInfo.addStringPermissions(redisToken.getPermission());
		}
		return simpleAuthorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
		AuthenticationTokenDTO token = JwtUtil.parseJWT(String.valueOf(auth.getCredentials()));
		if (token == null) {
			throw new AuthenticationException("token invalid");
		}
		AuthenticationTokenDTO redisToken = (AuthenticationTokenDTO) redisTemplate.opsForValue()
				.get(JWTConstant.TOKENHEAD + token.getUserName());

		if (!Objects.equals(token.getToken(), redisToken.getToken())) {
			throw new AuthenticationException("token auth fail");
		}
		return new SimpleAuthenticationInfo(token, redisToken, this.getName());
	}
}
