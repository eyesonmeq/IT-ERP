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
	private Integer currentPage = 1;
	// 每页条数
	private Integer pageSize = 10;
	// 查询条件
	private T queryriteria;
	// 总条数
	private Long totalCount;
	// 数据
	private List<T> list;

	public PageDTO() {
		this.currentPage = 1;
		this.pageSize = 10;
	}

	public PageDTO(List<T> list, Long totalCount) {
		this.currentPage = 1;
		this.pageSize = 10;
		this.list = list;
		this.totalCount = totalCount;
	}

	/**
	 * 获取开始行
	 *
	 * @return 
	 */
	public Integer getStartRow() {
		return (currentPage - 1) * pageSize;
	}

	/**
	 * @return the currentPage
	 */
	public Integer getCurrentPage() {
		return currentPage;
	}

	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the totalCount
	 */
	public Long getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(Long totalCount) {
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
