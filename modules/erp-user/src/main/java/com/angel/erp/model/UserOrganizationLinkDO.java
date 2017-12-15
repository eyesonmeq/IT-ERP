package com.angel.erp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户机构关系
 *
 * @date: 2017年12月15日 下午11:57:31
 * @author li_ming 
 */
@Table(name = "user_organization_link")
public class UserOrganizationLinkDO {

	/**
	 * 用户主键
	 */
	@Id
	@Column(name = "user_id")
	private Long userId;

	/**
	 * 组织主键
	 */
	@Id
	@Column(name = "org_id")
	private Long orgId;

	/**
	 * 获取用户主键
	 *
	 * @return user_id - 用户主键
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * 设置用户主键
	 *
	 * @param userId 用户主键
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * 获取组织主键
	 *
	 * @return org_id - 组织主键
	 */
	public Long getOrgId() {
		return orgId;
	}

	/**
	 * 设置组织主键
	 *
	 * @param orgId 组织主键
	 */
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
}