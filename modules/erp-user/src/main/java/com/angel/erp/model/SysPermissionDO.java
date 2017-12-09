package com.angel.erp.model;

import java.io.Serializable;

import javax.persistence.*;

import com.angel.erp.common.util.JsonUtil;

/**
 * 系统权限
 *
 * @date: 2017年12月9日 下午8:43:01
 * @author li_ming 
 */
@Table(name = "sys_permission")
public class SysPermissionDO implements Serializable {
	private static final long serialVersionUID = 718754713091249426L;

	/**
	 * 主键
	 */
	@Id
	@Column(name = "CODE")
	private String code;

	/**
	 * 主键
	 */
	@Column(name = "SYS_CODE")
	private String sysCode;

	/**
	 * 账户
	 */
	@Column(name = "ACCOUNT")
	private String account;

	/**
	 * 名称
	 */
	@Column(name = "NAME")
	private String name;

	/**
	 * 动作
	 */
	@Column(name = "ACTION")
	private String action;

	/**
	 * 父权限
	 */
	@Column(name = "PARENT_ID")
	private String parentId;

	/**
	 * 获取主键
	 *
	 * @return CODE - 主键
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置主键
	 *
	 * @param code 主键
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 获取主键
	 *
	 * @return SYS_CODE - 主键
	 */
	public String getSysCode() {
		return sysCode;
	}

	/**
	 * 设置主键
	 *
	 * @param sysCode 主键
	 */
	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}

	/**
	 * 获取账户
	 *
	 * @return ACCOUNT - 账户
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * 设置账户
	 *
	 * @param account 账户
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * 获取名称
	 *
	 * @return NAME - 名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置名称
	 *
	 * @param name 名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取动作
	 *
	 * @return ACTION - 动作
	 */
	public String getAction() {
		return action;
	}

	/**
	 * 设置动作
	 *
	 * @param action 动作
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * 获取父权限
	 *
	 * @return PARENT_ID - 父权限
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * 设置父权限
	 *
	 * @param parentId 父权限
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return JsonUtil.toJson(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		SysPermissionDO other = (SysPermissionDO) obj;
		if (code == null) {
			if (other.code != null) {
				return false;
			}
		} else if (!code.equals(other.code)) {
			return false;
		}
		return true;
	}
}