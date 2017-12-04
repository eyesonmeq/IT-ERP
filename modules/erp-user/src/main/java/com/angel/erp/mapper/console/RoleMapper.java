/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.mapper.console;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.angel.erp.common.mybatis.CustomerMapper;
import com.angel.erp.model.console.RoleDO;

/**
 * ADD FUNCTION
 *
 * @date: 2017年12月4日 下午2:35:18
 * @author li_ming 
 */
@Service
public interface RoleMapper extends CustomerMapper<RoleDO> {
	Set<String> findRoleByUserId(String userId);

	List<RoleDO> selectRoleListByAdminId(String Id);
}
