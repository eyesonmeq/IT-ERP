/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.dto;

import java.io.Serializable;
import java.util.List;

import com.angel.erp.common.util.JsonUtil;

/**
 * 分页对象
 *
 * @date: 2017年12月9日 下午9:41:23
 * @author li_ming 
 */
public class PageDTO<T> implements Serializable {

	private static final long serialVersionUID = 8501035650459467858L;
	// 当前页数 
	private int currentPage = 1;
	// 每页条数
	private int pageSize = 10;
	// 查询条件
	private T queryriteria;
	// 总条数
	private int totalCount;
	// 数据
	private List<T> list;

	public PageDTO() {}

	public PageDTO(List<T> list, int totalCount) {
		this.list = list;
		this.totalCount = totalCount;
	}

	/**
	 * 获取开始行
	 *
	 * @return 
	 */
	public int getStartRow() {
		return (currentPage - 1) * pageSize;
	}

	/**
	 * @return the currentPage
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * @return the queryriteria
	 */
	public T getQueryriteria() {
		return queryriteria;
	}

	/**
	 * @param queryriteria the queryriteria to set
	 */
	public void setQueryriteria(T queryriteria) {
		this.queryriteria = queryriteria;
	}

	/**
	 * @return the list
	 */
	public List<T> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<T> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return JsonUtil.toJson(this);
	}
}
