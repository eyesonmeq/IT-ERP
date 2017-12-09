/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp;

import org.junit.Test;

import com.angel.erp.common.util.CodeGeneratorUtil;

/**
 * ADD FUNCTION
 *
 * @date: 2017年12月9日 下午6:06:43
 * @author li_ming 
 */
public class CodeGeneratorUtilTest {
	@Test
	public void genCode() {
		CodeGeneratorUtil.genCode("sys_user", "sys_log", "sys_organization", "sys_permission", "sys_role",
				"user_organization_relationship", "user_role_relationship");
	}
}
