/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.service;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.angel.erp.common.exception.ServiceException;
import com.angel.erp.common.mybatis.CustomerMapper;

/**
 * 基于通用MyBatis Mapper插件的Service接口的实现
 *
 * @date: 2017年12月6日 下午11:53:13
 * @author li_ming 
 */
public abstract class AbstractService<T> implements Service<T> {
	@Autowired
	protected CustomerMapper<T> mapper;

	private Class<T> modelClass; // 当前泛型真实类型的Class

	public AbstractService() {
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		modelClass = (Class<T>) pt.getActualTypeArguments()[0];
	}

	@Override
	public void save(T model) {
		mapper.insertSelective(model);
	}

	@Override
	public void save(List<T> models) {
		mapper.insertList(models);
	}

	@Override
	public void deleteById(Object id) {
		mapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteByIds(Object[] ids) {
		for (Object id : ids) {
			mapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public void update(T model) {
		mapper.updateByPrimaryKeySelective(model);
	}

	@Override
	public T getById(Object id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public T getBy(String fieldName, Object value) throws ServiceException {
		try {
			T model = modelClass.newInstance();
			Field field = modelClass.getDeclaredField(fieldName);
			field.setAccessible(true);
			field.set(model, value);
			return mapper.selectOne(model);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<T> listAll() {
		return mapper.selectAll();
	}
}
