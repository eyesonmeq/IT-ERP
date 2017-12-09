/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.service;

import java.util.List;

import com.angel.erp.common.dto.PageDTO;
import com.angel.erp.common.dto.system.SysUserDTO;
import com.angel.erp.common.exception.ServiceException;

/**
 * 系统用户业务服务接口
 *
 * @date: 2017年12月9日 下午8:54:49
 * @author li_ming 
 */
public interface SysUserService {
	/**
	 * 分页查询
	 *
	 * @param page
	 * @return
	 * @throws ServiceException 
	 */
	PageDTO<SysUserDTO> listByPage(PageDTO<SysUserDTO> page) throws ServiceException;

	/**
	 * 查询所有数据
	 *
	 * @return
	 * @throws ServiceException 
	 */
	List<SysUserDTO> listAll() throws ServiceException;

	/**
	 * 根据ID获取数据
	 *
	 * @param account
	 * @return
	 * @throws ServiceException 
	 */
	SysUserDTO get(String account) throws ServiceException;

	/**
	 * 添加
	 *
	 * @param user
	 * @throws ServiceException 
	 */
	void insert(SysUserDTO user) throws ServiceException;

	/**
	 * 更新
	 *
	 * @param user
	 * @throws ServiceException 
	 */
	void update(SysUserDTO user) throws ServiceException;

	/**
	 * 删除
	 *
	 * @param account
	 * @throws ServiceException 
	 */
	void delete(String account) throws ServiceException;
}
