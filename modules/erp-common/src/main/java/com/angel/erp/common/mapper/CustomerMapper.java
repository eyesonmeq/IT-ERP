/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 继承自己的MyMapper
 *
 * @date: 2017年12月3日 下午10:40:57
 * @author li_ming 
 */
public interface CustomerMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
