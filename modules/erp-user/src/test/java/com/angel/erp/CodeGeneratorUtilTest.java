/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp;

import com.angel.erp.common.util.CodeGeneratorUtil;

/**
 * ADD FUNCTION
 *
 * @date: 2017年12月9日 下午6:06:43
 * @author li_ming 
 */
public class CodeGeneratorUtilTest {
	
	public static void main(String[] args) {
		CodeGeneratorUtil.genCode("sys_user", "sys_log", "sys_organization", "sys_permission", "sys_role",
				"user_organization_link", "user_role_link","role_permission_link","user_permission_link");
	}
}
