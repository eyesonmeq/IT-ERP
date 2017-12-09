package com.angel.erp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.angel.erp.common.util.JsonUtil;

/**
 * 系统用户
 *
 * @date: 2017年12月9日 下午6:13:44
 * @author li_ming 
 */
@Table(name = "sys_user")
public class SysUserDO implements Serializable {
	private static final long serialVersionUID = 8500968401115848516L;

	/**
	 * 账户
	 */
	@Id
	@Column(name = "ACCOUNT")
	private String account;

	/**
	 * 姓名
	 */
	@NotBlank
	@Size(min = 1, max = 50)
	@Pattern(regexp = "^[a-zA-Z_][\\w]{4,19}$", message = "{user.name.pattern.error}")
	@Column(name = "NAME")
	private String name;

	/**
	 * 密码
	 */
	@Size(min = 6, max = 25, message = "{user.password.length.error}")
	@Column(name = "PASSWORD")
	private String password;

	/**
	 * 状态
	 */
	@Column(name = "STATE")
	private Short state;

	/**
	 * 盐
	 */
	@Column(name = "SALT")
	private String salt;

	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_TIME")
	private Date createTime;

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
	 * 获取姓名
	 *
	 * @return NAME - 姓名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置姓名
	 *
	 * @param name 姓名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取密码
	 *
	 * @return PASSWORD - 密码
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置密码
	 *
	 * @param password 密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取状态
	 *
	 * @return STATE - 状态
	 */
	public Short getState() {
		return state;
	}

	/**
	 * 设置状态
	 *
	 * @param state 状态
	 */
	public void setState(Short state) {
		this.state = state;
	}

	/**
	 * 获取盐
	 *
	 * @return SALT - 盐
	 */
	public String getSalt() {
		return salt;
	}

	/**
	 * 设置盐
	 *
	 * @param salt 盐
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}

	/**
	 * 获取创建时间
	 *
	 * @return CREATE_TIME - 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置创建时间
	 *
	 * @param createTime 创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		SysUserDO other = (SysUserDO) obj;
		if (account == null) {
			if (other.account != null) {
				return false;
			}
		} else if (!account.equals(other.account)) {
			return false;
		}
		return true;
	}
}