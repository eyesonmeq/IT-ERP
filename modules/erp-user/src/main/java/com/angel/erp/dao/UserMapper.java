/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.dao;

import com.angel.erp.model.UserDO;

import tk.mybatis.mapper.common.Mapper;

/**
 * ADD FUNCTION
 *
 * @date: 2017年12月3日 下午10:11:30
 * @author li_ming 
 */
public interface UserMapper extends Mapper<UserDO> {
	UserDO getUserByAccount(String account);
}
