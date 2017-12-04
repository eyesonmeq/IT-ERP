/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.service.console;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angel.erp.model.console.AdminRoleDO;

import tk.mybatis.mapper.entity.Example;

/**
 * ADD FUNCTION
 *
 * @date: 2017年12月4日 下午2:48:35
 * @author li_ming 
 */
@Service
public class AdminRoleService {
	@Autowired
	private AdminRoleMapper adminRoleMapper;

	public void insert(AdminRoleDO adminRole) {
		adminRoleMapper.insert(adminRole);
	}

	public void deleteAdminId(String id) {
		Example example = new Example(AdminRoleDO.class);
		example.createCriteria().andCondition("admin_id =", id);
		adminRoleMapper.deleteByExample(example);
	}

	public void deleteRoleId(String id) {
		Example example = new Example(AdminRoleDO.class);
		example.createCriteria().andCondition("role_id =", id);
		adminRoleMapper.deleteByExample(example);
	}

	public AdminRoleDO selectOne(AdminRoleDO adminRole) {
		return adminRoleMapper.selectOne(adminRole);
	}

	public List<AdminRoleDO> getRoleList(AdminRoleDO adminRole) {
		return adminRoleMapper.select(adminRole);
	}
}
