/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.mapper.console;

import org.springframework.stereotype.Service;

import com.angel.erp.common.mybatis.CustomerMapper;
import com.angel.erp.model.console.AdminDO;

/**
 * ADD FUNCTION
 *
 * @date: 2017年12月4日 下午2:32:58
 * @author li_ming 
 */
@Service
public interface AdminMapper extends CustomerMapper<AdminDO> {
	AdminDO selectByUsername(String username);

	void deleteById(String Id);
}
