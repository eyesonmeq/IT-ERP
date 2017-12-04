/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.service.console;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angel.erp.common.util.CamelCaseUtil;
import com.angel.erp.mapper.console.AdminMapper;
import com.angel.erp.model.console.AdminDO;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;

/**
 * ADD FUNCTION
 *
 * @date: 2017年12月4日 下午2:52:15
 * @author li_ming 
 */
@Service
public class AdminService {
	@Autowired
	private AdminMapper adminMapper;

	public List<AdminDO> getPageList(AdminDO admin) {
		PageHelper.offsetPage(admin.getOffset(), admin.getLimit(),
				CamelCaseUtil.toUnderlineName(admin.getSort()) + " " + admin.getOrder());
		return adminMapper.selectAll();
	}

	public Integer getCount(Example example) {
		return adminMapper.selectCountByExample(example);
	}

	public AdminDO getById(String id) {
		return adminMapper.selectByPrimaryKey(id);
	}

	public AdminDO findByUsername(String username) {
		return adminMapper.selectByUsername(username);
	}

	public void deleteById(String id) {
		adminMapper.deleteByPrimaryKey(id);
	}

	public void insert(AdminDO admin) {
		adminMapper.insert(admin);
	}

	public void save(AdminDO admin) {
		if (admin.getUid() != null) {
			adminMapper.updateByPrimaryKey(admin);
		} else {
			adminMapper.insert(admin);
		}
	}

	public void updateExample(AdminDO admin, Example example) {
		adminMapper.updateByExampleSelective(admin, example);
	}

}
