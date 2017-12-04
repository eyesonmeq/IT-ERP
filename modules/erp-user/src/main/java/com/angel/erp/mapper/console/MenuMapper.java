/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.mapper.console;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.angel.erp.common.mybatis.CustomerMapper;
import com.angel.erp.model.console.MenuDO;

/**
 * ADD FUNCTION
 *
 * @date: 2017年12月4日 下午2:34:14
 * @author li_ming 
 */
@Service
public interface MenuMapper extends CustomerMapper<MenuDO> {
	Set<String> findMenuCodeByUserId(String userId);

	Set<String> getALLMenuCode();

	List<MenuDO> selectMenuByAdminId(String userId);

	List<MenuDO> selectAllMenu();

	List<MenuDO> selectMenuByRoleId(String roleId);
}
