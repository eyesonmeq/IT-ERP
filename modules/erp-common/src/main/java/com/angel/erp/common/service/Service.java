/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.service;

import java.util.List;

import com.angel.erp.common.exception.ServiceException;

/**
 * Service 层 基础接口，其他Service 接口 请继承该接口
 *
 * @date: 2017年12月6日 下午11:16:51
 * @author li_ming 
 */
public interface Service<T> {
	/**
	 * 添加
	 *
	 * @param model 
	 */
	void save(T model);

	/**
	 * 批量添加
	 *
	 * @param models 
	 */
	void save(List<T> models);

	/**
	 * 根据主键删除
	 *
	 * @param id 
	 */
	void deleteById(Object id);

	/**
	 * 批量刪除
	 *
	 * @param ids 
	 */
	void deleteByIds(Object[] ids);

	/**
	 * 更新
	 *
	 * @param model 
	 */
	void update(T model);//更新

	/**
	 * 根据主键查询
	 *
	 * @param id
	 * @return 
	 */
	T getById(Object id);

	/**
	 * 通过Model中某个成员变量名称查找,value需符合unique约束
	 *
	 * @param fieldName
	 * @param value
	 * @return
	 * @throws ServiceException 
	 */
	T getBy(String fieldName, Object value) throws ServiceException;

	/**
	 * 查询所有数据
	 *
	 * @return 
	 */
	List<T> listAll();
}
