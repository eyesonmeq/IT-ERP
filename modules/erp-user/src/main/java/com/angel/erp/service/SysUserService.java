/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.service;

import java.util.List;

import com.angel.erp.common.dto.AuthenticationTokenDTO;
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
	 * @param queryCondition
	 * @return
	 * @throws ServiceException 
	 */
	PageDTO<SysUserDTO> listByPage(PageDTO<SysUserDTO> page, SysUserDTO queryCondition) throws ServiceException;

	/**
	 * 查询所有数据
	 *
	 * @return
	 * @throws ServiceException 
	 */
	List<SysUserDTO> listAll() throws ServiceException;

	/**
	 * 根据ID查询
	 *
	 * @param id
	 * @return
	 * @throws ServiceException 
	 */
	SysUserDTO get(Long id) throws ServiceException;

	/**
	 * 根据用户名查询
	 *
	 * @param userName
	 * @return
	 * @throws ServiceException 
	 */
	SysUserDTO getByName(String userName) throws ServiceException;

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
	 * @param id
	 * @throws ServiceException 
	 */
	void delete(Long id) throws ServiceException;

	/**
	 * 根据用户名删除
	 *
	 * @param userName
	 * @throws ServiceException 
	 */
	void deleteByUserName(String userName) throws ServiceException;
	
	/**
	 * 用户登录
	 *
	 * @param token
	 * @return
	 * @throws ServiceException 
	 */
	AuthenticationTokenDTO login(AuthenticationTokenDTO token) throws ServiceException;
}
