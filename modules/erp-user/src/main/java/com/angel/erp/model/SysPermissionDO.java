package com.angel.erp.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import com.angel.erp.common.util.JsonUtil;

/**
 * 系统权限
 *
 * @date: 2017年12月15日 下午11:10:18
 * @author li_ming 
 */
@Table(name = "sys_permission")
public class SysPermissionDO implements Serializable {
	private static final long serialVersionUID = 718754713091249426L;

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
	 * 权限编码
	 */
	@Column(name = "permission_code")
	private String permissionCode;

	/**
	 * 权限名称
	 */
	@Column(name = "permission_name")
	private String permissionName;

	/**
	 * url
	 */
	private String url;

	/**
	 * 父权限
	 */
	@Column(name = "parent_id")
	private Long parentId;

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
	 * 获取权限编码
	 *
	 * @return permission_code - 权限编码
	 */
	public String getPermissionCode() {
		return permissionCode;
	}

	/**
	 * 设置权限编码
	 *
	 * @param permissionCode 权限编码
	 */
	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}

	/**
	 * 获取权限名称
	 *
	 * @return permission_name - 权限名称
	 */
	public String getPermissionName() {
		return permissionName;
	}

	/**
	 * 设置权限名称
	 *
	 * @param permissionName 权限名称
	 */
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	/**
	 * 获取url
	 *
	 * @return url - url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 设置url
	 *
	 * @param url url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 获取父权限
	 *
	 * @return parent_id - 父权限
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * 设置父权限
	 *
	 * @param parentId 父权限
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
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
		result = prime * result + ((permissionCode == null) ? 0 : permissionCode.hashCode());
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
		SysPermissionDO other = (SysPermissionDO) obj;
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
		if (permissionCode == null) {
			if (other.permissionCode != null)
				return false;
		} else if (!permissionCode.equals(other.permissionCode))
			return false;
		return true;
	}

}