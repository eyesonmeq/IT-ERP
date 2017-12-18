/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.assertj.core.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.angel.erp.common.constant.JWTConstant;
import com.angel.erp.common.dto.AuthenticationTokenDTO;
import com.angel.erp.common.dto.PageDTO;
import com.angel.erp.common.dto.system.SysUserDTO;
import com.angel.erp.common.exception.ServiceException;
import com.angel.erp.common.util.security.JwtUtil;
import com.angel.erp.mapper.SysUserMapper;
import com.angel.erp.model.SysUserDO;
import com.angel.erp.service.SysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;

/**
 * 系统用户业务服务实现
 *
 * @date: 2017年12月9日 下午9:09:07
 * @author li_ming 
 */
@Service
public class SysUserServiceImpl implements SysUserService {
	/**
	 * 系统用户Mapper
	 */
	@Autowired
	private SysUserMapper userMapper;
	/**
	 * redis客户端
	 */
	@Autowired
	private RedisTemplate<String, AuthenticationTokenDTO> redisTemplate;

	/* 
	 * @see com.angel.erp.service.SysUserService#listByPage(com.angel.erp.common.dto.PageDTO, com.angel.erp.common.dto.system.SysUserDTO)
	 */
	@Override
	public PageDTO<SysUserDTO> listByPage(PageDTO<SysUserDTO> page, SysUserDTO queryCondition) throws ServiceException {
		Example example = new Example(SysUserDTO.class);
		example.createCriteria().andEqualTo("userName", queryCondition.getUserName());
		PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
		List<SysUserDO> doList = userMapper.selectByExample(example);
		List<SysUserDTO> dtoList = new ArrayList<SysUserDTO>();
		for (SysUserDO obj : doList) {
			dtoList.add(obj.toDTO());
		}
		PageInfo<SysUserDO> pageInfo = new PageInfo<SysUserDO>(doList);
		PageDTO<SysUserDTO> pageDto = new PageDTO<SysUserDTO>(dtoList, pageInfo.getTotal());
		return pageDto;
	}

	/* 
	 * @see com.angel.erp.service.SysUserService#listAll()
	 */
	@Override
	public List<SysUserDTO> listAll() throws ServiceException {
		List<SysUserDO> doList = userMapper.selectAll();
		List<SysUserDTO> dtoList = new ArrayList<SysUserDTO>();
		for (SysUserDO obj : doList) {
			dtoList.add(obj.toDTO());
		}
		return dtoList;
	}

	/* 
	 * @see com.angel.erp.service.SysUserService#get(java.lang.Long)
	 */
	@Override
	public SysUserDTO get(Long id) throws ServiceException {
		SysUserDO sysUser = userMapper.selectByPrimaryKey(id);
		if (sysUser != null) {
			return sysUser.toDTO();
		} else {
			return null;
		}
	}

	/* 
	 * @see com.angel.erp.service.SysUserService#getByName(java.lang.String)
	 */
	@Override
	public SysUserDTO getByName(String userName) throws ServiceException {
		SysUserDO queryCondition = new SysUserDO();
		queryCondition.setUserName(userName);
		SysUserDO sysUser = userMapper.selectOne(queryCondition);
		if (sysUser != null) {
			return sysUser.toDTO();
		} else {
			return null;
		}
	}

	/* 
	 * @see com.angel.erp.service.SysUserService#insert(com.angel.erp.common.dto.system.SysUserDTO)
	 */
	@Override
	public void insert(SysUserDTO user) throws ServiceException {
		SysUserDO sysUser = new SysUserDO(user);
		sysUser.setGmtCreate(DateUtil.now());
		sysUser.setGmtModified(DateUtil.now());
		userMapper.insert(sysUser);
	}

	/* 
	 * @see com.angel.erp.service.SysUserService#update(com.angel.erp.common.dto.system.SysUserDTO)
	 */
	@Override
	@Transactional(rollbackFor = { ServiceException.class })
	public void update(SysUserDTO user) throws ServiceException {
		SysUserDO sysUser = new SysUserDO(user);
		sysUser.setGmtModified(DateUtil.now());
		userMapper.updateByPrimaryKey(sysUser);
	}

	/* 
	 * @see com.angel.erp.service.SysUserService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) throws ServiceException {
		SysUserDO sysUser = userMapper.selectByPrimaryKey(id);
		if (sysUser != null) {
			userMapper.delete(sysUser);
		}
	}

	/* 
	 * @see com.angel.erp.service.SysUserService#deleteByUserName(java.lang.String)
	 */
	@Override
	public void deleteByUserName(String userName) throws ServiceException {
		SysUserDO queryCondition = new SysUserDO();
		queryCondition.setUserName(userName);
		SysUserDO sysUser = userMapper.selectOne(queryCondition);
		if (sysUser != null) {
			userMapper.delete(sysUser);
		}
	}

	/* 
	 * @see com.angel.erp.service.SysUserService#login(com.angel.erp.common.dto.AuthenticationTokenDTO)
	 */
	@Override
	public AuthenticationTokenDTO login(AuthenticationTokenDTO token) throws ServiceException {
		SysUserDO queryCondition = new SysUserDO();
		queryCondition.setUserName(token.getUserName());
		SysUserDO sysUser = userMapper.selectOne(queryCondition);

		if (sysUser == null) {
			throw new ServiceException("用户不存在");
		}
		String saltPwd = JwtUtil.createPwd(token.getAuth(), sysUser.getSalt());
		if (!saltPwd.equals(sysUser.getUserPassword())) {
			throw new ServiceException("用户名或密码不正确");
		}
		token.setToken(JwtUtil.createJWT(sysUser.getUserName(), sysUser.getUserPassword()));
		token.setAuth(saltPwd);
		redisTemplate.opsForValue().set(JWTConstant.TOKENHEAD + token.getUserName(), token);
		Subject subject = SecurityUtils.getSubject();
		subject.login(token);
		return token;
	}

}
