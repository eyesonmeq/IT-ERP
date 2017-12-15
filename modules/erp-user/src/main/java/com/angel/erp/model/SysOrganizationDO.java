package com.angel.erp.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import com.angel.erp.common.util.JsonUtil;

/**
 * 系统机构
 *
 * @date: 2017年12月15日 下午11:08:52
 * @author li_ming 
 */
@Table(name = "sys_organization")
public class SysOrganizationDO implements Serializable {
	private static final long serialVersionUID = -8540450968869051494L;

	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 创建时间
	 */
	@Column(name = "gmt_create")
	private Date gmtCreate;

	/**
	 * 变更时间
	 */
	@Column(name = "gmt_modified")
	private Date gmtModified;

	/**
	 * 所属上级
	 */
	@Column(name = "parent_id")
	private Long parentId;

	/**
	 * 组织名称
	 */
	@Column(name = "org_name")
	private String orgName;

	/**
	 * 获取主键
	 *
	 * @return id - 主键
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置主键
	 *
	 * @param id 主键
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取创建时间
	 *
	 * @return gmt_create - 创建时间
	 */
	public Date getGmtCreate() {
		return gmtCreate;
	}

	/**
	 * 设置创建时间
	 *
	 * @param gmtCreate 创建时间
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	/**
	 * 获取变更时间
	 *
	 * @return gmt_modified - 变更时间
	 */
	public Date getGmtModified() {
		return gmtModified;
	}

	/**
	 * 设置变更时间
	 *
	 * @param gmtModified 变更时间
	 */
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	/**
	 * 获取所属上级
	 *
	 * @return parent_id - 所属上级
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * 设置所属上级
	 *
	 * @param parentId 所属上级
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * 获取组织名称
	 *
	 * @return org_name - 组织名称
	 */
	public String getOrgName() {
		return orgName;
	}

	/**
	 * 设置组织名称
	 *
	 * @param orgName 组织名称
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@Override
	public String toString() {
		return JsonUtil.toJson(this);
	}

	/* 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gmtCreate == null) ? 0 : gmtCreate.hashCode());
		result = prime * result + ((gmtModified == null) ? 0 : gmtModified.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((orgName == null) ? 0 : orgName.hashCode());
		return result;
	}

	/* 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SysOrganizationDO other = (SysOrganizationDO) obj;
		if (gmtCreate == null) {
			if (other.gmtCreate != null)
				return false;
		} else if (!gmtCreate.equals(other.gmtCreate))
			return false;
		if (gmtModified == null) {
			if (other.gmtModified != null)
				return false;
		} else if (!gmtModified.equals(other.gmtModified))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (orgName == null) {
			if (other.orgName != null)
				return false;
		} else if (!orgName.equals(other.orgName))
			return false;
		return true;
	}

}