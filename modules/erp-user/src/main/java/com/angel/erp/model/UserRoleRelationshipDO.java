package com.angel.erp.model;

import java.io.Serializable;

import javax.persistence.*;

import com.angel.erp.common.util.JsonUtil;

/**
 * 用户角色关系
 *
 * @date: 2017年12月9日 下午8:45:00
 * @author li_ming 
 */
@Table(name = "user_role_relationship")
public class UserRoleRelationshipDO implements Serializable {
	private static final long serialVersionUID = -492490474120590333L;

	/**
	 * 账户
	 */
	@Id
	@Column(name = "ACCOUNT")
	private String account;

	/**
	 * 主键
	 */
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

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
	 * 获取主键
	 *
	 * @return ID - 主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置主键
	 *
	 * @param id 主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return JsonUtil.toJson(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		UserRoleRelationshipDO other = (UserRoleRelationshipDO) obj;
		if (account == null) {
			if (other.account != null) {
				return false;
			}
		} else if (!account.equals(other.account)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
}