package com.angel.erp.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import com.angel.erp.common.util.JsonUtil;

/**
 * 系统日志
 *
 * @date: 2017年12月9日 下午8:41:49
 * @author li_ming 
 */
@Table(name = "sys_log")
public class SysLogDO implements Serializable {
	// (用一句话描述这个变量表示什么). 
	private static final long serialVersionUID = -1442097246389575238L;

	/**
	 * 主键
	 */
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 账户
	 */
	@Column(name = "SYS_ACCOUNT")
	private String sysAccount;

	/**
	 * 活动
	 */
	@Column(name = "ACTION")
	private String action;

	/**
	 * 资源
	 */
	@Column(name = "RES")
	private String res;

	/**
	 * 账户
	 */
	@Column(name = "ACCOUNT")
	private String account;

	/**
	 * 访问IP
	 */
	@Column(name = "IP")
	private String ip;

	/**
	 * 记录时间
	 */
	@Column(name = "LOG_TIME")
	private Date logTime;

	/**
	 * 参数
	 */
	@Column(name = "PARAMTERS")
	private String paramters;

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

	/**
	 * 获取账户
	 *
	 * @return SYS_ACCOUNT - 账户
	 */
	public String getSysAccount() {
		return sysAccount;
	}

	/**
	 * 设置账户
	 *
	 * @param sysAccount 账户
	 */
	public void setSysAccount(String sysAccount) {
		this.sysAccount = sysAccount;
	}

	/**
	 * 获取活动
	 *
	 * @return ACTION - 活动
	 */
	public String getAction() {
		return action;
	}

	/**
	 * 设置活动
	 *
	 * @param action 活动
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * 获取资源
	 *
	 * @return RES - 资源
	 */
	public String getRes() {
		return res;
	}

	/**
	 * 设置资源
	 *
	 * @param res 资源
	 */
	public void setRes(String res) {
		this.res = res;
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
	 * 获取访问IP
	 *
	 * @return IP - 访问IP
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * 设置访问IP
	 *
	 * @param ip 访问IP
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * 获取记录时间
	 *
	 * @return LOG_TIME - 记录时间
	 */
	public Date getLogTime() {
		return logTime;
	}

	/**
	 * 设置记录时间
	 *
	 * @param logTime 记录时间
	 */
	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}

	/**
	 * 获取参数
	 *
	 * @return PARAMTERS - 参数
	 */
	public String getParamters() {
		return paramters;
	}

	/**
	 * 设置参数
	 *
	 * @param paramters 参数
	 */
	public void setParamters(String paramters) {
		this.paramters = paramters;
	}

	@Override
	public String toString() {
		return JsonUtil.toJson(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((logTime == null) ? 0 : logTime.hashCode());
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
		SysLogDO other = (SysLogDO) obj;
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