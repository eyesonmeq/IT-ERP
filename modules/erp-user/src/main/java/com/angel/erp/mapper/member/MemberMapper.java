/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.mapper.member;

import org.springframework.stereotype.Service;

import com.angel.erp.common.mybatis.CustomerMapper;
import com.angel.erp.model.member.MemberDO;

/**
 * ADD FUNCTION
 *
 * @date: 2017年12月4日 下午2:37:04
 * @author li_ming 
 */
@Service
public interface MemberMapper extends CustomerMapper<MemberDO> {
	MemberDO selectByUsername(String username);
}
