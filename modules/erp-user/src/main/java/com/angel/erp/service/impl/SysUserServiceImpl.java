/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angel.erp.common.dto.PageDTO;
import com.angel.erp.common.dto.system.SysUserDTO;
import com.angel.erp.common.exception.ServiceException;
import com.angel.erp.mapper.SysUserMapper;
import com.angel.erp.service.SysUserService;

/**
 * 系统用户业务服务实现
 *
 * @date: 2017年12月9日 下午9:09:07
 * @author li_ming 
 */
@Service
public class SysUserServiceImpl implements SysUserService {
	// 系统用户Mapper
	@Autowired
	private SysUserMapper userMapper;

	/* 
	 * @see com.angel.erp.service.SysUserService#listByPage(com.angel.erp.common.dto.PageDTO)
	 */
	@Override
	public PageDTO<SysUserDTO> listByPage(PageDTO<SysUserDTO> page) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	/* 
	 * @see com.angel.erp.service.SysUserService#listAll()
	 */
	@Override
	public List<SysUserDTO> listAll() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	/* 
	 * @see com.angel.erp.service.SysUserService#get(java.lang.String)
	 */
	@Override
	public SysUserDTO get(String account) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	/* 
	 * @see com.angel.erp.service.SysUserService#insert(com.angel.erp.common.dto.system.SysUserDTO)
	 */
	@Override
	public void insert(SysUserDTO user) throws ServiceException {
		// TODO Auto-generated method stub

	}

	/* 
	 * @see com.angel.erp.service.SysUserService#update(com.angel.erp.common.dto.system.SysUserDTO)
	 */
	@Override
	public void update(SysUserDTO user) throws ServiceException {
		// TODO Auto-generated method stub

	}

	/* 
	 * @see com.angel.erp.service.SysUserService#delete(java.lang.String)
	 */
	@Override
	public void delete(String account) throws ServiceException {
		// TODO Auto-generated method stub

	}

}
