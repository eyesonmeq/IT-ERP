/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.angel.erp.mapper.SysPermissionMapper;
import com.angel.erp.mapper.SysUserMapper;

/**
 * 
 *
 * @date: 2017年12月9日 下午11:56:36
 * @author li_ming 
 */
public class ShiroRealm extends AuthorizingRealm {

	@Autowired
	private SysUserMapper userMapper;
	@Autowired
	private SysPermissionMapper permissionMapper;

	/* 
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		// TODO Auto-generated method stub
		User user = userService.getByUserName((String) principalCollection.getPrimaryPrincipal());

		//把principals放session中 key=userId value=principals
		SecurityUtils.getSubject().getSession().setAttribute(String.valueOf(user.getId()),
				SecurityUtils.getSubject().getPrincipals());

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//赋予角色
		for (Role userRole : user.getRoles()) {
			info.addRole(userRole.getName());
		}
		//赋予权限
		for (Permission permission : permissionService.getByUserId(user.getId())) {
			//	            if(StringUtils.isNotBlank(permission.getPermCode()))
			info.addStringPermission(permission.getName());
		}

		//设置登录次数、时间
		//	        userService.updateUserLogin(user);
		return info;
	}

	/* 
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		// TODO Auto-generated method stub

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName=token.getUsername();
        logger.info(userName+token.getPassword());

        User user = userService.getByUserName(token.getUsername());
        if (user != null) {
//            byte[] salt = Encodes.decodeHex(user.getSalt());
//            ShiroUser shiroUser=new ShiroUser(user.getId(), user.getLoginName(), user.getName());
            //设置用户session
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("user", user);
            return new SimpleAuthenticationInfo(userName,user.getPassword(),getName());
        } else {
            return null;
        }
//        return null;
	}

}
